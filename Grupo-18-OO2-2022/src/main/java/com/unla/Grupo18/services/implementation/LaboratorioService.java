package com.unla.Grupo18.services.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.unla.Grupo18.entities.Laboratorio;
import com.unla.Grupo18.repositories.ILaboratorioRepository;
import com.unla.Grupo18.services.ILaboratorioService;

@Service("laboratorioService")
public class LaboratorioService implements ILaboratorioService {
	
	@Autowired
	@Qualifier("laboratorioRepository")
	private ILaboratorioRepository laboratorioRepository;
	
	@Override
	public List<Laboratorio> getAll() {
		return (List<Laboratorio>) laboratorioRepository.findAll();
	}

	@Override
	public Laboratorio buscar(long id) {
		return laboratorioRepository.findById(id).orElse(null);
	}
	
	@Override
	public void save(Laboratorio laboratorio) {
		laboratorioRepository.save(laboratorio);
	}

	@Override
	public void eliminar(long id) {
		laboratorioRepository.deleteById(id);
	}
}
