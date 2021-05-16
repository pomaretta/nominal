-- #####################################
--           NOMINAL AUTH DATABASE
-- #####################################

-- REVISION: 1.0
-- DATE: 29/04/2021
-- AUTHORS
--      CARLOS POMARES (https://www.github.com/pomaretta)

-- #####################################
-- CREATE DATABASE
-- #####################################

DROP DATABASE IF EXISTS nominal_auth_dev;
CREATE DATABASE nominal_auth_dev;
USE nominal_auth_dev;

-- #####################################
-- CREATE MASTER TABLES
-- #####################################

CREATE TABLE user (

    created_at              TIMESTAMP DEFAULT NOW(),

    id                      INT NOT NULL AUTO_INCREMENT,
    name                    VARCHAR(255) NOT NULL,
    password                VARCHAR(32) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE privilege (

    created_at              TIMESTAMP DEFAULT NOW(),

    id                      INT NOT NULL AUTO_INCREMENT,
    name                    VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

-- #####################################
-- CREATE USER TABLES
-- #####################################

CREATE TABLE user_privelege (

    user                    INT NOT NULL,
    created_at              TIMESTAMP DEFAULT NOW(),
    id                      INT NOT NULL AUTO_INCREMENT,

    privilege               INT NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (user) REFERENCES user (id),
    FOREIGN KEY (privilege) REFERENCES privilege (id)
);

CREATE TABLE user_companies (

    user                    INT NOT NULL,
    created_at              TIMESTAMP DEFAULT NOW(),
    id                      INT NOT NULL AUTO_INCREMENT,

    company                 INT NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (user) REFERENCES user (id),
    FOREIGN KEY (company) REFERENCES nominal_dev.company (id)
);