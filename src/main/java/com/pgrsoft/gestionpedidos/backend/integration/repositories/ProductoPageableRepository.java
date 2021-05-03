package com.pgrsoft.gestionpedidos.backend.integration.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pgrsoft.gestionpedidos.backend.integration.model.CategoriaDTO;
import com.pgrsoft.gestionpedidos.backend.integration.model.ProductoDTO;

@Repository
public interface ProductoPageableRepository extends PagingAndSortingRepository<ProductoDTO, Long> {

	public Page<ProductoDTO> findByCategoria(CategoriaDTO categoria, Pageable pageable);
	
	public Page<ProductoDTO> findByCategoriaOrPrecio(CategoriaDTO c, double precio, Pageable pag);
	
	public Page<ProductoDTO> findByCategoriaOrPrecioLessThan(CategoriaDTO c, double precio, Pageable pag);

}
