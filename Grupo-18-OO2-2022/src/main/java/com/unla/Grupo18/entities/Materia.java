package com.unla.Grupo18.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data @NoArgsConstructor
@Table(name="materia",uniqueConstraints = {@UniqueConstraint(columnNames = {"codMateria","materia_name"})})

public class Materia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@Column(name="codMateria")
	@NotEmpty
	private int codMateria;
	
	@Column(name="materia_name")
	@NotEmpty
	private String materia_name; 
	
	@ManyToOne
	@JoinColumn(name="carrera_id")
	private Carrera carrera; 
	
	public Materia(long id, int codMateria, String materia_name) {
		super(); 
		this.id=id; 
		this.codMateria = codMateria;
		this.materia_name = materia_name; 
		
	}
	
}
