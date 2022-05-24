package com.unla.Grupo18.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="departamento",uniqueConstraints = {@UniqueConstraint(columnNames= {"departamento"})})


public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column (name ="departamento")
	@NotEmpty
	private String departamento; 
	
	public Departamento() {}
	
	public Departamento(long id,String departamento) {
		super();
		this.id = id; 
		this.departamento = departamento; 
	}

	
	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	@Override 
	public String toString() {
		return this.departamento; 
	}
	
	
	
}
