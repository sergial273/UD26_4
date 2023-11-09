package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;



@Entity
@Table(name="investigadores")//en caso que la tabala sea diferente
public class Investigador {

	//Atributos de entidad curso
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	
	private int dni;
	private String nombre;
	
	@OneToMany
    @JoinColumn(name="id")
    private List<Reserva> reservas;
	
	@ManyToOne
    @JoinColumn(name="facultad")
    private Facultad facultad;
	
	//Constructores
	
	public Investigador() {
	
	}

	public Investigador(int id, int dni, String nombre, List<Reserva> reservas, Facultad facultad) {
		this.id = id;
		this.dni = dni;
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

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
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
		return "Investigador [id=" + id + ", dni=" + dni + ", nombre=" + nombre + "]";
	}


	
	
	
}