package com.unla.Grupo18.services;

import java.util.List;

import com.unla.Grupo18.entities.Final;

public interface IFinalService {

	List<Final> getAll();

	Final getById(long id);

	boolean eliminar(long id);

	boolean save(Final obj);
}
