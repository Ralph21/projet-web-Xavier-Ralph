-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Ven 26 Février 2016 à 11:10
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `basedetest`
--

-- --------------------------------------------------------

--
-- Structure de la table `car`
--

CREATE TABLE IF NOT EXISTS `car` (
  `id_car` int(11) NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) DEFAULT NULL,
  `fuel` varchar(255) DEFAULT NULL,
  `gearbox` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `paint` varchar(255) DEFAULT NULL,
  `power` int(11) DEFAULT NULL,
  `transmission` varchar(255) DEFAULT NULL,
  `vignette` varchar(255) DEFAULT NULL,
  `wheels` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_car`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `car`
--

INSERT INTO `car` (`id_car`, `brand`, `fuel`, `gearbox`, `model`, `paint`, `power`, `transmission`, `vignette`, `wheels`) VALUES
(1, 'Audi', NULL, NULL, 'A3', NULL, NULL, NULL, 'css/images/audix5.jpg', NULL),
(2, 'Audi', NULL, NULL, 'Q5', NULL, NULL, NULL, 'css/images/audix6.jpg', NULL),
(3, 'Volkswagen', NULL, NULL, 'Golf', NULL, NULL, NULL, 'css/images/vwx5.jpg', NULL),
(4, 'Volkswagen', NULL, NULL, 'Tiguan', NULL, NULL, NULL, 'css/images/vwx6.jpg', NULL),
(5, NULL, 'Diesel', 'Automatique', NULL, 'Bleu métallisé', 150, 'Traction', NULL, '18');

-- --------------------------------------------------------

--
-- Structure de la table `car_equipements`
--

CREATE TABLE IF NOT EXISTS `car_equipements` (
  `car_idCar` int(11) NOT NULL,
  `equipements_idEquipement` int(11) NOT NULL,
  UNIQUE KEY `UK_411pmu08vct71vtqksps6shaw` (`equipements_idEquipement`),
  KEY `FK_g4lc29bwe7an4vlxt25998teh` (`car_idCar`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `car_equipements`
--

INSERT INTO `car_equipements` (`car_idCar`, `equipements_idEquipement`) VALUES
(1, 1),
(1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `equipement`
--

CREATE TABLE IF NOT EXISTS `equipement` (
  `id_equipement` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_equipement`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `equipement`
--

INSERT INTO `equipement` (`id_equipement`, `libelle`) VALUES
(1, 'Sièges cuir'),
(2, 'climatisation 50 zones');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id_utilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` int(11) NOT NULL,
  `first_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sexe` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_utilisateur`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`id_utilisateur`, `age`, `email`, `enabled`, `first_name`, `last_name`, `password`, `sexe`, `username`) VALUES
(1, 24, 'ralph.gaume@gmail.com', 1, 'Ralph', 'Gaume', '$2a$10$EmPKg2L9GBGL6EkFbUOcteBg/lLPxniDY61f30SytYE9O/Fg8Ximi', 'Homme', 'ralph.gaume@gmail.com'),
(2, 24, 'xavier.simon@gmail.com', 1, 'Xavier', 'Simon', '$2a$10$HGEZImUqPi0OAK5g3JXzX.4HPsYsQRyRaNSJ1tY8lH0Zwzn7xaspG', 'Homme', 'xavier.simon@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `user_roles`
--

CREATE TABLE IF NOT EXISTS `user_roles` (
  `id_role` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `utilisateur_id` int(11) NOT NULL,
  PRIMARY KEY (`id_role`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `user_roles`
--

INSERT INTO `user_roles` (`id_role`, `role`, `username`, `utilisateur_id`) VALUES
(1, 'ROLE_ADMIN', 'ralph.gaume@gmail.com', 1),
(2, 'ROLE_USER', 'xavier.simon@gmail.com', 2);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `car_equipements`
--
ALTER TABLE `car_equipements`
  ADD CONSTRAINT `FK_411pmu08vct71vtqksps6shaw` FOREIGN KEY (`equipements_idEquipement`) REFERENCES `equipement` (`id_equipement`),
  ADD CONSTRAINT `FK_g4lc29bwe7an4vlxt25998teh` FOREIGN KEY (`car_idCar`) REFERENCES `car` (`id_car`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
