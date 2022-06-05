package com.unla.Grupo18.models.requests;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostNotaPedido {

	private Long aulaNumero;

	private Integer cantEstudiantes;

	private String codCurso;

	private LocalDate fecha_unica;
	private List<LocalDate> fechas_multiples;

	private Long materia;

	private String observaciones;
	private TipoDeFechaEnum tipo_de_fecha;

	private String turno;

}
