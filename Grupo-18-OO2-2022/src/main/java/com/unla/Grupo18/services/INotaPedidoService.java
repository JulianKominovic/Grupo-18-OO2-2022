package com.unla.Grupo18.services;

import java.util.List;

import com.unla.Grupo18.entities.NotaPedido;

public interface INotaPedidoService {
	List<NotaPedido> getAll();

	NotaPedido getById(long id);

	boolean eliminar(long id);

	boolean save(NotaPedido obj);
}
