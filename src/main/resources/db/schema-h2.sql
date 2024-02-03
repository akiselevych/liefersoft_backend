DROP TABLE IF EXISTS users;
CREATE TABLE public.users
(
    id                 INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    first_name         VARCHAR(250)                   NOT NULL,
    last_name          VARCHAR(250)                   NOT NULL,
    gender             VARCHAR(50)                    NOT NULL,
    phone              INT                            NOT NULL,
    creation_date      TIMESTAMP,
    last_modified_date TIMESTAMP
);

