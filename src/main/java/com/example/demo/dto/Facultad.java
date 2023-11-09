package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name="facultades")//en caso que la tabla sea diferente
public class Facultad  {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private Long id;
	
	private String nombre;
	
    @OneToMany
    @JoinColumn(name="id")
    private List<Investigador> investigadores;
    
    @OneToMany
    @JoinColumn(name="id")
    private List<Equipo> equipos;
	
	//Constructores
	
	public Facultad() {
	
	}

	public Facultad(Long id, String nombre, List<Investigador> investigadores, List<Equipo> equipos) {
		this.id = id;
		this.nombre = nombre;
		this.investigadores = investigadores;
		this.equipos = equipos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Investigador")
	public List<Investigador> getInvestigadores() {
		return investigadores;
	}

	public void setInvestigadores(List<Investigador> investigadores) {
		this.investigadores = investigadores;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Equipo")
	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	@Override
	public String toString() {
		return "Facultad [id=" + id + ", nombre=" + nombre + "]";
	}

	
}