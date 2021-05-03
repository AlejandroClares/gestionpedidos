package com.pgrsoft.gestionpedidos.backend.business.services;

import java.util.List;

import com.pgrsoft.gestionpedidos.backend.business.model.Categoria;
import com.pgrsoft.gestionpedidos.backend.business.model.Producto;
import com.pgrsoft.gestionpedidos.backend.common.Pagina;

public interface ProductoServices {

	public List<Producto> getAll() throws Exception;
	
	public Producto getById(Long id) throws Exception;
	
	public Producto create(Producto producto) throws Exception;
	
	public Pagina<Producto> getPagina(int numeroPagina, int numeroElementos) throws Exception;
	
	public Pagina<Producto> getByCategoriaPrecioMenor(Categoria cat, double precio, int numeroPagina, int numeroElementos) throws Exception;
	
}
