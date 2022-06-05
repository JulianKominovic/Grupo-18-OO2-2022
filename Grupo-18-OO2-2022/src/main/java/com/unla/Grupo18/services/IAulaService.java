package com.unla.Grupo18.services;

import java.util.List;

import com.unla.Grupo18.entities.Aula;

public interface IAulaService {
	List<Aula> getAulasByEdificio(Long id_edificio);

	Aula getAulaById(Long id);
}
