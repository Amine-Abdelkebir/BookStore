-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le : jeu. 12 nov. 2020 à 13:49
-- Version du serveur :  5.7.24
-- Version de PHP : 7.2.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bookstore`
--

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `numCommande` varchar(20) COLLATE utf8_bin NOT NULL,
  `date` varchar(10) COLLATE utf8_bin NOT NULL,
  `adresse` varchar(50) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`numCommande`, `date`, `adresse`) VALUES
('230555', '15/11/2020', 'Tunis'),
('514984', '12/11/2020', 'Zarzis'),
('815538', '13/11/2020', 'Paris');

-- --------------------------------------------------------

--
-- Structure de la table `lignecommande`
--

CREATE TABLE `lignecommande` (
  `refLivre` varchar(20) COLLATE utf8_bin NOT NULL,
  `numCommande` varchar(20) COLLATE utf8_bin NOT NULL,
  `quantite` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `lignecommande`
--

INSERT INTO `lignecommande` (`refLivre`, `numCommande`, `quantite`) VALUES
('123', '230555', 3),
('123', '514984', 2),
('456', '514984', 3),
('456', '815538', 2),
('789', '230555', 2),
('789', '815538', 5);

-- --------------------------------------------------------

--
-- Structure de la table `livres`
--

CREATE TABLE `livres` (
  `refLivre` varchar(20) COLLATE utf8_bin NOT NULL,
  `titre` varchar(20) COLLATE utf8_bin NOT NULL,
  `auteur` varchar(20) COLLATE utf8_bin NOT NULL,
  `dateSortie` varchar(10) COLLATE utf8_bin NOT NULL,
  `quantite` int(11) NOT NULL,
  `prixUnitaire` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `livres`
--

INSERT INTO `livres` (`refLivre`, `titre`, `auteur`, `dateSortie`, `quantite`, `prixUnitaire`) VALUES
('123', 'Livre1', 'Amine', '15/07/2008', 75, 15500),
('456', 'Livre2', 'Ahmed', '30/05/1995', 12, 14000),
('789', 'Livre3', 'Khalil', '02/12/2015', 23, 6500);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`numCommande`);

--
-- Index pour la table `lignecommande`
--
ALTER TABLE `lignecommande`
  ADD PRIMARY KEY (`refLivre`,`numCommande`),
  ADD KEY `fk_num_commande` (`numCommande`);

--
-- Index pour la table `livres`
--
ALTER TABLE `livres`
  ADD PRIMARY KEY (`refLivre`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `lignecommande`
--
ALTER TABLE `lignecommande`
  ADD CONSTRAINT `fk_num_commande` FOREIGN KEY (`numCommande`) REFERENCES `commande` (`numCommande`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_ref_livre` FOREIGN KEY (`refLivre`) REFERENCES `livres` (`refLivre`) ON DELETE CASCADE ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
