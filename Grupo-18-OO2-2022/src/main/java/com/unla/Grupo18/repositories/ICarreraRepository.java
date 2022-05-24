package com.unla.Grupo18.repositories;
import com.unla.Grupo18.entities.Carrera;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.io.Serializable;

@Repository("carreraRepository")
public interface ICarreraRepository extends JpaRepository<Carrera,Serializable>{

}
