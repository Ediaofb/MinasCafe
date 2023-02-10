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

import com.minascafe.api.entities.Cafe_Beneficiado;

@RunWith(SpringRunner.class)//diz ao JUnit para executar o teste usando a classe de execução do Spring Runner
@SpringBootTest
@ActiveProfiles("test")//ativando um profile do tipo 'Teste'

public class Cafe_BeneficiadoRepositoryTest {

	@Autowired //Diz ao Spring para injetar o Cafe_BaixadoRepository que foi criado antes para dentro do seu teste.
	private Cafe_BeneficiadoRepository cafe_beneficiadorepository;

	private static int Lote = 215;
	
	@Before //executa esta operação antes da execução do join point
	public void setUp()/*Configurar*/ throws Exception {
		Cafe_Beneficiado cafe_beneficiado = new Cafe_Beneficiado();//Instancia a classe Cafe_Beneficiado
		cafe_beneficiado.setProdutor("Humberto Bergamin");//Insere um nome de produtor
		cafe_beneficiado.setLote(Lote);
		cafe_beneficiado.setData(new Date());
		cafe_beneficiado.setSacas(90);
		cafe_beneficiado.setQuilos(16.80);
		this.cafe_beneficiadorepository.save(cafe_beneficiado);
	}
	
	@After //executa esta operação depois da execução do join point
	public final void tearDown()/*destruir*/{
		this.cafe_beneficiadorepository.deleteAll();//Deleta tudo		
	}
	
	@Test //Validando o teste
	public void testBuscarPorLote() {
		Cafe_Beneficiado cafe_beneficiado = this.cafe_beneficiadorepository.findByLote(Lote);
		
		assertEquals(Lote, Lote); //verifica se o lote declarado é o mesmo do Café em Côco retornado
	}
}