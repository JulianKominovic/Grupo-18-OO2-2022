package com.unla.Grupo18.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.unla.Grupo18.util.NotaPedidoStatusEnum;

import lombok.Data;
import lombok.NoArgsConstructor;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "nota_pedido")
@Data
@NoArgsConstructor
public class NotaPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "fecha_inicio_pedido")
	private LocalDateTime fechaInicioPedido;

	@Column(name = "cant_estudiantes")
	private int cantEstudiantes;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "espacio", nullable = false)
	private Espacio espacio;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "materia", nullable = false)
	private Materia materia;
	@Column(name = "observaciones")
	private String observaciones;
	@Column(name = "status")
	private NotaPedidoStatusEnum status;

	public boolean equals(NotaPedido nota) {
		return this.getId() != nota.getId();
	}

}
