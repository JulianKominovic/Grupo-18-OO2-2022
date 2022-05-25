package com.unla.Grupo18.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
@Table(name="espacio")
public class Espacio{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha")
	@NotEmpty
	private LocalDate fecha;
	
	@Column(name = "turno")
	@NotEmpty
	private char turno;
	
	@ManyToOne
	@JoinColumn(name = "aula_id")
	private Aula aula;
	
	@Column(name = "libre")
	@NotEmpty
	private boolean libre;

}
