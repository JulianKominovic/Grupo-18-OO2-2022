package com.unla.Grupo18.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.Grupo18.entities.Aula;

@Repository()
public interface IAulaRepository extends JpaRepository<Aula, Long> {

	@Query("select a from Aula a where a.edificio.id = :id_edificio")
	List<Aula> getAulasByEdificio(@Param("id_edificio") Long edificioId);
}
