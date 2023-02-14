package com.minascafe.api.services;

import com.minascafe.api.entities.Cafe_Baixado;
import java.util.Optional;

public interface Cafe_Baixado_Service {//Lógica de negócios da aplicação

   /**
    * Retorna um Cafe_Baixado dado um Lote
    * 
    * @param Lote
    * @return Optional<Cafe_Baixado>
    */
	Optional <Cafe_Baixado> buscarPorLote(int Lote);
	
	/**
	 * Retorna um Cafe_Baixado dado um Produtor
	 * 
	 * @param produtor
	 * @return cafe_baixado
	 */
	Optional <Cafe_Baixado> buscarPorProdutor(String Produtor);
	
	/**
	 * Cadastra um Cafe_Baixado na base de dados  
	 * @param cafe_baixado
	 * @return cafe_baixado
	 */
	 Cafe_Baixado persistir(Cafe_Baixado cafe_baixado);
}
