package com.unla.Grupo18.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.unla.Grupo18.entities.Espacio;

@Repository("espacioRepository")
public interface IEspacioRepository extends CrudRepository<Espacio, Long> {

}
