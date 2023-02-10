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

import com.minascafe.api.entities.Cafe_Maquina;

@RunWith(SpringRunner.class)//diz ao JUnit para executar o teste usando a classe de execução do Spring Runner
@SpringBootTest
@ActiveProfiles("test")//ativando um profile do tipo 'Teste'

public class Cafe_MaquinaRepositoryTest {

	@Autowired //Diz ao Spring para injetar o Cafe_BaixadoRepository que foi criado antes para dentro do seu teste.
	private Cafe_MaquinaRepository cafe_maquinarepository;
	
	private static int Lote = 215;
	
	@Before //executa esta operação antes da execução do join point
	public void setUp()/*configurar*/ throws Exception {
		Cafe_Maquina cafe_maquina = new Cafe_Maquina();//Instancia a classe Cafe_Maquina
		cafe_maquina.setLote(Lote);
		cafe_maquina.setProdutor("Humberto Bergamin");//Insere um nome de produtor		
		cafe_maquina.setData(new Date());
		cafe_maquina.setSacas(90);
		cafe_maquina.setQuilos(16.80);
		this.cafe_maquinarepository.save(null);
	}
	
	@After //executa esta operação depois da execução do join point
	public final void tearDown()/*destruir*/{ 
		this.cafe_maquinarepository.deleteAll();//deleta tudo após o teste
	}
	
	@Test //Validando o teste
	public void testBuscarPorLote() {
		Cafe_Maquina cafe_maquina = this.cafe_maquinarepository.findByLote(Lote);
		
		assertEquals(Lote, Lote); //verifica se o lote declarado é o mesmo do Café em Côco retornado
	}
}