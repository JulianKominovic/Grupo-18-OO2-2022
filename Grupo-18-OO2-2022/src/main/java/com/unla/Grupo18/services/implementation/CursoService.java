package com.unla.Grupo18.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unla.Grupo18.entities.Curso;
import com.unla.Grupo18.repositories.ICursoRepository;
import com.unla.Grupo18.services.ICursoService;

@Service
public class CursoService implements ICursoService {

	@Autowired
	private ICursoRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Curso> getAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Curso getById(long id) {
		Curso curso = null;
		curso = repository.getById(id);
		return curso;
	}

	@Override
	@Transactional
	public boolean eliminar(long id) {
		boolean success = true;
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			success = false;
		}
		return success;

	}

	@Override
	@Transactional
	public boolean save(Curso curso) {
		boolean success = true;
		try {
			repository.save(curso);
		} catch (Exception e) {
			success = true;
		}
		return success;

	}

}
