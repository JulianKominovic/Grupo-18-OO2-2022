package com.unla.Grupo18.repositories;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unla.Grupo18.entities.Materia;

@Repository("materiaRepository")
public interface IMateriaRepository extends JpaRepository<Materia,Serializable> {

}
