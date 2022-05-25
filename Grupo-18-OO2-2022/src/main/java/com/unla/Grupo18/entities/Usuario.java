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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data @NoArgsConstructor
@Table(name = "usuario", uniqueConstraints = {@UniqueConstraint(columnNames = {"documento", "correoElectronico", "nombreDeUsuario"})})

public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "nombre")
	@NotEmpty
	private String nombre;

	@Column(name = "apellido")
	@NotEmpty
	private String apellido;
	
	@Column(name = "tipoDocumento")
	private String tipoDocumento;

	@Column(name = "documento")
	@NotNull
	private int documento;

	@Column(name = "correoElectronico")
	@Email
	private String correoElectronico;

	@Column(name = "nombreDeUsuario")
	@NotEmpty
	private String nombreDeUsuario;

	@Column(name = "contrasena")
	@NotEmpty
	private String contrasena;

	@ManyToOne
	@JoinColumn(name = "perfiles_id")
	private Perfiles perfiles;

	@Column(name = "deshabilitado")
	private boolean deshabilitado;

	public Usuario(long id, String nombre, String apellido, String tipoDocumento, int documento,
			String correoElectronico, String nombreDeUsuario, String contrasena) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
		this.correoElectronico = correoElectronico;
		this.nombreDeUsuario = nombreDeUsuario;
		this.contrasena = contrasena;

	}

	public Usuario(String nombre, String apellido, String tipoDocumento, int documento, String correoElectronico,
			String nombreDeUsuario, String contrasena) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
		this.correoElectronico = correoElectronico;
		this.nombreDeUsuario = nombreDeUsuario;
		this.contrasena = contrasena;

	}

}