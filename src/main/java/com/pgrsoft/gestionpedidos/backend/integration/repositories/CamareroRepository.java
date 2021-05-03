package com.pgrsoft.gestionpedidos.backend.integration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pgrsoft.gestionpedidos.backend.integration.model.CamareroDTO;

@Repository
public interface CamareroRepository extends JpaRepository<CamareroDTO,Long>{

	public CamareroDTO findByNombre (String nombre);
	
}
