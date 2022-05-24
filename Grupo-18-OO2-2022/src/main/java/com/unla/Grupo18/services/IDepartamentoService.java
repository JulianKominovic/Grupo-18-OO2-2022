package com.unla.Grupo18.services;

import java.util.List;

import com.unla.Grupo18.entities.Departamento;

public interface IDepartamentoService {
	
	public List<Departamento> getAll();
	public void save(Departamento departamento);
	public Departamento buscar(long id);
	public void eliminar(long id);
	
	
}
