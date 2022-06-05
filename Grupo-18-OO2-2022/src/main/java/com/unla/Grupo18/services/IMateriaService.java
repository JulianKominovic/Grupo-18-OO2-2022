package com.unla.Grupo18.services;

import java.util.List;

import com.unla.Grupo18.entities.Materia;

public interface IMateriaService {

	public List<Materia> getAll();

	public Materia buscar(long id);

	public void eliminar(long id);

	public void save(Materia materia);

	public List<Materia> getMateriasByCarrera(Long carreraId);
}
