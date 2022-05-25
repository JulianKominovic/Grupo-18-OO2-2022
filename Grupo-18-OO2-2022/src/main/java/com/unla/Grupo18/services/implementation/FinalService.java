package com.unla.Grupo18.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unla.Grupo18.entities.Final;
import com.unla.Grupo18.repositories.IFinalRepository;
import com.unla.Grupo18.services.IFinalService;

@Service
public class FinalService implements IFinalService {

	@Autowired
	private IFinalRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Final> getAll() {
		return (List<Final>) repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Final getById(long id) {
		return repository.getById(id);
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
	public boolean save(Final obj) {
		boolean success = true;
		try {
			repository.save(obj);
		} catch (Exception e) {
			success = false;
		}
		return success;

	}

}
