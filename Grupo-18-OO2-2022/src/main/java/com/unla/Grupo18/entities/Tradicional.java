package com.unla.Grupo18.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@PrimaryKeyJoinColumn(name="id_aula")
@Table(name="tradicional")
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
