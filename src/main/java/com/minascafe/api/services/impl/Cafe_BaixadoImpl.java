package com.minascafe.api.services.impl;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.minascafe.api.entities.Cafe_Baixado;
import com.minascafe.api.repositories.Cafe_BaixadoRepository;
import com.minascafe.api.services.Cafe_Baixado_Service;

@Service //Cria um serviço
public class Cafe_BaixadoImpl implements Cafe_Baixado_Service {

	private static final Logger log = LoggerFactory.getLogger(Cafe_BaixadoImpl.class);
	
	@Autowired 
	private Cafe_BaixadoRepository cafe_BaixadoRepository;//Declarando variável cafe_BaixadoRepository 
	
	@Override //Informa ao compilador que o elemento deve substituir um elemento declarado em uma superclasse
	public Optional<Cafe_Baixado> buscarPorLote(int Lote){//Optional=classe implementada no Java 8, tem o objetivo de simplificar os códigos, facilitando a vida dos desenvolvedores.
    //O Optional nos ajuda a evitar os erros NullPointerException, tira a necessidade da verificação (if x != null)
       log.info("Buscando um cafe baixado com o lote {}", Lote);//imprime na tela
       return Optional.ofNullable(cafe_BaixadoRepository.findByLote(Lote));//Retorna um Optional com o valor pedido pelo método. Pode ser nulo ou não. Evita exceção NullPointer!
	}
	
	@Override
	public Cafe_Baixado persistir (Cafe_Baixado cafe_Baixado){
		log.info("Persistindo Café baixado: {}", cafe_Baixado);//imprime na tela
		return this.cafe_BaixadoRepository.save(cafe_Baixado);
	}
}