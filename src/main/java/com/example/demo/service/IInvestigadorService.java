package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Investigador;


public interface IInvestigadorService {

	//Metodos del CRUD
		public List<Investigador> listarInvestigador(); //Listar All 
		
		public Investigador guardarInvestigador(Investigador Investigador);	//Guarda un Investigador CREATE
		
		public Investigador InvestigadorXID(int id); //Leer datos de un Investigador READ
		
		public Investigador actualizarInvestigador(Investigador Investigador); //Actualiza datos del Investigador UPDATE
		
		public void eliminarInvestigador(int id);// Elimina el Investigador DELETE
	
}
