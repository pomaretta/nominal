-- #####################################
--           NOMINAL DATABASE
-- #####################################

-- REVISION: 2.0
-- DATE: 21/04/2021
-- AUTHORS
--      CARLOS POMARES (https://www.github.com/pomaretta)
--      ADÁN INAREJOS (https://github.com/ainarejos)
--      JOSHUA MAS (https://github.com/JoshuaMas)

-- #####################################
-- CREATE DATABASE
-- #####################################

DROP DATABASE IF EXISTS nominal;
CREATE DATABASE nominal;
USE nominal;

-- #####################################
-- CREATE MASTER TABLES
-- #####################################

CREATE TABLE company (

    created_at              TIMESTAMP DEFAULT NOW(),

    id                      INT NOT NULL AUTO_INCREMENT,
    name                    VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE employee (

    created_at              TIMESTAMP DEFAULT NOW(),

    id                      INT NOT NULL AUTO_INCREMENT,
    passport                VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE agreement (

    created_at              TIMESTAMP DEFAULT NOW(),

    id                      INT NOT NULL AUTO_INCREMENT,
    name                    VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE payroll (

    created_at              TIMESTAMP DEFAULT NOW(),

    id                      INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (id)
);

CREATE TABLE schedule (

    created_at              TIMESTAMP DEFAULT NOW(),

    id                      INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (id)
);

-- #####################################
-- CREATE COMMON TABLES
-- #####################################

CREATE TABLE employee_category (

    agreement               INT NOT NULL,

    id                      INT NOT NULL AUTO_INCREMENT,
    name                    VARCHAR(255) NOT NULL,
    level                   INT NOT NULL,
    
    PRIMARY KEY (id,name),
    FOREIGN KEY (agreement) REFERENCES agreement (id)
);

CREATE TABLE company_quotation_type (

    agreement               INT NOT NULL,

    id                      INT NOT NULL AUTO_INCREMENT,
    title                   VARCHAR(255) NOT NULL,
    category                INT NOT NULL,
    
    PRIMARY KEY (id),
    FOREIGN KEY (agreement) REFERENCES agreement (id)
);

CREATE TABLE company_currency (

    id                      INT NOT NULL AUTO_INCREMENT,
    currency_digit          VARCHAR(3) NOT NULL,
    currency_name           VARCHAR(255) NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE employee_salary_values (

    agreement               INT NOT NULL,
    created_at              TIMESTAMP DEFAULT NOW(),

    id                      INT NOT NULL AUTO_INCREMENT,
    category                INT NOT NULL,
    quotation               INT NOT NULL,
    value                   FLOAT NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (agreement) REFERENCES agreement (id),
    FOREIGN KEY (category) REFERENCES employee_category (id),
    FOREIGN KEY (quotation) REFERENCES company_quotation_type (id)
);

CREATE TABLE employee_antiquity_values (

    agreement               INT NOT NULL,
    created_at              TIMESTAMP DEFAULT NOW(),

    id                      INT NOT NULL AUTO_INCREMENT,
    category                INT NOT NULL,
    quotation               INT NOT NULL,
    years                   INT NOT NULL,
    value                   FLOAT NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (agreement) REFERENCES agreement (id),
    FOREIGN KEY (category) REFERENCES employee_category (id),
    FOREIGN KEY (quotation) REFERENCES company_quotation_type (id)
);

-- #####################################
-- CREATE COMPANY TABLES
-- #####################################

CREATE TABLE company_information (

    company                 INT NOT NULL,

    cif                     VARCHAR(255) NOT NULL,

    PRIMARY KEY (company),
    CONSTRAINT company_information_id
        FOREIGN KEY (company)
        REFERENCES company (id)
);

CREATE TABLE company_contact (

    company                 INT NOT NULL,

    street_address          VARCHAR(255) NOT NULL,
    state                   VARCHAR(255) NOT NULL,
    phone_number            VARCHAR(255) NOT NULL,

    PRIMARY KEY (company),
    CONSTRAINT company_contact_id
        FOREIGN KEY (company)
        REFERENCES company (id)
);

CREATE TABLE company_financial (

    company                 INT NOT NULL,

    currency                INT NOT NULL,
    quotation_group         INT NOT NULL,
    social_security_id      VARCHAR(255) NOT NULL,

    PRIMARY KEY (company),
    CONSTRAINT company_financial_id
        FOREIGN KEY (company)
        REFERENCES company (id),
    FOREIGN KEY (currency) REFERENCES company_currency (id),
    FOREIGN KEY (quotation_group) REFERENCES company_quotation_type (id)
);

-- #####################################
-- CREATE EMPLOYEE TABLES
-- #####################################

CREATE TABLE employee_information (

    employee                INT NOT NULL,
    created_at              TIMESTAMP DEFAULT NOW(),

    name                    VARCHAR(255) NOT NULL,
    name_2                  VARCHAR(255),
    lastname                VARCHAR(255) NOT NULL,
    lastname_2              VARCHAR(255) NOT NULL,
    
    active                  BOOLEAN DEFAULT 1,
    apportion               BOOLEAN DEFAULT 0,

    PRIMARY KEY (employee),
    CONSTRAINT employee_information_id
        FOREIGN KEY (employee)
        REFERENCES employee (id)
);

CREATE TABLE employee_contact (

    employee                INT NOT NULL,
    created_at              TIMESTAMP DEFAULT NOW(),

    email_address           VARCHAR(255),
    street_address          VARCHAR(255),
    phone_number            VARCHAR(255),

    PRIMARY KEY (employee),
    CONSTRAINT employee_contact_id
        FOREIGN KEY (employee)
        REFERENCES employee (id)
);

CREATE TABLE employee_contract (

    employee                INT NOT NULL,
    created_at              TIMESTAMP DEFAULT NOW(),

    company                 INT NOT NULL,
    join_date               DATE NOT NULL,
    category                INT NOT NULL,
    irpf                    FLOAT NOT NULL,
    hourly                  BOOLEAN DEFAULT 0,
    hired_hours             FLOAT DEFAULT 0,

    PRIMARY KEY (employee,company,created_at),
    CONSTRAINT employee_contract_id
        FOREIGN KEY (employee)
        REFERENCES employee (id),
    CONSTRAINT employee_company_id
        FOREIGN KEY (company)
        REFERENCES company (id),
    FOREIGN KEY (category) REFERENCES employee_category (id)
);

-- #####################################
-- CREATE SCHEDULE TABLES
-- #####################################

CREATE TABLE schedule_extra_hours (

    schedule                INT NOT NULL,
    created_at              TIMESTAMP DEFAULT NOW(),

    ordinary_hours          FLOAT DEFAULT 0,
    overwhelming_hours      FLOAT DEFAULT 0,

    PRIMARY KEY (schedule,created_at),
    CONSTRAINT schedule_extra_hours_id
        FOREIGN KEY (schedule)
        REFERENCES schedule (id)

);

CREATE TABLE schedule_employee (

    schedule                INT NOT NULL,
    created_at              TIMESTAMP DEFAULT NOW(),

    date_from               DATE NOT NULL,
    date_to                 DATE NOT NULL,

    nocturnal               BOOLEAN DEFAULT 0,
    turnicity               BOOLEAN DEFAULT 0,
    complementary_hours     FLOAT DEFAULT 0,
    hired_hours             FLOAT NOT NULL,

    PRIMARY KEY (schedule,created_at),
    CONSTRAINT schedule_employee_id
        FOREIGN KEY (schedule)
        REFERENCES schedule (id)
);

-- #####################################
-- CREATE PAYROLL TABLES
-- #####################################

CREATE TABLE payroll_complement (

    payroll                 INT NOT NULL,

    title                   VARCHAR(255) NOT NULL,
    salarial                BOOLEAN DEFAULT 1,

    value_original          FLOAT NOT NULL,
    value_percentage        FLOAT NOT NULL,
    value                   FLOAT NOT NULL,

    PRIMARY KEY (payroll,title),
    CONSTRAINT payroll_complement_id
        FOREIGN KEY (payroll)
        REFERENCES payroll (id)
);

CREATE TABLE payroll_data (

    payroll                 INT NOT NULL,
    created_at              TIMESTAMP DEFAULT NOW(),

    -- COMPANY

    company_id              INT,
    company_name            VARCHAR(255),
    company_street_address  VARCHAR(255),
    company_state           VARCHAR(255),
    company_cif             VARCHAR(255),
    company_ssi             VARCHAR(255),
    

    -- AGREEMENT

    company_agreement_id    INT,
    company_agreement_name  VARCHAR(255),

    -- EMPLOYEE

    employee_id             INT,
    employee_name           VARCHAR(255),
    employee_nif            VARCHAR(255),
    employee_naf            VARCHAR(255),

    -- CATEGORY

    employee_category_agr   INT,
    employee_category_id    INT,
    employee_category_nm    VARCHAR(255),
    employee_category_lvl   INT,

    -- QUOTATION

    employee_quotation_agr  INT,
    employee_quotation_id   INT,
    employee_quotation_nm   VARCHAR(255),
    employee_quotation_cat  INT,

    -- DATE
    date_from               DATE NOT NULL,
    date_to                 DATE NOT NULL,
    date_total_days         INT NOT NULL,

    -- BASE SALARY
    base_salary             FLOAT,

    -- SCHEDULE
    schedule                INT,

    -- APPORTION
    employee_apportion      BOOLEAN,
    apportion               BOOLEAN,

    -- SALARY KIND
    salary_kind             FLOAT,

    -- TOTAL EARNED
    total_earned            FLOAT,

    -- COMMON CONTINGENCY
    cc_percentage           FLOAT,
    cc_value                FLOAT,

    -- UNEMPLOYMENT
    unemployment_percentage FLOAT,
    unemployment_value      FLOAT,

    -- VOCATIONAL TRAINING
    training_percentage     FLOAT,
    training_value          FLOAT,
    
    -- OVERWHELMING HOURS REDUCTION
    oh_percentage           FLOAT,
    oh_value                FLOAT,

    -- EXTRA HOURS REDUCTION
    eh_percentage           FLOAT,
    eh_value                FLOAT,

    -- TOTAL APORTATIONS
    total_aportations       FLOAT,

    -- IRPF
    irpf_percentage         FLOAT,
    irpf_value              FLOAT,

    -- ADVANCE
    advance_pays            FLOAT,
    
    -- SALARY KIND REDUCTION
    sk_reduction            FLOAT,

    -- OTHER REDUCTIONS
    other_reduction         FLOAT,

    -- TOTAL REDUCTIONS
    total_deduction         FLOAT,

    -- TOTAL TO RECEIVE
    total_to_receive        FLOAT,

    PRIMARY KEY (payroll),
    CONSTRAINT payroll_data_id
        FOREIGN KEY (payroll)
        REFERENCES payroll (id),
    FOREIGN KEY (schedule) REFERENCES schedule (id)
);