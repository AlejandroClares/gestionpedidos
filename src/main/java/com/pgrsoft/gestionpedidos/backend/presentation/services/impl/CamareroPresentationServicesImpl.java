package com.pgrsoft.gestionpedidos.backend.presentation.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.business.model.Camarero;
import com.pgrsoft.gestionpedidos.backend.business.services.CamareroServices;
import com.pgrsoft.gestionpedidos.backend.presentation.model.CamareroVO;
import com.pgrsoft.gestionpedidos.backend.presentation.services.CamareroPresentationServices;

@Service
public class CamareroPresentationServicesImpl implements CamareroPresentationServices {

	@Autowired
	private CamareroServices camareroServices;

	@Autowired
	private DozerBeanMapper dozerBeanMapper;
	
	@Override
	public CamareroVO getById(final Long id) throws Exception {
			
		CamareroVO camareroVO = null;
		
		try {
			final Camarero camarero = camareroServices.getById(id);
			camareroVO = this.dozerBeanMapper.map(camarero, CamareroVO.class);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return camareroVO;
	}

	@Override
	public List<CamareroVO> getAll() throws Exception {
		
		List<CamareroVO> camarerosVO;
		
		try {
			final List<Camarero> camareros = camareroServices.getAll();
		
			camarerosVO = camareros.stream()
				.map(x -> dozerBeanMapper.map(x, CamareroVO.class))
				.collect(Collectors.toList());
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return camarerosVO;
	}

	@Override
	public CamareroVO create(final CamareroVO newCamareroVO) throws Exception {
		
		CamareroVO camareroVO = null;
		
		try {
			final Camarero newCamarero = dozerBeanMapper.map(newCamareroVO, Camarero.class);
			final Camarero createdCamarero = camareroServices.create(newCamarero);
			camareroVO = dozerBeanMapper.map(createdCamarero, CamareroVO.class);
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return camareroVO;
	}

}
