package com.unla.Grupo18.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.unla.Grupo18.entities.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> getAll();

	public Usuario buscar(long id);

	public void eliminar(long id);
	
	public void save(Usuario usuario);
	
	public Usuario getByEmail(@Param("correoElectronico") String correoElectronico);
	
	public Usuario getByDni(@Param("documento") int documento);

	public Usuario getByUsername(@Param("nombreDeUsuario") String nombreDeUsuario);
}
