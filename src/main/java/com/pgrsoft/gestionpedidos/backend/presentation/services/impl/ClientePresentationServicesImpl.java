package com.pgrsoft.gestionpedidos.backend.presentation.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.business.model.Cliente;
import com.pgrsoft.gestionpedidos.backend.business.services.ClienteServices;
import com.pgrsoft.gestionpedidos.backend.presentation.model.ClienteVO;
import com.pgrsoft.gestionpedidos.backend.presentation.services.ClientePresentationServices;

@Service
public class ClientePresentationServicesImpl implements ClientePresentationServices{

	@Autowired
	private ClienteServices clienteServices;
	
	@Autowired
	private DozerBeanMapper dozerBeanMapper;
	
	@Override
	public List<ClienteVO> getAll() {
		
		final List<Cliente> clientes = this.clienteServices.getAll();
		
		return clientes.stream()
				.map(x -> this.dozerBeanMapper.map(x, ClienteVO.class))
				.collect(Collectors.toList());	
	}

	@Override
	public ClienteVO getById(Long id) {
		
		final Cliente cliente = this.clienteServices.getById(id);
		
		return this.dozerBeanMapper.map(cliente, ClienteVO.class);
	}

	@Override
	public ClienteVO create(ClienteVO cliente) {
		
		final Cliente newCliente = this.dozerBeanMapper.map(cliente, Cliente.class);
		
		final Cliente createdCliente = this.clienteServices.create(newCliente);
		
		final ClienteVO createdClienteVO = this.dozerBeanMapper.map(createdCliente, ClienteVO.class);
		
		return createdClienteVO;
	}

}
