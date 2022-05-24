package com.unla.Grupo18.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@PrimaryKeyJoinColumn(name="id_aula")
@Table(name="tradicional")
public class Tradicional extends Aula{
	
	@Column(name = "cantBancos")
	@NotEmpty
	private int cantBancos;
	
	@Column(name = "pizarron")
	@NotEmpty
	private String pizarron;
	
	@Column(name = "tieneProyector")
	private boolean tieneProyector;

	public Tradicional() {}

	public Tradicional(@NotEmpty int cantBancos, @NotEmpty String pizarron, boolean tieneProyector) {
		super();
		this.cantBancos = cantBancos;
		this.pizarron = pizarron;
		this.tieneProyector = tieneProyector;
	}

	public int getCantBancos() {
		return cantBancos;
	}

	public void setCantBancos(int cantBancos) {
		this.cantBancos = cantBancos;
	}

	public String getPizarron() {
		return pizarron;
	}

	public void setPizarron(String pizarron) {
		this.pizarron = pizarron;
	}

	public boolean isTieneProyector() {
		return tieneProyector;
	}

	public void setTieneProyector(boolean tieneProyector) {
		this.tieneProyector = tieneProyector;
	}

	@Override
	public String toString() {
		return "Tradicional [cantBancos=" + cantBancos + ", pizarron=" + pizarron + ", tieneProyector=" + tieneProyector
				+ ", id=" + id + ", numero=" + numero + ", edificio=" + edificio + "]";
	}
}
