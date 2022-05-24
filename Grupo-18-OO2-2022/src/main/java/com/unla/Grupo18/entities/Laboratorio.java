package com.unla.Grupo18.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@PrimaryKeyJoinColumn(name="id_aula")
@Table(name="laboratorio")
public class Laboratorio extends Aula{
	
	@Column(name = "cant_pc")
	@NotEmpty
	private int cantPC;
	
	@Column(name = "cantSillas")
	@NotEmpty
	private int cantSillas;

	public Laboratorio() {
		super();
	}

	public Laboratorio(@NotEmpty int cantPC, @NotEmpty int cantSillas) {
		super();
		this.cantPC = cantPC;
		this.cantSillas = cantSillas;
	}

	public int getCantPC() {
		return cantPC;
	}

	public void setCantPC(int cantPC) {
		this.cantPC = cantPC;
	}

	public int getCantSillas() {
		return cantSillas;
	}

	public void setCantSillas(int cantSillas) {
		this.cantSillas = cantSillas;
	}

	@Override
	public String toString() {
		return "Laboratorio [cantPC=" + cantPC + ", cantSillas=" + cantSillas + ", id=" + id + ", numero=" + numero
				+ ", edificio=" + edificio + "]";
	}
}
