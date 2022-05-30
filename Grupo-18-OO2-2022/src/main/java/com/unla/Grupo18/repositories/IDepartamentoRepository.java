package com.unla.Grupo18.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unla.Grupo18.entities.Departamento;


@Repository("departamentoRepository")
public interface IDepartamentoRepository extends JpaRepository<Departamento, Long>{}


