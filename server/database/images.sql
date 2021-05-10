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

CREATE TABLE image (

    created_at          TIMESTAMP DEFAULT NOW(),
    id                  INT NOT NULL AUTO_INCREMENT,
    image               BLOB NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE user_image (

    user                INT NOT NULL,
    created_at          TIMESTAMP DEFAULT NOW(),
    
    image               INT NOT NULL,
    
    PRIMARY KEY (user,created_at),
    CONSTRAINT fk_user FOREIGN KEY (user) REFERENCES nominal_auth.user (id),
    FOREIGN KEY (image) REFERENCES nominal_images.image (id)
);

CREATE TABLE company_image (

    company             INT NOT NULL,
    created_at          TIMESTAMP DEFAULT NOW(),

    image               INT NOT NULL,

    PRIMARY KEY (company,created_at),
    CONSTRAINT fk_company FOREIGN KEY (company) REFERENCES nominal.company (id),
    FOREIGN KEY (image) REFERENCES nominal_images.image (id)
);

CREATE TABLE employee_image (

    employee            INT NOT NULL,
    created_at          TIMESTAMP DEFAULT NOW(),

    image               INT NOT NULL,

    PRIMARY KEY (employee,created_at),
    CONSTRAINT fk_employee FOREIGN KEY (employee) REFERENCES nominal.employee (id),
    FOREIGN KEY (image) REFERENCES nominal_images.image (id)
);