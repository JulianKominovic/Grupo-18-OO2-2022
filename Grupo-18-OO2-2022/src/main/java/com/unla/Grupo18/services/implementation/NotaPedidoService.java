package com.unla.Grupo18.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unla.Grupo18.entities.NotaPedido;
import com.unla.Grupo18.repositories.INotaPedidoRepository;
import com.unla.Grupo18.services.INotaPedidoService;

@Service
public class NotaPedidoService implements INotaPedidoService {

	@Autowired
	private INotaPedidoRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<NotaPedido> getAll() {
		return (List<NotaPedido>) repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public NotaPedido getById(long id) {
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
	public boolean save(NotaPedido obj) {
		boolean success = true;
		try {
			repository.save(obj);
		} catch (Exception e) {
			success = false;
		}
		return success;

	}

}
