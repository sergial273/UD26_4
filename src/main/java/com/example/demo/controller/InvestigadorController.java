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

import com.example.demo.dto.Investigador;
import com.example.demo.service.InvestigadorServiceImpl;

@RestController
@RequestMapping("/api")
public class InvestigadorController {
	
	@Autowired
	InvestigadorServiceImpl InvestigadorServiceImpl;
	
	@GetMapping("/Investigadors")
	public List<Investigador> listarCInvestigadors(){
		return InvestigadorServiceImpl.listarInvestigador();
	}
	
	
	@PostMapping("/Investigadors")
	public Investigador salvarInvestigador(@RequestBody Investigador Investigador) {
		
		return InvestigadorServiceImpl.guardarInvestigador(Investigador);
	}
	
	
	@GetMapping("/Investigadors/{id}")
	public Investigador InvestigadorXID(@PathVariable(name="id") int id) {
		
		Investigador Investigador_xid= new Investigador();
		
		Investigador_xid=InvestigadorServiceImpl.InvestigadorXID(id);
		
		System.out.println("Investigador XID: "+Investigador_xid);
		
		return Investigador_xid;
	}
	
	@PutMapping("/Investigadors/{id}")
	public Investigador actualizarInvestigador(@PathVariable(name="id")int id,@RequestBody Investigador Investigador) {
		
		Investigador Investigador_seleccionado= new Investigador();
		Investigador Investigador_actualizado= new Investigador();
		
		Investigador_seleccionado= InvestigadorServiceImpl.InvestigadorXID(id);
		
		Investigador_seleccionado.setNombre(Investigador.getNombre());
		Investigador_seleccionado.setDni(Investigador.getDni());
		Investigador_seleccionado.setFacultad(Investigador.getFacultad());
		
		Investigador_actualizado = InvestigadorServiceImpl.actualizarInvestigador(Investigador_seleccionado);
		
		System.out.println("El Investigador actualizado es: "+ Investigador_actualizado);
		
		return Investigador_actualizado;
	}
	
	@DeleteMapping("/Investigadors/{id}")
	public void eleiminarInvestigador(@PathVariable(name="id")int id) {
		InvestigadorServiceImpl.eliminarInvestigador(id);
	}
	
	
}