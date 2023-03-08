package com.minascafe.api.services;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
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
import com.minascafe.api.entities.Cafe_Beneficiado;
import com.minascafe.api.repositories.Cafe_BeneficiadoRepository;

@RunWith(SpringRunner.class) // ---
@SpringBootTest // ------------    3 configurações de contexto
@ActiveProfiles("test") // ---

public class Cafe_Beneficiado_ServiceTest {

	@MockBean //***"Objetos falsos"*** (para testes)
	private Cafe_BeneficiadoRepository cafe_BeneficiadoRepository;
	
	@Autowired
	private Cafe_Beneficiado_Service cafe_beneficiado_Service; //Chamo para testá-la. "Obtém" uma instância de Cafe_Baixado_Service por meio da anotação @Autowired
	
	private static final int lote = 123;
	
	@Before //Executa o código antes do teste
	public void setUp() throws Exception{
		
		BDDMockito.given(this.cafe_BeneficiadoRepository.findByLote(Mockito.anyInt())).willReturn(new Cafe_Beneficiado());
		BDDMockito.given(this.cafe_BeneficiadoRepository.save(Mockito.any(Cafe_Beneficiado.class))).willReturn(new Cafe_Beneficiado());
	}

	@Test
	public void testBuscarCafeBeneficiadoPorLote() {
		Optional<Cafe_Beneficiado> cafe_beneficiado = this.cafe_beneficiado_Service.buscarPorLote(lote);
		
		assertTrue(cafe_beneficiado.isPresent());//Certifica de que existe um cafe_beneficiado dentro desse objeto Optional
	}
	
	@Test
	public void testPersistirCafe_Beneficiado() {
		Cafe_Beneficiado cafe_beneficiado = this.cafe_beneficiado_Service.persistir(new Cafe_Beneficiado());
		
		assertNull(cafe_beneficiado); //Verifica se o cafe_beneficiado não é nulo
	}	
}
