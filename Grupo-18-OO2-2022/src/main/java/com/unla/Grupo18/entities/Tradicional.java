package com.unla.Grupo18.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Data 
@Getter
@Setter
@NoArgsConstructor
public class Tradicional extends Aula{
	
	@Column(name = "cantBancos")
	@NotNull
	private int cantBancos;
	
	@Column(name = "pizarron")
	@NotEmpty
	private String pizarron;
	
	@Column(name = "tieneProyector")
	private boolean tieneProyector;

}
