package com.unla.Grupo18.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.Grupo18.entities.Aula;
import com.unla.Grupo18.entities.Espacio;
import com.unla.Grupo18.entities.Laboratorio;
import com.unla.Grupo18.repositories.IAulaRepository;
import com.unla.Grupo18.services.IAulaService;

@Service
public class AulaService implements IAulaService {

	@Autowired
	private IAulaRepository repo;

	@Override
	public List<Aula> getAulasByEdificio(Long edificio_id) {

		return repo.getAulasByEdificio(edificio_id);
	}

	@Override
	public Aula getAulaById(Long id) {

		return repo.getById(id);
	}
	
	@Override
	public List<Aula> getAll() {
		return (List<Aula>) repo.findAll();
	}
	
	@Override
	public Aula buscar(long id) {
		return repo.findById(id).orElse(null);
	}
	
	@Override
	public void save(Aula aula) {
		repo.save(aula);
	}

	@Override
	public void eliminar(long id) {
		repo.deleteById(id);
	}
}
