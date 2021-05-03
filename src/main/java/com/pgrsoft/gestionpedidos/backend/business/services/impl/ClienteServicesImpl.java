package com.pgrsoft.gestionpedidos.backend.business.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.business.model.Cliente;
import com.pgrsoft.gestionpedidos.backend.business.services.ClienteServices;
import com.pgrsoft.gestionpedidos.backend.integration.model.ClienteDTO;
import com.pgrsoft.gestionpedidos.backend.integration.repositories.ClienteRepository;

@Service
@Transactional
public class ClienteServicesImpl implements ClienteServices {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private DozerBeanMapper dozerBeanMapper;
	
	@Override
	public Cliente getById(Long id) {
		final ClienteDTO clienteDTO = clienteRepository.getOne(id);
		final Cliente cliente = dozerBeanMapper.map(clienteDTO, Cliente.class);
		
		return cliente;
	}

	@Override
	public List<Cliente> getAll() {
		
		final List<ClienteDTO> clientesDTO = clienteRepository.findAll();
		
		return clientesDTO.stream()
			.map(x -> dozerBeanMapper.map(x, Cliente.class))
			.collect(Collectors.toList());
	
	}

	@Override
	public Cliente create(final Cliente cliente) {
		
		final ClienteDTO newClienteDTO = dozerBeanMapper.map(cliente, ClienteDTO.class);
		
		final ClienteDTO createdClienteDTO = clienteRepository.save(newClienteDTO);
		
		final Cliente createdCliente = dozerBeanMapper.map(createdClienteDTO, Cliente.class);
		
		return createdCliente;
	}

}
