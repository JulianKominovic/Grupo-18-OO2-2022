package com.unla.Grupo18.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "perfiles", uniqueConstraints = {@UniqueConstraint(columnNames = {"rol"})})

public class Perfiles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "rol")
	@NotEmpty
	private String rol;

	@Column(name = "deshabilitado")
	private boolean deshabilitado;


	public Perfiles(long id, String rol) {
		super();
		this.id = id;
		this.rol = rol;
	}

	public Perfiles(String rol) {
		super();
		this.rol = rol;
	}

	@Override
	public String toString() {
		return rol;
	}

}