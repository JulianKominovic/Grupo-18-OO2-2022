package com.unla.Grupo18.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "curso")
@EqualsAndHashCode(callSuper = false)
public class Curso extends NotaPedido {

	@Column(name = "cod_curso")
	private String codCurso;

	@Override
	public String toString() {
		return super.toString() + "Curso [codCurso=" + codCurso + "]";
	}

}
