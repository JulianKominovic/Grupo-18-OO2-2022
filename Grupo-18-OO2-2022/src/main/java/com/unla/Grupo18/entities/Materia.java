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

@Entity
@Table(name="materia",uniqueConstraints = {@UniqueConstraint(columnNames = {"codMateria","materia"})})

public class Materia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@Column(name="codMateria")
	@NotEmpty
	private int codMateria;
	
	@Column(name="materia")
	@NotEmpty
	private String materia; 
	
	@ManyToOne
	@JoinColumn(name="carrera_id")
	private Carrera carrera; 
	
	public Materia() {} 
	
	public Materia(long id, int codMateria, String materia) {
		super(); 
		this.id=id; 
		this.codMateria = codMateria;
		this.materia = materia; 
		
	}

	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public int getCodMateria() {
		return codMateria;
	}

	public void setCodMateria(int codMateria) {
		this.codMateria = codMateria;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
}
