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

import com.example.demo.dto.Reserva;
import com.example.demo.service.ReservaServiceImpl;

@RestController
@RequestMapping("/api")
public class ReservaController {
	
	@Autowired
	ReservaServiceImpl ReservaServiceImpl;
	
	@GetMapping("/Reservas")
	public List<Reserva> listarCReservas(){
		return ReservaServiceImpl.listarReserva();
	}
	
	
	@PostMapping("/Reservas")
	public Reserva salvarReserva(@RequestBody Reserva Reserva) {
		
		return ReservaServiceImpl.guardarReserva(Reserva);
	}
	
	
	@GetMapping("/Reservas/{id}")
	public Reserva ReservaXID(@PathVariable(name="id") int id) {
		
		Reserva Reserva_xid= new Reserva();
		
		Reserva_xid=ReservaServiceImpl.ReservaXID(id);
		
		System.out.println("Reserva XID: "+Reserva_xid);
		
		return Reserva_xid;
	}
	
	@PutMapping("/Reservas/{id}")
	public Reserva actualizarReserva(@PathVariable(name="id")int id,@RequestBody Reserva Reserva) {
		
		Reserva Reserva_seleccionado= new Reserva();
		Reserva Reserva_actualizado= new Reserva();
		
		Reserva_seleccionado= ReservaServiceImpl.ReservaXID(id);
		
		Reserva_seleccionado.setEquipo(Reserva.getEquipo());
		Reserva_seleccionado.setInvestigador(Reserva.getInvestigador());
		Reserva_seleccionado.setComienzo(Reserva.getComienzo());
		Reserva_seleccionado.setFin(Reserva.getFin());
		
		Reserva_actualizado = ReservaServiceImpl.actualizarReserva(Reserva_seleccionado);
		
		System.out.println("El Reserva actualizado es: "+ Reserva_actualizado);
		
		return Reserva_actualizado;
	}
	
	@DeleteMapping("/Reservas/{id}")
	public void eleiminarReserva(@PathVariable(name="id")int id) {
		ReservaServiceImpl.eliminarReserva(id);
	}
	
	
}
