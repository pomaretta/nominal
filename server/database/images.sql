-- #####################################
--           NOMINAL IMAGE DATABASE
-- #####################################

-- REVISION: 1.0
-- DATE: 10/05/2021
-- AUTHORS
--      CARLOS POMARES (https://www.github.com/pomaretta)
--      ADÁN INAREJOS (https://github.com/ainarejos)
--      JOSHUA MAS (https://github.com/Masmayer)

DROP IF EXISTS nominal_images;
CREATE DATABASE nominal_images;
USE nominal_images;

CREATE TABLE user_image (

    user                INT NOT NULL,
    id                  INT NOT NULL AUTO_INCREMENT,
    created_at          TIMESTAMP DEFAULT NOW(),

    image               BLOB NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (user) REFERENCES nominal_auth.user (id)
);

CREATE TABLE company_image (

    company             INT NOT NULL,
    id                  INT NOT NULL AUTO_INCREMENT,
    created_at          TIMESTAMP DEFAULT NOW(),

    image               BLOB NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (company) REFERENCES nominal.company (id)
);

CREATE TABLE employee_image (

    employee            INT NOT NULL,
    id                  INT NOT NULL AUTO_INCREMENT,
    created_at          TIMESTAMP DEFAULT NOW(),

    image               BLOB NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (employee) REFERENCES nominal.employee (id)
);