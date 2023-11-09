package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Equipo;
import com.example.demo.service.EquipoServiceImpl;

@RestController
@RequestMapping("/api")
public class EquipoController {
	
	@Autowired
	EquipoServiceImpl EquipoServiceImpl;
	
	@GetMapping("/Equipos")
	public List<Equipo> listarCEquipos(){
		return EquipoServiceImpl.listarEquipo();
	}
	
	
	@PostMapping("/Equipos")
	public Equipo salvarEquipo(@RequestBody Equipo Equipo) {
		
		return EquipoServiceImpl.guardarEquipo(Equipo);
	}
	
	
	@GetMapping("/Equipos/{id}")
	public Equipo EquipoXID(@PathVariable(name="id") int id) {
		
		Equipo Equipo_xid= new Equipo();
		
		Equipo_xid=EquipoServiceImpl.EquipoXID(id);
		
		System.out.println("Equipo XID: "+Equipo_xid);
		
		return Equipo_xid;
	}
	
	@PutMapping("/Equipos/{id}")
	public Equipo actualizarEquipo(@PathVariable(name="id")int id,@RequestBody Equipo Equipo) {
		
		Equipo Equipo_seleccionado= new Equipo();
		Equipo Equipo_actualizado= new Equipo();
		
		Equipo_seleccionado= EquipoServiceImpl.EquipoXID(id);
		
		Equipo_seleccionado.setNombre(Equipo.getNombre());
		Equipo_seleccionado.setFacultad(Equipo.getFacultad());
		
		Equipo_actualizado = EquipoServiceImpl.actualizarEquipo(Equipo_seleccionado);
		
		System.out.println("El Equipo actualizado es: "+ Equipo_actualizado);
		
		return Equipo_actualizado;
	}
	
	@DeleteMapping("/Equipos/{id}")
	public void eleiminarEquipo(@PathVariable(name="id")int id) {
		EquipoServiceImpl.eliminarEquipo(id);
	}
	
	
}