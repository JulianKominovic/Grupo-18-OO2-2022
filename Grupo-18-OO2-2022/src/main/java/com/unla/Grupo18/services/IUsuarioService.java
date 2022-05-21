package com.unla.Grupo18.services;

import java.util.List;
import com.unla.Grupo18.entities.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> getAll();

	public Usuario buscar(long id);

	public void eliminar(long id);
	
	public void save(Usuario usuario);

	
}
