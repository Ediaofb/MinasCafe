package com.minascafe.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import com.minascafe.api.entities.Cafe_Baixado;

@Transactional
public interface Cafe_BaixadoRepository extends JpaRepository<Cafe_Baixado, Integer>{

	Cafe_Baixado findByLote(int Lote);//SELECT * FROM Cafe_Baixado WHERE Lote = this.Lote
}
