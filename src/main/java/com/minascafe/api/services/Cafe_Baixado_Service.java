package com.minascafe.api.services;

import com.minascafe.api.entities.Cafe_Baixado;
import java.util.Optional;


public interface Cafe_Baixado_Service {

	  /**
	   * Retorna um Cafe_Baixado dado um Lote
	   * 
	   * @param Lote
	   * @return Optional<Cafe_Baixado>
	   */
	Optional<Cafe_Baixado> buscarPorLote(int Lote);
	
	/**
	 * Cadastra um Cafe_Baixado na base de dados 
	 * @param cafe_baixado
	 * @return cafe_baixado
	 */
	Cafe_Baixado persistir(Cafe_Baixado cafe_baixado);
}
