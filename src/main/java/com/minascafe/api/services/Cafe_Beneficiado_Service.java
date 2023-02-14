package com.minascafe.api.services;

import com.minascafe.api.entities.Cafe_Beneficiado;
import java.util.Optional;

public interface Cafe_Beneficiado_Service { //Lógica de negócios da aplicação

	/**
	 * Retorna um Cafe_Beneficiado dado um lote
	 * 
	 * @param Lote
	 * @return Cafe_Beneficiado
	 */	
	Optional <Cafe_Beneficiado> buscarPorLote(int Lote);
	
	/**
	 * Retorna um Cafe_Beneficiado dado um produtor
	 * 
	 * @param produtor
	 * @return cafe_Beneficiado
	 */
	Optional <Cafe_Beneficiado> buscarPorProdutor(String Produtor);
	
	/**
	 * Cadastra um Cafe_Beneficiado na base de dados
	 * @param cafe_beneficiado
	 * @return cafe_beneficiado
	 */
     Cafe_Beneficiado persistir(Cafe_Beneficiado cafe_beneficiado);
}
