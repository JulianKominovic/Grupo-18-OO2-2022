package com.unla.Grupo18.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unla.Grupo18.entities.Tradicional;

@Repository("tradicionalRepository")
public interface ITradicionalRepository extends CrudRepository<Tradicional, Long> {
	
}
