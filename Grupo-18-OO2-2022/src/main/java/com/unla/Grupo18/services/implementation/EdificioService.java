package com.unla.Grupo18.services.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.unla.Grupo18.entities.Edificio;
import com.unla.Grupo18.repositories.IEdificioRepository;
import com.unla.Grupo18.services.IEdificioService;

@Service("edificioService")
public class EdificioService implements IEdificioService {

	@Autowired
	@Qualifier("edificioRepository")
	private IEdificioRepository edificioRepository;
	
	@Override
	public List<Edificio> getAll() {
		return (List<Edificio>) edificioRepository.findAll();
	}

	@Override
	public void save(Edificio edificio) {
		edificioRepository.save(edificio);
	}
	
	@Override
	public Edificio buscar(long id) {
		return edificioRepository.findById(id).orElse(null);
	}
	
	@Override
	public void eliminar (long id) {
		edificioRepository.deleteById(id);
	}

}
