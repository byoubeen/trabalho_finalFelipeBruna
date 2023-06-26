-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 26-Jun-2023 às 22:42
-- Versão do servidor: 10.4.27-MariaDB
-- versão do PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `personagens`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `superheroi`
--

CREATE TABLE `superheroi` (
  `id` int(11) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `nome_vida_real` varchar(20) NOT NULL,
  `quantidadePoderes` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `superheroi`
--

INSERT INTO `superheroi` (`id`, `nome`, `nome_vida_real`, `quantidadePoderes`) VALUES
(1, 'Homem-Aranha', 'Peter Park', 3),
(2, 'Super-Homem', 'Clark Kent', 4),
(3, 'Capitao America', 'Steven Rogers', 2),
(4, 'Flash', 'Barry Aleen', 1),
(5, 'Lanterna-Verde', 'Hal Jordan', 1),
(6, 'Homem de Ferro', 'Tony Stark', 2),
(7, 'Mulher Maravilha', 'Themyscira', 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `superheroi_superpoder`
--

CREATE TABLE `superheroi_superpoder` (
  `id_superheroi` int(11) NOT NULL,
  `id_superpoder` int(11) NOT NULL,
  `categoria_poder` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `superheroi_superpoder`
--

INSERT INTO `superheroi_superpoder` (`id_superheroi`, `id_superpoder`, `categoria_poder`) VALUES
(1, 1, 3),
(1, 2, 2),
(1, 3, 1),
(2, 4, 3),
(2, 14, 5),
(2, 6, 4),
(2, 7, 4),
(3, 8, 3),
(3, 9, 2),
(4, 10, 5),
(5, 11, 5),
(6, 12, 4),
(6, 13, 2),
(7, 10, 3),
(7, 14, 3),
(7, 17, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `superpoder`
--

CREATE TABLE `superpoder` (
  `id` int(11) NOT NULL,
  `nome` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `superpoder`
--

INSERT INTO `superpoder` (`id`, `nome`) VALUES
(1, 'Soltar teia'),
(2, 'Andar em paredes'),
(3, 'Sentido apurado'),
(4, 'Voar'),
(6, 'Visao de raio X'),
(7, 'Sopro congelante'),
(8, 'Supersoldado'),
(9, 'Escudo'),
(10, 'Velocidade'),
(11, 'Anel mágico'),
(12, 'Armadura'),
(13, 'Dispositivos eletronicos'),
(14, 'Força'),
(15, 'Mente aguçada'),
(16, 'Tentáculos indestrutíveis'),
(17, 'Braceletes');

-- --------------------------------------------------------

--
-- Estrutura da tabela `vilao`
--

CREATE TABLE `vilao` (
  `id` int(11) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `nome_vida_real` varchar(20) NOT NULL,
  `tempo_prisao` int(11) NOT NULL,
  `quantidadePoderes` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `vilao`
--

INSERT INTO `vilao` (`id`, `nome`, `nome_vida_real`, `tempo_prisao`, `quantidadePoderes`) VALUES
(1, 'Duende verde', 'Norman Osbourne', 5, 1),
(2, 'Lex Luthor', 'Lex Luthor', 5, 1),
(3, 'Bizarro', 'Bizarro', 5, 4),
(4, 'Octopus', 'Otto Octavius', 5, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `vilao_superpoder`
--

CREATE TABLE `vilao_superpoder` (
  `id_vilao` int(11) NOT NULL,
  `id_superpoder` int(11) NOT NULL,
  `categoria_poder` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `vilao_superpoder`
--

INSERT INTO `vilao_superpoder` (`id_vilao`, `id_superpoder`, `categoria_poder`) VALUES
(1, 14, 5),
(2, 15, 5),
(3, 4, 3),
(3, 14, 5),
(3, 6, 4),
(3, 7, 4),
(4, 16, 5),
(4, 10, 1);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `superheroi`
--
ALTER TABLE `superheroi`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `superheroi_superpoder`
--
ALTER TABLE `superheroi_superpoder`
  ADD KEY `id_superheroi_fk` (`id_superheroi`),
  ADD KEY `superpoder_superheroi_fk` (`id_superpoder`);

--
-- Índices para tabela `superpoder`
--
ALTER TABLE `superpoder`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `vilao`
--
ALTER TABLE `vilao`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `vilao_superpoder`
--
ALTER TABLE `vilao_superpoder`
  ADD KEY `id_vilao_fk` (`id_vilao`),
  ADD KEY `superpoder_vilao_fk` (`id_superpoder`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `superheroi`
--
ALTER TABLE `superheroi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `superpoder`
--
ALTER TABLE `superpoder`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de tabela `vilao`
--
ALTER TABLE `vilao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `superheroi_superpoder`
--
ALTER TABLE `superheroi_superpoder`
  ADD CONSTRAINT `id_superheroi_fk` FOREIGN KEY (`id_superheroi`) REFERENCES `superheroi` (`id`),
  ADD CONSTRAINT `superpoder_superheroi_fk` FOREIGN KEY (`id_superpoder`) REFERENCES `superpoder` (`id`);

--
-- Limitadores para a tabela `vilao_superpoder`
--
ALTER TABLE `vilao_superpoder`
  ADD CONSTRAINT `id_vilao_fk` FOREIGN KEY (`id_vilao`) REFERENCES `vilao` (`id`),
  ADD CONSTRAINT `superpoder_vilao_fk` FOREIGN KEY (`id_superpoder`) REFERENCES `superpoder` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
