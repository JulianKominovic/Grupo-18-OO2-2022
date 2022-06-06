package com.unla.Grupo18.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "final")
@Data
@EqualsAndHashCode(callSuper = false)
public class Final extends NotaPedido {

	@Column(name = "fecha_examen")
	private LocalDate fechaExamen;

	@Override
	public String toString() {
		return super.toString() + "Final [fechaExamen=" + fechaExamen + "]";
	}

}
