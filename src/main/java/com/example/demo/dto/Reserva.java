package com.example.demo.dto;

import jakarta.persistence.*;

@Entity
@Table(name="reservas")//en caso que la tabala sea diferente
public class Reserva {

	//Atributos de entidad registro_curso
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "dni")
    Investigador investigador;
 
    @ManyToOne
    @JoinColumn(name = "equipo")
    Equipo equipo;
	
	
	private String comienzo;
	private String fin;
	
	//Constructores
	
	public Reserva() {
	
	}

	public Reserva(int id, Investigador investigador, Equipo equipo, String comienzo, String fin) {
		this.id = id;
		this.investigador = investigador;
		this.equipo = equipo;
		this.comienzo = comienzo;
		this.fin = fin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Investigador getInvestigador() {
		return investigador;
	}

	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public String getComienzo() {
		return comienzo;
	}

	public void setComienzo(String comienzo) {
		this.comienzo = comienzo;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", investigador=" + investigador + ", equipo=" + equipo + ", comienzo=" + comienzo
				+ ", fin=" + fin + "]";
	}


}

