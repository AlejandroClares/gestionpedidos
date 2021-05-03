package com.pgrsoft.gestionpedidos.backend.business.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.business.model.Camarero;
import com.pgrsoft.gestionpedidos.backend.business.services.CamareroServices;
import com.pgrsoft.gestionpedidos.backend.integration.model.CamareroDTO;
import com.pgrsoft.gestionpedidos.backend.integration.repositories.CamareroRepository;

@Service
@Transactional
public class CamareroServicesImpl implements CamareroServices {

	@Autowired
	private CamareroRepository camareroRepository;
	
	@Autowired
	private DozerBeanMapper dozerBeanMapper;
	
	@Override
	public Camarero getById(Long id) throws IllegalArgumentException {
		final CamareroDTO camareroDTO = camareroRepository.getOne(id);
		final Camarero camarero = dozerBeanMapper.map(camareroDTO, Camarero.class);
		return camarero;
	}

	@Override
	public Camarero create(final Camarero camarero) {
		final CamareroDTO camareroDTO = dozerBeanMapper.map(camarero, CamareroDTO.class);
		final CamareroDTO createdCamarero = camareroRepository.save(camareroDTO);
		return dozerBeanMapper.map(createdCamarero, Camarero.class);
	}

	
	@Override
	public List<Camarero> getAll() {
		
		final List<CamareroDTO> camarerosDTO = camareroRepository.findAll();
		
		final List<Camarero> camareros = camarerosDTO.stream()
			.map(x -> dozerBeanMapper.map(x,Camarero.class))
			.collect(Collectors.toList());
			
		return camareros;
	}

}
