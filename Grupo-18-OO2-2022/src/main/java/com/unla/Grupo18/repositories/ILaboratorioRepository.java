package com.unla.Grupo18.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unla.Grupo18.entities.Laboratorio;

@Repository("laboratorioRepository")
public interface ILaboratorioRepository extends CrudRepository<Laboratorio, Long> {

}
