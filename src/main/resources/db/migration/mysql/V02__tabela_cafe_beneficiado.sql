CREATE TABLE IF NOT EXISTS `cad_cafe_beneficiado` (
  `lote` int(5) NOT NULL AUTO_INCREMENT,
  `produtor` varchar(40) NOT NULL,
  `status` varchar(3) DEFAULT NULL,
  `data` date NOT NULL,
  `sacas` int(4) NOT NULL, -- 60 kgs
  `quilos` float NOT NULL,
  `baracao` int(2) DEFAULT NULL,
  `subproduto` varchar(70) DEFAULT NULL,
  `numero_nota` int(5) DEFAULT NULL,
  `classificacao` varchar(5) DEFAULT NULL,
  `catacao` int(2) DEFAULT NULL,
  `peneira` int(2) DEFAULT NULL,
  `lancado` varchar(3) DEFAULT NULL,
  `observacoes` varchar(140) DEFAULT NULL,
  PRIMARY KEY (`lote`),
  UNIQUE KEY `lote` (`lote`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

ALTER TABLE cad_cafe_beneficiado
ADD COLUMN meieiro varchar(40);

ALTER TABLE cad_cafe_beneficiado
ADD COLUMN porcentagem_produtor int(2);

ALTER TABLE cad_cafe_beneficiado
ADD COLUMN porcentagem_meieiro int(2);
