package com.unla.Grupo18.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.Grupo18.entities.Espacio;

@Repository("espacioRepository")
public interface IEspacioRepository extends JpaRepository<Espacio, Long> {
	@Query("select e from Espacio e where e.fecha = :fecha and e.turno = :turno and e.aula.id = :aulaId")
	Espacio getByProps(@Param("fecha") LocalDate fecha, @Param("turno") String turno, @Param("aulaId") Long aulaId);
}
