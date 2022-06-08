package com.unla.Grupo18.entities;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
@Table(name="departamento",uniqueConstraints = {@UniqueConstraint(columnNames= {"departamento_name"})})


public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column (name ="departamento_name")
	@NotEmpty(message="el campo no debe estar vacio") 
	private String departamento_name; 
	
	@Override
	public boolean equals(Object obj) {
		Departamento other = (Departamento) obj;
		return Objects.equals(departamento_name, other.departamento_name);
	}
	
	@Override
	public String toString() {
		return departamento_name; 
	}

}
