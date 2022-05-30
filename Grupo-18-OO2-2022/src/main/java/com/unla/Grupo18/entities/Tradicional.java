package com.unla.Grupo18.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data 
@NoArgsConstructor
public class Tradicional extends Aula{
	
	@Column(name = "cantBancos")
	@NotEmpty
	private int cantBancos;
	
	@Column(name = "pizarron")
	@NotEmpty
	private String pizarron;
	
	@Column(name = "tieneProyector")
	private boolean tieneProyector;

}
