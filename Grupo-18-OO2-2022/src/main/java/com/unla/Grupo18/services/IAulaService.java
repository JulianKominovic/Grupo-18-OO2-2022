package com.unla.Grupo18.services;

import java.util.List;
import com.unla.Grupo18.entities.Aula;

public interface IAulaService {
	
	public List<Aula> getAll();
	
	public void save(Aula aula);
	
	public Aula buscar(long id);
	
	public void eliminar (long id);
}
