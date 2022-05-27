package com.unla.Grupo18.services;

import java.util.List;
import com.unla.Grupo18.entities.Tradicional;

public interface ITradicionalService {
	
	public List<Tradicional> getAll();

	public Tradicional buscar(long id);

	public void eliminar(long id);
	
	public void save(Tradicional tradicional);
}
