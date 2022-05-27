package com.unla.Grupo18.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;


@Entity
public class Laboratorio extends Aula{
	
	@Column(name = "cant_pc")
	@NotEmpty
	private int cantPC;
	
	@Column(name = "cantSillas")
	@NotEmpty
	private int cantSillas;

}
