-- DROP DATABASE
DROP IF EXISTS nominal;

-- CREATE DATABASE && USE
CREATE DATABASE nominal;
USE nominal;

-- AUTHOR: Carlos Pomares (https://www.github.com/pomaretta)
-- DB Version: 1.0

-- CREATE TABLES

-- EMPLOYEES
CREATE TABLE employees (
    id              VARCHAR(32) NOT NULL,
    dni             VARCHAR(9) NOT NULL,
    name            VARCHAR(50) NOT NULL,
    name_2          VARCHAR(50) NULL,
    lastname        VARCHAR(50) NOT NULL,
    lastname_2      VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE employees_contact (
    id              VARCHAR(32) NOT NULL,
    mail_addr       VARCHAR(255) NOT NULL,
    street_addr     VARCHAR(255) NOT NULL,
    phone           VARCHAR(9) NOT NULL,
    PRIMARY KEY (id,mail_addr),
    CONSTRAINT fk_id REFERENCES employees (id) DELETE ON CASCADE
)

CREATE TABLE employees_contract (
    id              VARCHAR(32) NOT NULL,
    date            TIMESTAMP DEFAULT NOW(),
    category        INT NOT NULL,
    quotation       INT NOT NULL,
    PRIMARY KEY (id,date)
    CONSTRAINT fk_id REFERENCES employees (id)
)

-- COMPANY-DATA
CREATE TABLE company (
    id              VARCHAR(32) NOT NULL,
    cif             VARCHAR(8) NOT NULL,
    name            VARCHAR(255) NOT NULL
    PRIMARY KEY (id)
)

-- CURRENCY

-- APPLICATION
-- SALARY TABLES
-- ANTIQUITY TABLES
-- COMPANY TYPE

-- DYNAMIC

-- EMPLOYEE SCHEDULE
-- SALARY EXPEDITION

-- API

-- AUTHENTICATION
-- API KEYS
-- PAYROLL ROUTES
-- EMPLOYEE IMAGE
-- ATTACHMENTS