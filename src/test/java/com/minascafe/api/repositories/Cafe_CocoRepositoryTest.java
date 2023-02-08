package com.minascafe.api.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.minascafe.api.entities.Cafe_Coco;

@RunWith(SpringRunner.class)//diz ao JUnit para executar o teste usando a classe de execução do Spring Runner
@SpringBootTest
@ActiveProfiles("test")//ativando um profile do tipo 'Teste'

public class Cafe_CocoRepositoryTest {

	@Autowired //Diz ao Spring para injetar o Cafe_CocoRepository que foi criado antes para dentro do seu teste.
	private Cafe_CocoRepository cafe_CocoRepository;
	
	private static int Lote = 215;
	
	@Before //executa esta operação antes da execução do join point
	public void setUp() /*Configurar*/ throws Exception {
		Cafe_Coco cafe_Coco = new Cafe_Coco();//Instancia a classe Cafe_Coco
		cafe_Coco.setProdutor("Humberto Bergamin");//Insere um nome de produtor  
		cafe_Coco.setLote(Lote);
		cafe_Coco.setData(new Date());
		cafe_Coco.setSacos(90);
		cafe_Coco.setQuilos(16.80);
		this.cafe_CocoRepository.save(cafe_Coco);
	}
	
	@After //executa esta operação depois da execução do join point
	public final void tearDown()/*destruir*/{
		this.cafe_CocoRepository.deleteAll(); //Deleta tudo
	}
	
	@Test //validando o teste
	public void testBuscarPorLote() {
		Cafe_Coco cafe_Coco = this.cafe_CocoRepository.findByLote(Lote);
		
		assertEquals(Lote, Lote); //verifica se o lote declarado é o mesmo do Café em Côco retornado
	}
	
}