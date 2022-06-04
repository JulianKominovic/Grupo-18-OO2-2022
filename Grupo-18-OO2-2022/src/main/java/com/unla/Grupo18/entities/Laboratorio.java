package com.unla.Grupo18.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data 
@NoArgsConstructor
public class Laboratorio extends Aula{
	
	@Column(name = "cant_pc")
	@NotNull
	private int cantPC;
	
	@Column(name = "cantSillas")
	@NotNull
	private int cantSillas;
}
