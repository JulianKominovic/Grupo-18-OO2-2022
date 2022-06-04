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
@Table(name="carrera", uniqueConstraints = {@UniqueConstraint(columnNames = {"carrera_name"})})


public class Carrera {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@Column(name = "carrera_name")
	@NotEmpty
	private String carrera_name; 
	
	@ManyToOne
	@JoinColumn(name = "departamento_id")
	private Departamento departamento; 
	
	
	public Carrera(long id, String carrera_name) {
		super();
		this.id = id;
		this.carrera_name = carrera_name; 
	}

}
