	--
-- Estrutura da tabela `produtor`
--
CREATE TABLE IF NOT EXISTS `produtor` (
  `nome` varchar(40) NOT NULL,
  `apelido` varchar(20) DEFAULT NULL,
  `cpf` int(11) NOT NULL,
  `telefone` int(11) DEFAULT NULL,
  `data` date NOT NULL,
  `entrada_saida` varchar(40) DEFAULT NULL,
  `lote` varchar(7) NOT NULL,
  `duro` float DEFAULT NULL,
  `riado` float DEFAULT NULL,
  `rio` float DEFAULT NULL,
  `escolha` float DEFAULT NULL,
  `renda` int(2) DEFAULT NULL,
  `humidade` int(2) DEFAULT NULL,
  `valor_total` float DEFAULT NULL,
  `id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE produtor
MODIFY entrada_saida VARCHAR(80);
