-- #####################################
--           NOMINAL DATABASE
-- #####################################

-- REVISION: 3.1
-- DATE: 05/05/2021
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
    naf                     VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE(passport)
);

CREATE TABLE agreement (

    created_at              TIMESTAMP DEFAULT NOW(),

    id                      INT NOT NULL AUTO_INCREMENT,
    name                    VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

-- #####################################
-- UTILITY TABLES
-- #####################################

CREATE TABLE currency (
    
    id                      INT NOT NULL AUTO_INCREMENT,

    digit                   VARCHAR(3) NOT NULL,
    name                    VARCHAR(255) NOT NULL,

    PRIMARY KEY (id)
);

-- #####################################
-- CREATE AGREEMENT TABLES
-- #####################################

CREATE TABLE agreement_emp_category (

    agreement               INT NOT NULL,
    id                      INT NOT NULL AUTO_INCREMENT,

    name                    VARCHAR(255) NOT NULL,
    level                   INT NOT NULL,
    
    PRIMARY KEY (id),
    FOREIGN KEY (agreement) REFERENCES agreement (id)
);

CREATE TABLE agreement_com_quotation (

    agreement               INT NOT NULL,
    id                      INT NOT NULL AUTO_INCREMENT,

    name                    VARCHAR(255) NOT NULL,
    level                   INT NOT NULL,
    
    PRIMARY KEY (id),
    FOREIGN KEY (agreement) REFERENCES agreement (id)
);

CREATE TABLE employee_salary_values (

    agreement               INT NOT NULL,
    created_at              TIMESTAMP DEFAULT NOW(),
    id                      INT NOT NULL AUTO_INCREMENT,

    category                INT NOT NULL,
    quotation               INT NOT NULL,
    value                   FLOAT NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (agreement) REFERENCES agreement (id)
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
    FOREIGN KEY (agreement) REFERENCES agreement (id)
);

-- #####################################
-- CREATE COMPANY TABLES
-- #####################################

CREATE TABLE company_information (

    company                 INT NOT NULL,
    created_at              TIMESTAMP DEFAULT NOW(),
    id                      INT NOT NULL AUTO_INCREMENT,

    cif                     VARCHAR(255) NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (company) REFERENCES company (id)
);

CREATE TABLE company_contact (

    company                 INT NOT NULL,
    created_at              TIMESTAMP DEFAULT NOW(),
    id                      INT NOT NULL AUTO_INCREMENT,

    street_address          VARCHAR(255) NOT NULL,
    state                   VARCHAR(255) NOT NULL,
    phone_number            VARCHAR(255) NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (company) REFERENCES company (id)
);

CREATE TABLE company_financial (

    company                 INT NOT NULL,
    created_at              TIMESTAMP DEFAULT NOW(),
    id                      INT NOT NULL AUTO_INCREMENT,

    currency                INT NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (company) REFERENCES company (id),
    FOREIGN KEY (currency) REFERENCES currency (id)
);

-- #####################################
-- CREATE EMPLOYEE TABLES
-- #####################################

CREATE TABLE employee_information (

    employee                INT NOT NULL,
    created_at              TIMESTAMP DEFAULT NOW(),
    id                      INT NOT NULL AUTO_INCREMENT,

    name                    VARCHAR(255) NOT NULL,
    name_2                  VARCHAR(255),
    lastname                VARCHAR(255) NOT NULL,
    lastname_2              VARCHAR(255) NOT NULL,
    
    active                  BOOLEAN DEFAULT 1,
    apportion               BOOLEAN DEFAULT 0,

    PRIMARY KEY (id),
    FOREIGN KEY (employee) REFERENCES employee (id)
);

CREATE TABLE employee_contact (

    employee                INT NOT NULL,
    created_at              TIMESTAMP DEFAULT NOW(),
    id                      INT NOT NULL AUTO_INCREMENT,

    email_address           VARCHAR(255),
    street_address          VARCHAR(255),
    phone_number            VARCHAR(255),

    PRIMARY KEY (id),
    FOREIGN KEY (employee) REFERENCES employee (id)
);

CREATE TABLE employee_contract (

    employee                INT NOT NULL,
    created_at              TIMESTAMP DEFAULT NOW(),
    id                      INT NOT NULL AUTO_INCREMENT,

    category                INT NOT NULL,
    irpf                    FLOAT NOT NULL,
    hourly                  BOOLEAN DEFAULT 0,
    hired_hours             FLOAT DEFAULT 0,

    PRIMARY KEY (id),
    FOREIGN KEY (employee) REFERENCES employee (id)
);

CREATE TABLE employee_schedule (

    employee                INT NOT NULL,
    created_at              TIMESTAMP DEFAULT NOW(),
    id                      INT NOT NULL AUTO_INCREMENT,

    nocturnal               BOOLEAN DEFAULT 0,
    turnicity               BOOLEAN DEFAULT 0,
    complementary_hours     FLOAT DEFAULT 0,

    PRIMARY KEY (id),
    FOREIGN KEY (employee) REFERENCES employee (id)
);

-- #####################################
-- CREATE PAYROLL TABLES
-- #####################################

CREATE TABLE payroll (

    id                      INT NOT NULL AUTO_INCREMENT,
    created_at              TIMESTAMP DEFAULT NOW(),

    company                 INT NOT NULL,
    agreement               INT NOT NULL,
    employee                INT NOT NULL,

    -- DATE
    date_from               DATE NOT NULL,
    date_to                 DATE NOT NULL,
    date_total_days         INT NOT NULL,

    -- BASE SALARY
    base_salary             FLOAT,

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

    PRIMARY KEY (id),
    FOREIGN KEY (company) REFERENCES company (id),
    FOREIGN KEY (agreement) REFERENCES agreement (id),
    FOREIGN KEY (employee) REFERENCES employee (id)
);

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

-- #####################################
-- TRANSACTIONAL TABLES
-- #####################################

CREATE TABLE company_employee (
    
    id                      INT NOT NULL AUTO_INCREMENT,
    company                 INT NOT NULL,
    employee                INT NOT NULL,
    
    created_at              TIMESTAMP DEFAULT NOW(),
    join_date               DATE NOT NULL,
    expiration_date         DATE NULL,

    PRIMARY KEY (id,company,employee),
    CONSTRAINT company_emp_id
        FOREIGN KEY (company)
        REFERENCES company (id),
    CONSTRAINT employee_com_id
        FOREIGN KEY (employee)
        REFERENCES employee (id)
);

CREATE TABLE company_agreement (
    
    id                      INT NOT NULL AUTO_INCREMENT,
    company                 INT NOT NULL,
    agreement               INT NOT NULL,
    
    created_at              TIMESTAMP DEFAULT NOW(),

    PRIMARY KEY (id,company,agreement),
    CONSTRAINT company_agr_id
        FOREIGN KEY (company)
        REFERENCES company (id),
    CONSTRAINT agreement_com_id
        FOREIGN KEY (agreement)
        REFERENCES agreement (id)
);