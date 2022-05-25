package com.unla.Grupo18.services;

import java.util.List;

import com.unla.Grupo18.entities.Curso;

public interface ICursoService {

	List<Curso> getAll();

	boolean eliminar(long id);

	boolean save(Curso curso);

	Curso getById(long id);
}
