package com.unla.Grupo18.services.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo18.entities.Perfiles;
import com.unla.Grupo18.repositories.IPerfilesRepository;
import com.unla.Grupo18.services.IPerfilesService;


@Service("perfilesService")
public class PerfilesService implements IPerfilesService {
	
	@Autowired
	@Qualifier("perfilesRepository")
	private IPerfilesRepository perfilesRepository;

	
	@Override
	public List<Perfiles> getAll() {
		return perfilesRepository.findAll();
	}
	
	@Override
	public void save(Perfiles perfil) {
		perfilesRepository.save(perfil);
	
	}
	
	@Override
	public Perfiles buscar(long id) {
		return perfilesRepository.findById(id).orElse(null);
	}
	
	@Override
	public void eliminar (long id) {
		perfilesRepository.deleteById(id);
	}
		
}
