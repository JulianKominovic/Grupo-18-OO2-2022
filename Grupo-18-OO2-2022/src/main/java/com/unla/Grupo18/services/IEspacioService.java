package com.unla.Grupo18.services;

import java.util.List;

import com.unla.Grupo18.entities.Espacio;

public interface IEspacioService {

	public List<Espacio> getAll();

	public Espacio save(Espacio espacio);

	public Espacio buscar(long id);

	public void eliminar(long id);
}
