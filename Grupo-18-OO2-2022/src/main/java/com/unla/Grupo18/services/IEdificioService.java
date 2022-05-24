package com.unla.Grupo18.services;

import java.util.List;
import com.unla.Grupo18.entities.Edificio;

public interface IEdificioService {
	
	public List<Edificio> getAll();
	
	public void save(Edificio edificio);
	
	public Edificio buscar(long id);
	
	public void eliminar (long id);
}
