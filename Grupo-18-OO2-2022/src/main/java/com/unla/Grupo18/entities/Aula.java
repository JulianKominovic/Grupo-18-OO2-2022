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
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)  
@Table(name = "aula")
public abstract class Aula{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;
	
	@Column(name = "numero")
	@NotEmpty
	protected int numero;
	
	@ManyToOne
	@JoinColumn(name = "edificio_id")
	protected Edificio edificio;

}
