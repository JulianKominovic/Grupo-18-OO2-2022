package com.unla.Grupo18.services;

import java.util.List;

import com.unla.Grupo18.entities.Aula;
import com.unla.Grupo18.entities.Edificio;
import com.unla.Grupo18.entities.Espacio;

public interface IAulaService {
	List<Aula> getAulasByEdificio(Long id_edificio);

	Aula getAulaById(Long id);
	
	public List<Aula> getAll();
	
	public void save(Aula aula);
	
	public Aula buscar(long id);
	
	public void eliminar (long id);
}
