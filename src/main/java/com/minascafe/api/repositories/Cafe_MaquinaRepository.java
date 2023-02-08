package com.minascafe.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import com.minascafe.api.entities.Cafe_Maquina;

@Transactional
public interface Cafe_MaquinaRepository extends JpaRepository<Cafe_Maquina, Integer>{

	Cafe_Maquina findByLote(int Lote);
}
