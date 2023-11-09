package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Equipo;


public interface IEquipoService {

	//Metodos del CRUD
		public List<Equipo> listarEquipo(); //Listar All 
		
		public Equipo guardarEquipo(Equipo Equipo);	//Guarda un Equipo CREATE
		
		public Equipo EquipoXID(int id); //Leer datos de un Equipo READ
		
		public Equipo actualizarEquipo(Equipo Equipo); //Actualiza datos del Equipo UPDATE
		
		public void eliminarEquipo(int id);// Elimina el Equipo DELETE
	
}
