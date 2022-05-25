package com.unla.Grupo18.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "final")
public class Final extends NotaPedido {

	@NotNull
	@NotEmpty
	@Column(name = "fecha_examen")
	private LocalDateTime fechaExamen;

}
