package com.unla.Grupo18.services;

import java.util.List;
import com.unla.Grupo18.entities.Laboratorio;

public interface ILaboratorioService {
	
	public List<Laboratorio> getAll();

	public Laboratorio buscar(long id);

	public void eliminar(long id);
	
	public void save(Laboratorio laboratorio);
}
