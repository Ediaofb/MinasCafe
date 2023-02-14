package com.minascafe.api.services;

import java.util.Optional;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import com.minascafe.api.entities.Cafe_Baixado;
import com.minascafe.api.repositories.Cafe_BaixadoRepository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class) // --
@SpringBootTest // ------------    3 configurações de contexto
@ActiveProfiles("test")// --

public class Cafe_Baixado_ServiceTest {

	@MockBean//-Ao invés de Autowired. Objetos falsos (para testes) - representa uma instância de Cafe_BaixadoRepository que já foi testada e eu sei que funciona.
	private Cafe_BaixadoRepository cafe_baixadoRepository;
	
	@Autowired
	private Cafe_Baixado_Service cafe_baixado_Service; //Chamo para testá-la. Obtém uma instância de Cafe_Baixado_Service por meio da anotação @Autowired 
	
	private static final int Lote = 1;
	
	@Before //Executa o código antes do teste 
	public void setUp() throws Exception { //qualquer inteiro que ele receber, retornará uma instância de Cafe_Baixado | 
		BDDMockito.given(this.cafe_baixadoRepository.findByLote(Mockito.anyInt())).willReturn(new Cafe_Baixado()); //dado um método findByLote, retornará um novo Cafe_Baixado
		BDDMockito.given(this.cafe_baixadoRepository.save(Mockito.any(Cafe_Baixado.class))).willReturn(new Cafe_Baixado());//Passa qualquer objeto do tipo Cafe_Baixado, retornará 
	}
	
	@Test
	public void testBuscarCafeBaixadoPorLote() {
		Optional<Cafe_Baixado> cafe_baixado = this.cafe_baixado_Service.buscarPorLote(Lote);
		
		assertTrue(cafe_baixado.isPresent());//Certifica de que existe um cafe_baixado dentro desse objeto Optional
	}
	
	@Test
	public void testPersistirCafe_Baixado() {
		Cafe_Baixado cafe_baixado = this.cafe_baixado_Service.persistir(new Cafe_Baixado());//Quando eu chamar o persistir o Mockito me retornará uma nova instância de Cafe_Baixado
		
		assertNotNull(cafe_baixado); //Verifica se o cafe_baixado não é nulo
	}
}
