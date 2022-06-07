package com.unla.Grupo18.repositories;


import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.unla.Grupo18.entities.Usuario;



@Repository("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<Usuario, Serializable> {
	@Query("SELECT u FROM Usuario u WHERE u.correoElectronico = (:correoElectronico)")
	public abstract Usuario getByEmail(@Param("correoElectronico") String correoElectronico);
	
	@Query("SELECT u FROM Usuario u WHERE u.documento = (:documento)")
	public abstract Usuario getByDni(@Param("documento") int documento);
	
	@Query("SELECT u FROM Usuario u WHERE u.nombreDeUsuario = (:nombreDeUsuario)")
	public abstract Usuario getByUsername(@Param("nombreDeUsuario") String nombreDeUsuario);
}
