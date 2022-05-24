package com.unla.Grupo18.services.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.unla.Grupo18.entities.Espacio;
import com.unla.Grupo18.repositories.IEspacioRepository;
import com.unla.Grupo18.services.IEspacioService;

@Service("espacioService")
public class EspacioService implements IEspacioService {

	@Autowired
	@Qualifier("espacioRepository")
	private IEspacioRepository espacioRepository;
	
	@Override
	public List<Espacio> getAll() {
		return (List<Espacio>) espacioRepository.findAll();
	}

	@Override
	public void save(Espacio espacio) {
		espacioRepository.save(espacio);
	}
	
	@Override
	public Espacio buscar(long id) {
		return espacioRepository.findById(id).orElse(null);
	}
	
	@Override
	public void eliminar (long id) {
		espacioRepository.deleteById(id);
	}

}
