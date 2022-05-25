package com.unla.Grupo18.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "curso")
public class Curso extends NotaPedido {

	@NotNull
	@NotEmpty
	@Column(name = "cod_curso")
	private String codCurso;

}
