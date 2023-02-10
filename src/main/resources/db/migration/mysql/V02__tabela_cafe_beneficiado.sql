CREATE TABLE IF NOT EXISTS `cad_cafe_beneficiado` (
  `lote` int(7) NOT NULL AUTO_INCREMENT,
  `produtor` varchar(40) NOT NULL,
  `status` varchar(3) DEFAULT NULL,
  `data` date NOT NULL,
  `sacas` int(4) NOT NULL, -- 60 kgs
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