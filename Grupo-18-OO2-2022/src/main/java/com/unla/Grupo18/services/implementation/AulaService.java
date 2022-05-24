package com.unla.Grupo18.services.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.unla.Grupo18.entities.Aula;
import com.unla.Grupo18.repositories.IAulaRepository;
import com.unla.Grupo18.services.IAulaService;

@Service("aulaService")
public class AulaService implements IAulaService {

	@Autowired
	@Qualifier("aulaRepository")
	private IAulaRepository aulaRepository;
	
	@Override
	public List<Aula> getAll() {
		return (List<Aula>) aulaRepository.findAll();
	}

	@Override
	public void save(Aula aula) {
		aulaRepository.save(aula);
	}
	
	@Override
	public Aula buscar(long id) {
		return aulaRepository.findById(id).orElse(null);
	}
	
	@Override
	public void eliminar (long id) {
		aulaRepository.deleteById(id);
	}
}
