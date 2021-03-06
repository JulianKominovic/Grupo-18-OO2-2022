package com.unla.Grupo18.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.unla.Grupo18.entities.Perfiles;

public interface IPerfilesService {
	
	public List<Perfiles> getAll();
	
	public void save(Perfiles perfil);
	
	public Perfiles buscar(long id);
	
	public void eliminar (long id);
	
	public Perfiles getByRol(@Param("rol") String rol);

}
