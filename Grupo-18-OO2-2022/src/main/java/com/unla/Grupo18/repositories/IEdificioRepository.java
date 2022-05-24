package com.unla.Grupo18.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.unla.Grupo18.entities.Edificio;

@Repository("edificioRepository")
public interface IEdificioRepository extends CrudRepository<Edificio, Long> {
	
}
