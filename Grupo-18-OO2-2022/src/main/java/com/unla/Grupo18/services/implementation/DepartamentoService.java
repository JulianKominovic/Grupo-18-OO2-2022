package com.unla.Grupo18.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import com.unla.Grupo18.entities.Departamento;
import com.unla.Grupo18.repositories.IDepartamentoRepository;
import com.unla.Grupo18.services.IDepartamentoService;


@Service("departamentoService")
public class DepartamentoService implements IDepartamentoService {

	@Autowired
	@Qualifier("departamentoRepository")
	private IDepartamentoRepository departamentoRepository;
	
	@Override
	public List<Departamento> getAll(){
		return departamentoRepository.findAll();
	}
	
	@Override
	public void save(Departamento departamento) {
		departamentoRepository.save(departamento); 
	}
	
	@Override
	public Departamento buscar(long id) {
		return departamentoRepository.findById(id).orElse(null);
	}
	
	@Override
	public void eliminar (long id) {
		departamentoRepository.deleteById(id); 
	}
	
}
