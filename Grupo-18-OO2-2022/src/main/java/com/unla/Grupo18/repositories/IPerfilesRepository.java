package com.unla.Grupo18.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.Grupo18.entities.Perfiles;


@Repository("perfilesRepository")
public interface IPerfilesRepository extends JpaRepository<Perfiles, Long>{
}
