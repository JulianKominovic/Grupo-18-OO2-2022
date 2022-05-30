package com.unla.Grupo18.services.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.unla.Grupo18.entities.Tradicional;
import com.unla.Grupo18.repositories.ITradicionalRepository;
import com.unla.Grupo18.services.ITradicionalService;

@Service("tradicionalService")
public class TradicionalService implements ITradicionalService {
	
	@Autowired
	@Qualifier("tradicionalRepository")
	private ITradicionalRepository tradicionalRepository;
	
	@Override
	public List<Tradicional> getAll() {
		return (List<Tradicional>) tradicionalRepository.findAll();
	}

	@Override
	public Tradicional buscar(long id) {
		return tradicionalRepository.findById(id).orElse(null);
	}
	
	@Override
	public void save(Tradicional tradicional) {
		tradicionalRepository.save(tradicional);
	}

	@Override
	public void eliminar(long id) {
		tradicionalRepository.deleteById(id);
	}
}
