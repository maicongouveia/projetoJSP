-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Máquina: 127.0.0.1
-- Data de Criação: 30-Out-2013 às 20:24
-- Versão do servidor: 5.5.32
-- versão do PHP: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de Dados: `aeroporto`
--
CREATE DATABASE IF NOT EXISTS `aeroporto` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `aeroporto`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `aeronave`
--

CREATE TABLE IF NOT EXISTS `aeronave` (
  `codigo` smallint(6) NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) NOT NULL,
  `fileira` int(5) NOT NULL,
  `coluna` int(5) NOT NULL,
  `acentos` decimal(10,0) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Extraindo dados da tabela `aeronave`
--

INSERT INTO `aeronave` (`codigo`, `nome`, `fileira`, `coluna`, `acentos`, `tipo`) VALUES
(2, 'Jatinho do Maicon', 2, 5, '10', 'Pequeno Porte'),
(3, 'Jumbo', 2, 5, '10', 'Grande Porte'),
(4, 'Airbus A380', 10, 10, '100', 'Transporte'),
(5, 'Airbus B540', 10, 20, '200', 'Transporte'),
(6, 'Airbus A330', 10, 25, '250', 'Transporte'),
(7, 'Airbus Service', 2, 1, '2', 'Carga'),
(8, 'Airbus Service', 2, 2, '4', 'Carga'),
(9, 'Jumbo Medio', 7, 9, '35', 'Carga');

-- --------------------------------------------------------

--
-- Estrutura da tabela `assentos`
--

CREATE TABLE IF NOT EXISTS `assentos` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `codigoVoo` int(6) unsigned zerofill NOT NULL,
  `codigoAeronave` smallint(6) NOT NULL,
  `coluna` int(5) NOT NULL,
  `fileira` int(5) NOT NULL,
  PRIMARY KEY (`id`,`codigoVoo`,`codigoAeronave`),
  KEY `codigoVoo` (`codigoVoo`),
  KEY `codigoAeronave` (`codigoAeronave`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `escalas`
--

CREATE TABLE IF NOT EXISTS `escalas` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `idVoo` smallint(6) NOT NULL,
  `cidade` varchar(30) NOT NULL,
  `ordem` int(2) NOT NULL,
  PRIMARY KEY (`id`,`idVoo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pagamento`
--

CREATE TABLE IF NOT EXISTS `pagamento` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `idPassagem` int(10) NOT NULL,
  `nomeTitular` varchar(50) NOT NULL,
  `valorTotal` varchar(10) NOT NULL,
  `dataPagto` date NOT NULL,
  `cpf` varchar(20) NOT NULL,
  PRIMARY KEY (`id`,`idPassagem`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pagamentocheque`
--

CREATE TABLE IF NOT EXISTS `pagamentocheque` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `idPagamento` int(10) NOT NULL,
  `banco` int(4) NOT NULL,
  `agencia` int(10) NOT NULL,
  `conta` int(15) NOT NULL,
  PRIMARY KEY (`id`,`idPagamento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `passageiro`
--

CREATE TABLE IF NOT EXISTS `passageiro` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `idPassagem` int(10) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `sobrenome` varchar(50) NOT NULL,
  `dataNascimento` date NOT NULL,
  `formaTratamento` int(2) NOT NULL,
  `tipoPassageiro` int(2) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telefone` int(15) NOT NULL,
  PRIMARY KEY (`id`,`idPassagem`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `passagem`
--

CREATE TABLE IF NOT EXISTS `passagem` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `idVoo` smallint(6) NOT NULL,
  `idPassageiro` int(10) NOT NULL,
  `idAssento` int(10) NOT NULL,
  `data` date NOT NULL,
  `hora` time NOT NULL,
  PRIMARY KEY (`id`,`idVoo`,`idPassageiro`,`idAssento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `passagemcompra`
--

CREATE TABLE IF NOT EXISTS `passagemcompra` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `idPassagem` int(10) NOT NULL,
  `desconto` int(2) NOT NULL,
  `ticket` int(20) NOT NULL,
  PRIMARY KEY (`id`,`idPassagem`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `passagemreserva`
--

CREATE TABLE IF NOT EXISTS `passagemreserva` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `idPassagem` int(10) NOT NULL,
  `numRegistro` int(20) NOT NULL,
  `validade` date NOT NULL,
  PRIMARY KEY (`id`,`idPassagem`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `voo`
--

CREATE TABLE IF NOT EXISTS `voo` (
  `codigo` int(6) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `origem` varchar(60) NOT NULL,
  `destino` varchar(60) NOT NULL,
  `data_dia` date NOT NULL,
  `hora` time NOT NULL,
  `status_vo` varchar(60) NOT NULL,
  `valor` varchar(10) NOT NULL,
  `cod_aeronave` smallint(6) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `cod_aeronave` (`cod_aeronave`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Extraindo dados da tabela `voo`
--

INSERT INTO `voo` (`codigo`, `origem`, `destino`, `data_dia`, `hora`, `status_vo`, `valor`, `cod_aeronave`) VALUES
(000004, 'São Paulo', 'Rio de Janeiro', '2014-02-05', '13:00:00', 'Confirmado', '250.00', 4),
(000005, 'São Paulo', 'Minas Gerais', '2014-05-20', '14:00:00', 'Confirmado', '500.00', 6),
(000006, 'São Paulo', 'Mato Grosso', '2014-02-15', '15:00:00', 'Confirmado', '550.00', 6),
(000007, 'Rio de Janeiro', 'São Paulo', '2014-06-10', '20:00:00', 'Confirmado', '150.00', 5),
(000008, 'Rio de Janeiro', 'Minas Gerais', '2014-06-15', '21:00:00', 'Confirmado', '300.00', 5),
(000009, 'Rio de Janeiro', 'Mato Grosso', '2014-06-25', '21:00:00', 'Confirmado', '300.00', 5),
(000010, 'Minas Gerais', 'São Paulo', '2014-07-30', '08:00:00', 'Confirmado', '350.00', 5),
(000011, 'Minas Gerais', 'Rio de Janeiro', '2014-07-25', '10:00:00', 'Confirmado', '150.00', 5),
(000012, 'Minas Gerais', 'Mato Grosso', '2013-07-20', '12:00:00', 'Confirmado', '320.00', 2),
(000013, 'Mato Grosso', 'São Paulo', '2014-08-30', '11:00:00', 'Confirmado', '350.00', 5),
(000014, 'Mato Grosso', 'Rio de Janeiro', '2014-08-25', '13:00:00', 'Confirmado', '400.00', 5),
(000015, 'Mato Grosso', 'Minas Gerais', '2014-08-20', '14:30:00', 'Confirmado', '200.00', 6);

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `assentos`
--
ALTER TABLE `assentos`
  ADD CONSTRAINT `assentos_ibfk_1` FOREIGN KEY (`codigoVoo`) REFERENCES `voo` (`codigo`),
  ADD CONSTRAINT `assentos_ibfk_2` FOREIGN KEY (`codigoAeronave`) REFERENCES `aeronave` (`codigo`);

--
-- Limitadores para a tabela `voo`
--
ALTER TABLE `voo`
  ADD CONSTRAINT `voo_ibfk_1` FOREIGN KEY (`cod_aeronave`) REFERENCES `aeronave` (`codigo`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
