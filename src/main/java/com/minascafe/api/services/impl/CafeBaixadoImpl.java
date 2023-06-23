package com.minascafe.api.services.impl;
//@author Edson Ferreira Barbosa

import java.util.Optional;

import com.minascafe.api.entities.CafeBaixado;
import com.minascafe.api.repositories.CafeBaixadoRepository;
import com.minascafe.api.services.CafeBaixadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Cria um serviço
public class CafeBaixadoImpl implements CafeBaixadoService {// É uma camada acima do Jpa Repository que será consumido por um Controller mais adiante

    private static final Logger log = LoggerFactory.getLogger(CafeBaixadoImpl.class);//Declarando o log = "descreve eventos do funcionamento do sistema"

    @Autowired //Injetando dependência de forma automática
    private CafeBaixadoRepository cafe_BaixadoRepository;//Declarando variável cafe_BaixadoRepository

    @Override //Informa ao compilador que o elemento deve substituir um elemento declarado em uma superclasse
    public Optional<CafeBaixado> buscarPorLote(int Lote){ //Optional=classe implementada no Java 8, tem o objetivo de simplificar os códigos, facilitando a vida dos desenvolvedores.
        //O Optional nos ajuda a evitar os erros NullPointerException, tira a necessidade da verificação (if x != null)
        log.info("Buscando Café baixado pelo lote {}", Lote); //imprime na tela
        return Optional.ofNullable(cafe_BaixadoRepository.findByLote(Lote));//Faz chamada ao cafe_BaixadoRepository, buscando por lote. Retorna um Optional com o valor pedido pelo método. Pode ser nulo ou não. Evita exceção NullPointer!
    }

    @Override
    public Optional<CafeBaixado> buscarPorProdutor(String Produtor){
        log.info("Buscando um Café baixado do produtor: {}", Produtor);
        return Optional.ofNullable(cafe_BaixadoRepository.findByProdutor(Produtor));//Faz chamada ao cafe_BaixadoRepository, buscando por produtor. Retorna um Optional com o valor pedido pelo método. Pode ser nulo ou não. Evita exceção NullPointer!
    }

    @Override //Sobrepõe um método já existente
    public CafeBaixado persistir (CafeBaixado cafe_Baixado){
        log.info("Persistindo Café baixado: {}", cafe_Baixado);//imprime na tela
        return this.cafe_BaixadoRepository.save(cafe_Baixado);
    }

    @Override
    public void remover (int lote) {
        log.info("Removendo o café baixado de lote {}: ", lote);
        this.cafe_BaixadoRepository.deleteById(lote);
    }
}
