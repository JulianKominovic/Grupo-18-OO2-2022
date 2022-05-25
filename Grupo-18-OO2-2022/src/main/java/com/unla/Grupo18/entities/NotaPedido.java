package com.unla.Grupo18.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Inheritance
@Entity
@Table(name = "nota_pedido")
public abstract class NotaPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@NotEmpty
	@Column(name = "fecha_inicio_pedido")
	private LocalDateTime fechaInicioPedido;
	@NotNull
	@NotEmpty
	@Column(name = "cant_estudiantes")
	private int cantEstudiantes;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "espacio", nullable = false, unique = true)
	private Espacio espacio;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "materia", nullable = false, unique = true)
	private Materia materia;
	private String observaciones;

}
