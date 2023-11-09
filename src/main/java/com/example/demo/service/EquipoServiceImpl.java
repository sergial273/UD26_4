package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IEquipoDAO;
import com.example.demo.dto.Equipo;

@Service
public class EquipoServiceImpl implements IEquipoService {
	
	@Autowired
	IEquipoDAO iEquipoDAO;

	@Override
	public List<Equipo> listarEquipo() {
		return iEquipoDAO.findAll();
	}

	@Override
	public Equipo guardarEquipo(Equipo curso) {
		return iEquipoDAO.save(curso);
	}

	@Override
	public Equipo EquipoXID(int id) {
		return iEquipoDAO.findById(id).get();
	}

	@Override
	public Equipo actualizarEquipo(Equipo curso) {
		return iEquipoDAO.save(curso);
	}

	@Override
	public void eliminarEquipo(int id) {
		iEquipoDAO.deleteById(id);
	}

}
