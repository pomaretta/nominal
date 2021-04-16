-- DROP DATABASE
DROP DATABASE IF EXISTS nominal;

-- CREATE DATABASE && USE
CREATE DATABASE nominal;
USE nominal;

-- AUTHOR: Carlos Pomares (https://www.github.com/pomaretta)
-- DB Version: 1.0

-- CREATE TABLES

-- COMMON

-- EMPLOYEE
CREATE TABLE employee_category (
    id              INT NOT NULL AUTO_INCREMENT,
    name            VARCHAR(255) NOT NULL,
    level           INT NOT NULL,
    
    PRIMARY KEY (id,name),
    INDEX lvl_index (level)
);
-- END EMPLOYEE

-- COMPANY
CREATE TABLE quotation_type (
    id              INT NOT NULL AUTO_INCREMENT,
    title           VARCHAR(255) NOT NULL,
    category        INT NOT NULL,

    PRIMARY KEY (id),
    INDEX in_category (category)
);
CREATE TABLE currency (
    id              INT NOT NULL AUTO_INCREMENT,
    currency_digit  VARCHAR(3) NOT NULL,
    currency_name   VARCHAR(255) NOT NULL,

    PRIMARY KEY (id)
);
-- END COMPANY

-- SALARY
CREATE TABLE salary_level (
    id              INT NOT NULL AUTO_INCREMENT,
    level           INT NOT NULL,

    PRIMARY KEY (id,level)
);
-- END SALARY

-- EMPLOYEES
CREATE TABLE employees (
    id              VARCHAR(32) NOT NULL,
    dni             VARCHAR(9) NOT NULL,
    name            VARCHAR(50) NOT NULL,
    name_2          VARCHAR(50) NOT NULL,
    lastname        VARCHAR(50) NOT NULL,
    lastname_2      VARCHAR(50) NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE employees_contact (
    id              VARCHAR(32) NOT NULL,
    mail_addr       VARCHAR(255) NOT NULL,
    street_addr     VARCHAR(255) NOT NULL,
    phone           VARCHAR(12) NOT NULL,

    PRIMARY KEY (id,mail_addr,phone),
    UNIQUE (mail_addr,phone),

    CONSTRAINT fk_contact_id 
        FOREIGN KEY (id)
        REFERENCES employees (id)
        ON UPDATE CASCADE ON DELETE CASCADE

);

CREATE TABLE employees_contract (
    id              VARCHAR(32) NOT NULL,
    date            TIMESTAMP DEFAULT NOW(),
    category        INT NOT NULL,
    quotation       INT NOT NULL,
    irpf            FLOAT NOT NULL,

    PRIMARY KEY (id,date),

    CONSTRAINT fk_contract_id
        FOREIGN KEY (id)
        REFERENCES employees(id)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY (category) REFERENCES employee_category (id),
    FOREIGN KEY (quotation) REFERENCES quotation_type (id)
);

-- COMPANY-DATA
CREATE TABLE company (
    id              VARCHAR(32) NOT NULL,
    cif             VARCHAR(8) NOT NULL,
    name            VARCHAR(255) NOT NULL,

    PRIMARY KEY (id)
);

-- COMPANY CONTACT
CREATE TABLE company_contact (
    id              VARCHAR(32) NOT NULL,
    street_addr     VARCHAR(255) NOT NULL,
    phone_number    VARCHAR(12) NOT NULL,

    PRIMARY KEY (id),
    CONSTRAINT fk_company_contact_id
        FOREIGN KEY (id)
        REFERENCES company (id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

-- COMPANY FINANCIAL TYPE
CREATE TABLE company_financial (
    id              VARCHAR(32) NOT NULL,
    currency        INT NOT NULL,
    quotation_group INT NOT NULL,
    social_security VARCHAR(255) NOT NULL,

    PRIMARY KEY (id),
    CONSTRAINT fk_company_financial_id
        FOREIGN KEY (id)
        REFERENCES company (id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (currency) REFERENCES currency (id),
    FOREIGN KEY (quotation_group) REFERENCES quotation_type (id)
);

-- SALARY TABLES
CREATE TABLE salary_values (
    id              INT NOT NULL AUTO_INCREMENT,
    category        INT NOT NULL,
    level           INT NOT NULL,
    value           FLOAT NOT NULL,

    PRIMARY KEY (id,category,level),
    FOREIGN KEY (category) REFERENCES company_financial (quotation_group),
    FOREIGN KEY (level) REFERENCES employees_contract (category)
);

-- ANTIQUITY TABLES
CREATE TABLE antiquity_values (
    id                  INT NOT NULL AUTO_INCREMENT,
    level               INT NOT NULL,
    company_category    INT NOT NULL,
    category            INT NOT NULL,
    value               FLOAT NOT NULL,

    PRIMARY KEY (id,level,company_category,category),
    FOREIGN KEY (level) REFERENCES employees_contract (category)
);

-- DYNAMIC

-- EMPLOYEE SCHEDULE
CREATE TABLE extra_hours (
    id                  INT NOT NULL AUTO_INCREMENT,
    employee            VARCHAR(32) NOT NULL,
    date_from           DATE NOT NULL,
    date_to             DATE NOT NULL,
    ordinary_hours      FLOAT NOT NULL,
    overwhelming_hours  FLOAT NOT NULL DEFAULT 0,

    PRIMARY KEY (id,employee,date_from,date_to),
    CONSTRAINT fk_employee_hours
        FOREIGN KEY (employee)
        REFERENCES employees (id)
        ON UPDATE CASCADE
);

CREATE TABLE employees_schedule (
    id                  INT NOT NULL AUTO_INCREMENT,
    initial_date        DATE NOT NULL,
    final_date          DATE NOT NULL,
    employee            VARCHAR(32) NOT NULL,
    extra_hours         INT NOT NULL,
    nocturnal           BOOLEAN NOT NULL,
    turnicity           BOOLEAN NOT NULL,

    PRIMARY KEY (id,initial_date,final_date,employee),
    CONSTRAINT fk_employee
        FOREIGN KEY (employee)
        REFERENCES employees (id)
        ON DELETE RESTRICT,
    FOREIGN KEY (extra_hours) REFERENCES extra_hours (id)
);

-- SALARY EXPEDITION
CREATE TABLE salaries (
    id              INT NOT NULL AUTO_INCREMENT,
    employee        VARCHAR(32) NOT NULL,
    date            TIMESTAMP DEFAULT NOW(),

    PRIMARY KEY(id,employee,date),
    CONSTRAINT fk_employee_salary
        FOREIGN KEY (employee)
        REFERENCES employees (id)
        ON UPDATE CASCADE ON DELETE RESTRICT
);

-- API
-- AUTHENTICATION
-- API KEYS
-- PAYROLL ROUTES
-- EMPLOYEE IMAGE
-- ATTACHMENTS