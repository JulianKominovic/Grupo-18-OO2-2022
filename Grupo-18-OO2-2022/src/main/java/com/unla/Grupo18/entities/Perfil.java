package com.unla.Grupo18.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "perfil")

public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "rol")
	@NotEmpty
	private String rol;

	@Column(name = "habilitado")
	private boolean habilitado;

	public Perfil() {}

	public Perfil(long id, String rol) {
		super();
		this.id = id;
		this.rol = rol;
	}

	public Perfil(String rol) {
		super();
		this.rol = rol;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean deshabilitado) {
		this.habilitado = deshabilitado;
	}

	@Override
	public String toString() {
		return rol;
	}
}
