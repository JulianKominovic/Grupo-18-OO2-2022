package com.unla.Grupo18.services;

import com.unla.Grupo18.entities.Carrera;
import java.util.List;

public interface ICarreraService {
	
	public List<Carrera> getAll(); 
	public Carrera buscar(long id);
	public void eliminar(long id);
	public void save(Carrera carrera);
}
