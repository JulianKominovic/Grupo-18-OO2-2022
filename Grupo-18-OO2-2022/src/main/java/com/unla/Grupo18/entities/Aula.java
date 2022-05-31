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
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)  
@Table(name = "aula")
public abstract class Aula{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;
	
	@Column(name = "numero")
	@NotNull
	protected int numero;
	
	@ManyToOne
	@JoinColumn(name = "edificio_id")
	protected Edificio edificio;

}
