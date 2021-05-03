package com.pgrsoft.gestionpedidos.backend.batch;

import org.springframework.batch.item.ItemProcessor;

import com.pgrsoft.gestionpedidos.backend.business.model.Camarero;

public class CamareroItemProcessor implements ItemProcessor<Camarero,Camarero> {

	@Override
	public Camarero process(final Camarero camarero) throws Exception {
		
		final String nombreMayusculas = camarero.getNombre().toUpperCase();
		final long randomId = (long)(Math.random() * 1000000);
		
		final Camarero transformedCamarero = new Camarero();
		
		transformedCamarero.setId(randomId);
		
//		transformedCamarero.setId(camarero.getId());	
		transformedCamarero.setNombre(nombreMayusculas);
		
		System.out.println("Converting (" + camarero + ") into (" + transformedCamarero + ")");
		
		return transformedCamarero;
	}

}
