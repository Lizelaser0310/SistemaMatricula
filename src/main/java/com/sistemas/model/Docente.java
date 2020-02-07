package com.sistemas.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "docente")
public class Docente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDocente;
	
	@Column(name = "sueldo_fijo", nullable = false)
	private double sueldo_fijo;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_docente", nullable = false)
	private Persona id_docente;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "docente_has_curso", joinColumns = @JoinColumn(name="id_docente", referencedColumnName = "idDocente"),
	inverseJoinColumns =  @JoinColumn(name = "id_curso", referencedColumnName = "idCurso"))
	List<Curso> curso;

	public int getIdDocente() {
		return idDocente;
	}

	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}

	public double getSueldo_fijo() {
		return sueldo_fijo;
	}

	public void setSueldo_fijo(double sueldo_fijo) {
		this.sueldo_fijo = sueldo_fijo;
	}

	public Persona getId_docente() {
		return id_docente;
	}

	public void setId_docente(Persona id_docente) {
		this.id_docente = id_docente;
	}

	public List<Curso> getCurso() {
		return curso;
	}

	public void setCurso(List<Curso> curso) {
		this.curso = curso;
	}



	
}
