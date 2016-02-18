
CREATE  TABLE utilisateur (
    idUtilisateur BIGINT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    age TINYINT UNSIGNED NOT NULL,
    sexe VARCHAR(5) NOT NULL,
    email VARCHAR(40) NOT NULL,
    password VARCHAR(60) NOT NULL ,
    enabled TINYINT NOT NULL DEFAULT 1 ,
PRIMARY KEY (idUtilisateur));

CREATE TABLE utilisateur_role (
    idRole int(11) NOT NULL,
    descriptif varchar(45) NOT NULL,
    idUtilisateur BIGINT NOT NULL,
    PRIMARY KEY (idRole),
    KEY fk_idUtilisateur (idUtilisateur),
    CONSTRAINT fk_idUtilisateur FOREIGN KEY (idUtilisateur) REFERENCES utilisateur (idUtilisateur));