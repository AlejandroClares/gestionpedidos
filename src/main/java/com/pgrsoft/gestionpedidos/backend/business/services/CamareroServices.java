package com.pgrsoft.gestionpedidos.backend.business.services;

import java.util.List;

import com.pgrsoft.gestionpedidos.backend.business.model.Camarero;

public interface CamareroServices {

	public Camarero getById(Long id) throws Exception;
	
	public Camarero create(Camarero camarero) throws Exception;
	
	public List<Camarero> getAll() throws Exception;
	
}
