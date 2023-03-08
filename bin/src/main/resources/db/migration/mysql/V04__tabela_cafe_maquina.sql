--
-- Estrutura da tabela `cad_cafe_maquina`
--

CREATE TABLE IF NOT EXISTS `cad_cafe_maquina` (
  `lote` int(5) NOT NULL AUTO_INCREMENT,
  `produtor` varchar(40) NOT NULL,
  `status` varchar(3) DEFAULT NULL,
  `data` date NOT NULL,
  `sacas` int(3) NOT NULL, -- 60 kgs
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
  PRIMARY KEY (`lote`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

ALTER TABLE cad_cafe_maquina
ADD COLUMN meieiro VARCHAR(40),
ADD COLUMN porcentagem_produtor int(2),
ADD COLUMN porcentagem_meieiro int(2);
