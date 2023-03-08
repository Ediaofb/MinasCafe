CREATE TABLE `cad_cafe_baixado` (
  `lote` int(7) NOT NULL AUTO_INCREMENT,
  `produtor` varchar(50) NOT NULL,
  `status` varchar(3) DEFAULT NULL,
  `data` date NOT NULL,
  `sacas` int(4) NOT NULL, /*60 kgs*/
  `quilos` float NOT NULL,
  `baracao` int(4) DEFAULT NULL,
  `subproduto` varchar(70) DEFAULT NULL,
  `numero_nota` int(11) DEFAULT NULL,
  `classificacao` varchar(5) DEFAULT NULL,
  `catacao` int(11) DEFAULT NULL,
  `peneira` int(11) DEFAULT NULL,
  `lancado` varchar(3) DEFAULT NULL,
  `observacoes` varchar(140) DEFAULT NULL,
  `referencia` varchar(7) DEFAULT NULL,
  `meieiro` VARCHAR(40) DEFAULT NULL,
  `porcentagem_produtor` int(2),
  `porcentagem_meieiro` int(2),
  PRIMARY KEY (`lote`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

CREATE TABLE `cad_cafe_coco` (
  `lote` int(7) NOT NULL AUTO_INCREMENT,
  `produtor` varchar(50) NOT NULL,
  `status` varchar(3) DEFAULT NULL,
  `data` date NOT NULL,
  `sacos` int(4) NOT NULL, /*45 Kgs*/
  `quilos` float NOT NULL,
  `baracao` int(4) DEFAULT NULL,
  `subproduto` varchar(70) DEFAULT NULL,
  `numero_nota` int(11) DEFAULT NULL,
  `classificacao` varchar(5) DEFAULT NULL,
  `catacao` int(11) DEFAULT NULL,
  `peneira` int(11) DEFAULT NULL,
  `lancado` varchar(3) DEFAULT NULL,
  `observacoes` varchar(140) DEFAULT NULL,
  `referencia` varchar(7) DEFAULT NULL,
  `meieiro` VARCHAR(40) DEFAULT NULL,
  `porcentagem_produtor` int(2),
  `porcentagem_meieiro` int(2),
  PRIMARY KEY (`lote`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE `cad_cafe_beneficiado` (
  `lote` int(7) NOT NULL AUTO_INCREMENT,
  `produtor` varchar(50) NOT NULL,
  `status` varchar(3) DEFAULT NULL,
  `data` date NOT NULL,
  `sacas` int(4) NOT NULL, /*60 kgs*/
  `quilos` float NOT NULL,
  `baracao` int(4) DEFAULT NULL,
  `subproduto` varchar(70) DEFAULT NULL,
  `numero_nota` int(11) DEFAULT NULL,
  `classificacao` varchar(5) DEFAULT NULL,
  `catacao` int(11) DEFAULT NULL,
  `peneira` int(11) DEFAULT NULL,
  `lancado` varchar(3) DEFAULT NULL,
  `observacoes` varchar(140) DEFAULT NULL,
  `meieiro` varchar(40) DEFAULT NULL,
  `porcentagem_produtor` int(2),
  `porcentagem_meieiro` int(2),
  PRIMARY KEY (`lote`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE `cad_cafe_maquina` (
  `lote` int(5) NOT NULL AUTO_INCREMENT,
  `produtor` varchar(50) NOT NULL,
  `status` varchar(3) DEFAULT NULL,
  `data` date NOT NULL,
  `sacas` int(3) NOT NULL, /*60 kgs*/
  `quilos` float NOT NULL,
  `baracao` int(1) DEFAULT NULL,
  `subproduto` varchar(70) DEFAULT NULL,
  `numero_nota` int(4) DEFAULT NULL,
  `classificacao` varchar(5) DEFAULT NULL,
  `catacao` int(2) DEFAULT NULL,
  `peneira` int(2) DEFAULT NULL,
  `lancado` varchar(3) DEFAULT NULL,
  `referencia` varchar(7) DEFAULT NULL,
  `observacoes` varchar(140) DEFAULT NULL,
  `meieiro` VARCHAR(40),
  `porcentagem_produtor` int(2),
  `porcentagem_meieiro` int(2),
  PRIMARY KEY (`lote`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE `ficha_produtor` (
  `nome` varchar(50) NOT NULL,
  `apelido` varchar(20) DEFAULT NULL,
  `cpf` int(11) NOT NULL,
  `telefone` int(11) DEFAULT NULL,
  `data` date NOT NULL,
  `entrada_saida` varchar(80) DEFAULT NULL,
  `lote` varchar(7) NOT NULL,
  `duro` float DEFAULT NULL,
  `riado` float DEFAULT NULL,
  `rio` float DEFAULT NULL,
  `escolha` float DEFAULT NULL,
  `renda` int(2) DEFAULT NULL,
  `humidade` int(2) DEFAULT NULL,
  `valor_total` float DEFAULT NULL,
  `id` int(11) NOT NULL DEFAULT '0',
  `banco` VARCHAR(25) DEFAULT NULL,
  `agencia` VARCHAR(5) DEFAULT NULL,
  `operacao` VARCHAR(3) DEFAULT NULL,
  `tipo_conta` VARCHAR(14) DEFAULT NULL,
  `numero_conta` VARCHAR(13) DEFAULT NULL,
  `nome_correntista` VARCHAR(50) DEFAULT NULL,
  `chave_pix` VARCHAR(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
