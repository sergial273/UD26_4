package com.example.demo.dto;

import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;



@Entity
@Table(name="equipos")//en caso que la tabala sea diferente
public class Equipo {

	//Atributos de entidad curso
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	
	private String nombre;
	
	@OneToMany
    @JoinColumn(name="id")
    private List<Reserva> reservas;
	
	@ManyToOne
    @JoinColumn(name="facultad")
    private Facultad facultad;
	
	//Constructores
	
	public Equipo() {
	
	}

	public Equipo(int id, String nombre, List<Reserva> reservas, Facultad facultad) {
		this.id = id;
		this.nombre = nombre;
		this.reservas = reservas;
		this.facultad = facultad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Reserva")
	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombre + "]";
	}


	
	
	
}
