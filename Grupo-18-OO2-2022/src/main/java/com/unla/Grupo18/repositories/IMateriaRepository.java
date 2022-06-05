package com.unla.Grupo18.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.Grupo18.entities.Materia;

@Repository("materiaRepository")
public interface IMateriaRepository extends JpaRepository<Materia, Serializable> {
	@Query("select m from Materia m where m.carrera.id = :id_carrera")
	List<Materia> getMateriasByCarrera(@Param("id_carrera") Long idCarrera);
}
