package com.unla.Grupo18.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="aula")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Aula{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;
	
	@Column(name = "numero")
	@NotEmpty
	protected int numero;
	
	@ManyToOne
	@JoinColumn(name = "edificio_id")
	protected Edificio edificio;

	public Aula() {}

	public Aula(@NotEmpty int numero) {
		super();
		this.numero = numero;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Edificio getEdificio() {
		return edificio;
	}

	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}

	@Override
	public String toString() {
		return "Aula [id=" + id + ", numero=" + numero + ", edificio=" + edificio + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Aula other = (Aula) obj;
		return id == other.id;
	}	
}
