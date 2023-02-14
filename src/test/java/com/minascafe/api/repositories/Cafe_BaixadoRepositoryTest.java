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

import com.minascafe.api.entities.Cafe_Baixado;

@RunWith(SpringRunner.class)//diz ao JUnit para executar o teste usando a classe de execução do Spring Runner
@SpringBootTest
@ActiveProfiles("test")//ativando um profile do tipo 'Teste'

public class Cafe_BaixadoRepositoryTest {//Reduzir a quantidade de código necessário para implementar a camada de acesso e persistência de dados. Sua principal finalidade é gerenciar a classe de domínio assim como o tipo de dado do id da classe

	@Autowired //Diz ao Spring para injetar o Cafe_BaixadoRepository que foi criado antes para dentro do seu teste.
	private Cafe_BaixadoRepository cafe_baixadorepository;
	
	private static int Lote = 215;
	
	@Before //executa esta operação antes da execução do join point
	public void setUp() /*Configurar*/ throws Exception {
		Cafe_Baixado cafe_baixado = new Cafe_Baixado();//Instancia a classe Cafe_Baixado
		cafe_baixado.setProdutor("Humberto Bergamin");//Insere um nome de produtor
		cafe_baixado.setLote(Lote);
		cafe_baixado.setData(new Date());
		cafe_baixado.setSacas(90);
		cafe_baixado.setQuilos(16.80);
		this.cafe_baixadorepository.save(cafe_baixado);
	}
	
	@After //executa esta operação depois da execução do join point
	public final void tearDown()/*destruir*/{
		this.cafe_baixadorepository.deleteAll(); //Deleta tudo para não deixar dados no banco
	}
	
	@Test //validando o teste
	public void testBuscarPorLote() {
		Cafe_Baixado cafe_baixado = this.cafe_baixadorepository.findByLote(Lote);
		
		assertEquals(Lote, Lote); //verifica se o lote declarado é o mesmo do Café em Côco retornado
	}
}