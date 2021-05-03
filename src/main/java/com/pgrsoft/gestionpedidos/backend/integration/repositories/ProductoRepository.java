package com.pgrsoft.gestionpedidos.backend.integration.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pgrsoft.gestionpedidos.backend.integration.model.CategoriaDTO;
import com.pgrsoft.gestionpedidos.backend.integration.model.ProductoDTO;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoDTO, Long>{

	public List<ProductoDTO>findByCategoria(CategoriaDTO categoria);
	
	public List<ProductoDTO> findByPrecioGreaterThanAndPrecioLessThan(double min, double max);
	
	public List<ProductoDTO> findByPrecioBetween(double min, double max);
	
}
