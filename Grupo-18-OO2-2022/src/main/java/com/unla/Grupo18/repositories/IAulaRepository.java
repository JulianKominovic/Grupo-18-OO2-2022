package com.unla.Grupo18.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.unla.Grupo18.entities.Aula;

@Repository("aulaRepository")
public interface IAulaRepository extends CrudRepository<Aula, Long> {

}
