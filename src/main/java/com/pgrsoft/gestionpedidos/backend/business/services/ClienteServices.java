package com.pgrsoft.gestionpedidos.backend.business.services;

import java.util.List;

import com.pgrsoft.gestionpedidos.backend.business.model.Cliente;

public interface ClienteServices {

	public Cliente getById(Long id);
	
	public List<Cliente> getAll();
	
	public Cliente create(Cliente cliente);
	
	
}
