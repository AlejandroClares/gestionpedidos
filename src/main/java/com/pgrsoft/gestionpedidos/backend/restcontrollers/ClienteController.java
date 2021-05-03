package com.pgrsoft.gestionpedidos.backend.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pgrsoft.gestionpedidos.backend.presentation.model.ClienteVO;
import com.pgrsoft.gestionpedidos.backend.presentation.services.ClientePresentationServices;

@RestController
@CrossOrigin
@RequestMapping(value="/clientes")
public class ClienteController {

	@Autowired
	private ClientePresentationServices clientePresentationServices;
	
	@RequestMapping(value="",
					method=RequestMethod.GET,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public List<ClienteVO> getAll() {
		return this.clientePresentationServices.getAll();
	}
	
	@RequestMapping(value="/{id}",
					method=RequestMethod.GET,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public ClienteVO getById(@PathVariable Long id) {
		return this.clientePresentationServices.getById(id);
	}
	
	@RequestMapping(value="",
					method=RequestMethod.POST,
					consumes=MediaType.APPLICATION_JSON_VALUE,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public ClienteVO create(@RequestBody ClienteVO cliente) {
		return this.clientePresentationServices.create(cliente);	
	}
	
	
}
