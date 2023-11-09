package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IFacultadDAO;
import com.example.demo.dto.Facultad;

@Service
public class FacultadServiceImpl implements IFacultadService {
	
	@Autowired
	IFacultadDAO iFacultadDAO;

	@Override
	public List<Facultad> listarFacultad() {
		return iFacultadDAO.findAll();
	}

	@Override
	public Facultad guardarFacultad(Facultad curso) {
		return iFacultadDAO.save(curso);
	}

	@Override
	public Facultad FacultadXID(Long id) {
		return iFacultadDAO.findById(id).get();
	}

	@Override
	public Facultad actualizarFacultad(Facultad curso) {
		return iFacultadDAO.save(curso);
	}

	@Override
	public void eliminarFacultad(Long id) {
		iFacultadDAO.deleteById(id);
	}

}
