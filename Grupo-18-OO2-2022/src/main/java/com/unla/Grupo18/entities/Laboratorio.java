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
@Table(name="laboratorio")
public class Laboratorio extends Aula{
	
	@Column(name = "cant_pc")
	@NotEmpty
	private int cantPC;
	
	@Column(name = "cantSillas")
	@NotEmpty
	private int cantSillas;

}
