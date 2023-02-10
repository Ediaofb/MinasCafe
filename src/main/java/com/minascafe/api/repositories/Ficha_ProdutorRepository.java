package com.minascafe.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import com.minascafe.api.entities.Ficha_Produtor;

@Transactional
public interface Ficha_ProdutorRepository extends JpaRepository<Ficha_Produtor, Integer>{

	Ficha_Produtor findById(int Id);//SELECT * FROM Ficha_Produtor WHERE Id = this.Id
	Ficha_Produtor findByNome(String nome);
	Ficha_Produtor findByApelido(String apelido);
	Ficha_Produtor findByCpf(String cpf);
}
