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

@Entity
@Table(name="espacio")
public class Espacio{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
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

	public Espacio() {}

	public Espacio(@NotEmpty LocalDate fecha, @NotEmpty char turno, Aula aula, @NotEmpty boolean libre) {
		super();
		this.fecha = fecha;
		this.turno = turno;
		this.aula = aula;
		this.libre = libre;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public char getTurno() {
		return turno;
	}

	public void setTurno(char turno) {
		this.turno = turno;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public boolean isLibre() {
		return libre;
	}

	public void setLibre(boolean libre) {
		this.libre = libre;
	}

	@Override
	public String toString() {
		return "Espacio [id=" + id + ", fecha=" + fecha + ", turno=" + turno + ", aula=" + aula + ", libre=" + libre
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		Espacio other = (Espacio) obj;
		return id == other.id;
	}
}
