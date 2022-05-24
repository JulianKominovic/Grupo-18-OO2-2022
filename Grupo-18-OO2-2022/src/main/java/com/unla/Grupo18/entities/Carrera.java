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
@Table(name="carrera", uniqueConstraints = {@UniqueConstraint(columnNames = {"carrera"})})


public class Carrera {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@Column(name = "carrera")
	@NotEmpty
	private String carrera; 
	
	@ManyToOne
	@JoinColumn(name = "departamento_id")
	private Departamento departamento; 
	
	public Carrera() {} 
	
	public Carrera(long id, String carrera) {
		super();
		this.id = id;
		this.carrera = carrera; 
	}

	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public String toString() {
		return "Carrera [id=" + id + "nombre="+ carrera + "departamento="+departamento+"]";
	}
	
	public boolean equals(String carrera) {
		return this.carrera.equalsIgnoreCase(carrera);
	}
	
}
