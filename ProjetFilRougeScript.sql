CREATE DATABASE adopteunchat COLLATE utf8_general_ci;

USE adopteunchat;

CREATE TABLE chat (
    CHAT_ID INT AUTO_INCREMENT NOT NULL, 
    CHAT_NOM VARCHAR (50) NOT NULL,
    CHAT_SEXE ENUM ('M', 'F') NOT NULL,
    CHAT_AGE INT NOT NULL,
    CHAT_TRANCHEAGE ENUM ('Bébé', 'Junior', 'Adulte', 'Senior') NOT NULL,
    CHAT_RACE INT NOT NULL,
    CHAT_COLOR INT NOT NULL,
    CHAT_TAILLE ENUM ('Petit', 'Moyen', 'Grand') NOT NULL,
    CHAT_REG INT NOT NULL,
    CHAT_DPT INT NOT NULL,
    CHAT_PHOTO VARCHAR (100) NOT NULL,
    CHAT_DESC VARCHAR (500),
    CHAT_ENFANT BIT NOT NULL DEFAULT 0,
    CHAT_CHIEN  BIT NOT NULL DEFAULT 0,
    CHAT_CHAT  BIT NOT NULL DEFAULT 0,
    CHAT_SPECIFIQUE BIT NOT NULL DEFAULT 0,
    PRIMARY KEY (CHAT_ID)
) ENGINE = InnoDb;

CREATE TABLE race (
    RACE_ID INT AUTO_INCREMENT NOT NULL,
    RACE_LIBELLE VARCHAR (50) NOT NULL,
    PRIMARY KEY (RACE_ID)
) ENGINE = InnoDb;

CREATE TABLE color (
    COLOR_ID INT AUTO_INCREMENT NOT NULL,
    COLOR_LIBELLE VARCHAR (50) NOT NULL,
    PRIMARY KEY (COLOR_ID)
) ENGINE = InnoDb;

CREATE TABLE region (
    REGION_ID INT AUTO_INCREMENT NOT NULL,
    REGION_LIBELLE VARCHAR (50) NOT NULL,
    PRIMARY KEY (REGION_ID) 
) ENGINE = InnoDb;

CREATE TABLE dpt (
    DPT_ID INT AUTO_INCREMENT NOT NULL,
    DPT_REGION INT NOT NULL,
    DPT_LIBELLE VARCHAR (50) NOT NULL,
    PRIMARY KEY (DPT_ID) 
) ENGINE = InnoDb;

CREATE TABLE personne (
    PER_ID INT AUTO_INCREMENT NOT NULL,
    PER_NOM VARCHAR(50) NOT NULL,
    PER_PRENOM VARCHAR(50) NOT NULL,
    PER_MAIL VARCHAR(150) NOT NULL,
    PER_TELEPHONE VARCHAR(20) NOT NULL,
    PER_ADRESSE VARCHAR(150) NOT NULL,
    PER_PASSWORD VARCHAR(300),
    PER_DATE_NAISSANCE DATE,
    PER_TYPE ENUM('Adoptant', 'Refuge') NOT NULL,
    PRIMARY KEY (PER_ID)
) ENGINE = InnoDb;

ALTER TABLE chat
    ADD CONSTRAINT FK_ChatRace
    FOREIGN KEY (CHAT_RACE)
    REFERENCES race (RACE_ID)
    ON DELETE RESTRICT;


ALTER TABLE chat
    ADD CONSTRAINT FK_ChatColor
    FOREIGN KEY (CHAT_COLOR)
    REFERENCES color (COLOR_ID)
    ON DELETE RESTRICT;


ALTER TABLE chat
    ADD CONSTRAINT FK_ChatRegion
    FOREIGN KEY (CHAT_REG)
    REFERENCES region (REGION_ID)
    ON DELETE RESTRICT;


ALTER TABLE chat
    ADD CONSTRAINT FK_Chatdpt
    FOREIGN KEY (CHAT_DPT)
    REFERENCES dpt (DPT_ID)
    ON DELETE RESTRICT;

ALTER TABLE dpt
    ADD CONSTRAINT FK_DptRegion
    FOREIGN KEY (DPT_REGION)
    REFERENCES region (REGION_ID)
    ON DELETE RESTRICT;


INSERT INTO personne (PER_NOM,PER_PRENOM, PER_MAIL, PER_TELEPHONE,PER_ADRESSE,
PER_PASSWORD,PER_DATE_NAISSANCE, PER_TYPE) 
values ('Dupont', 'Jean', 'jean.dupont@hotmail.fr', '0610101010', '10 rue de la place, 59000 Lille','123456','1964-01-01','Adoptant');

INSERT INTO personne (PER_NOM,PER_PRENOM, PER_MAIL, PER_TELEPHONE,PER_ADRESSE,
PER_PASSWORD,PER_DATE_NAISSANCE, PER_TYPE) 
values ('Dujardin', 'Alice', 'alice.dujardin@hotmail.fr', '0610101011', '14 rue du port, 59000 Lille','123456789','1987-06-13','Adoptant');

INSERT INTO personne (PER_NOM,PER_PRENOM, PER_MAIL, PER_TELEPHONE,PER_ADRESSE,
PER_PASSWORD, PER_TYPE) 
values ('SPA', 'Lille', 'spa.lille@hotmail.fr', '0610101000', '1 rue des chiens, 59000 Lille','123456123','Refuge');