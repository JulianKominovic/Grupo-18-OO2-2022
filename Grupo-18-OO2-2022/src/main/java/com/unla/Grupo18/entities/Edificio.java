package com.unla.Grupo18.entities;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="edificio")
public class Edificio{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "edificio")
	@NotEmpty
	private String edificio;
	
	@OneToMany(mappedBy = "edificio")
	//@JoinColumn(name = "aula_id")
	private Set<Aula> aulas;
	
	public Edificio() {}

	public Edificio(@NotEmpty String edificio) {
		super();
		this.edificio = edificio;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEdificio() {
		return edificio;
	}

	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}

	public Set<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(Set<Aula> aulas) {
		this.aulas = aulas;
	}

	@Override
	public String toString() {
		return "Edificio [id=" + id + ", edificio=" + edificio + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Edificio other = (Edificio) obj;
		return id == other.id;
	}
}
