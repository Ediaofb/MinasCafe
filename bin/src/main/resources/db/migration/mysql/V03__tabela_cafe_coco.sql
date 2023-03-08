--
-- Estrutura da tabela `cad_cafe_coco`
--
CREATE TABLE IF NOT EXISTS `cad_cafe_coco` (
  `lote` int(11) NOT NULL AUTO_INCREMENT,
  `produtor` varchar(40) NOT NULL,
  `status` varchar(3) DEFAULT NULL,
  `data` date NOT NULL,
  `sacas` int(11) NOT NULL, -- 45 kgs
  `quilos` float NOT NULL,
  `baracao` int(11) DEFAULT NULL,
  `subproduto` varchar(70) DEFAULT NULL,
  `numero_nota` int(11) DEFAULT NULL,
  `classificacao` varchar(5) DEFAULT NULL,
  `catacao` int(11) DEFAULT NULL,
  `peneira` int(11) DEFAULT NULL,
  `lancado` varchar(3) DEFAULT NULL,
  `observacoes` varchar(140) DEFAULT NULL,
  `referencia` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`lote`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

ALTER TABLE cad_cafe_coco
CHANGE sacas sacos int(11);

ALTER TABLE cad_cafe_coco
ADD COLUMN meieiro VARCHAR(40);

ALTER TABLE cad_cafe_coco
ADD COLUMN porcentagem_produtor int(2);

ALTER TABLE cad_cafe_coco
ADD COLUMN porcentagem_meieiro int(2);
