package com.unla.Grupo18.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo18.entities.Carrera;
import com.unla.Grupo18.repositories.ICarreraRepository;
import com.unla.Grupo18.services.ICarreraService;

@Service("carreraService")
public class CarreraService implements ICarreraService {

	@Autowired
	@Qualifier("carreraRepository")
	private ICarreraRepository carreraRepository; 
	
	
	
	@Override
	public List<Carrera> getAll() {
		// TODO Auto-generated method stub
		return carreraRepository.findAll();
	}

	@Override
	public Carrera buscar(long id) {
		// TODO Auto-generated method stub
		return carreraRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(long id) {
		// TODO Auto-generated method stub
		carreraRepository.deleteById(id);
		
	}

	@Override
	public void save(Carrera carrera) {
		// TODO Auto-generated method stub
		carreraRepository.save(carrera);
	}

	
}
