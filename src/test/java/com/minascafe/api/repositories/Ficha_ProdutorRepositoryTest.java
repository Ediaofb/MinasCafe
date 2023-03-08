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

import com.minascafe.api.entities.Ficha_Produtor;

@RunWith(SpringRunner.class)//diz ao JUnit para executar o teste usando a classe de execução do Spring Runner
@SpringBootTest
@ActiveProfiles("test")//ativando um profile do tipo 'Teste'

public class Ficha_ProdutorRepositoryTest {

	@Autowired //Diz ao Spring para injetar o Ficha_ProdutorRepository que foi criado antes para dentro do seu teste.
	private Ficha_ProdutorRepository ficha_produtorrepository;
		
	private static final String Nome = "Humberto";
	//private static final String apelido = "Baixinho";
	//private static final String cpf = "03308044563";
	
	@Before //executa esta operação antes da execução do join point
	public void setUp() /*configurar*/ throws Exception{
		Ficha_Produtor fp = new Ficha_Produtor();//Instancia a classe Ficha_Produtor
		fp.setNome(Nome);
		fp.setApelido("Baixinho");
		fp.setCpf("12345678990");
		fp.setData(new Date());
		fp.setEntrada_saida("Entrada");
	}
	
	@After
	public final void tearDown/*destruir*/() {	
		this.ficha_produtorrepository.deleteAll();
	}
	
	@Test//validando o teste
	public void testBuscarPorNome() {
		Ficha_Produtor ficha_produtor = this.ficha_produtorrepository.findByNome(Nome);
		
		assertEquals(Nome, Nome); //verifica se o lote declarado é o mesmo do Café em Côco retornado
	}
	
}
