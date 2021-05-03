package com.pgrsoft.gestionpedidos.backend.business.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.business.model.Categoria;
import com.pgrsoft.gestionpedidos.backend.business.model.Producto;
import com.pgrsoft.gestionpedidos.backend.business.services.ProductoServices;
import com.pgrsoft.gestionpedidos.backend.common.Pagina;
import com.pgrsoft.gestionpedidos.backend.integration.model.CategoriaDTO;
import com.pgrsoft.gestionpedidos.backend.integration.model.ProductoDTO;
import com.pgrsoft.gestionpedidos.backend.integration.repositories.ProductoPageableRepository;
import com.pgrsoft.gestionpedidos.backend.integration.repositories.ProductoRepository;

@Service
@Transactional
public class ProductoServicesImpl implements ProductoServices {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private ProductoPageableRepository productopageableRepository;
	
	@Autowired
	private DozerBeanMapper dozerBeanMapper;
	
	@Override
	public List<Producto> getAll() {
		
		final List<ProductoDTO> productosDTO = productoRepository.findAll();
		
		final List<Producto> productos = productosDTO.stream()
				.map(x -> dozerBeanMapper.map(x, Producto.class))
				.collect(Collectors.toList());
		
		return productos;
	}

	@Override
	public Producto getById(Long id) {
		final ProductoDTO productoDTO = productoRepository.getOne(id);
		final Producto producto = dozerBeanMapper.map(productoDTO, Producto.class);
		return producto;
	}

	@Override
	public Producto create(Producto producto) {
		final ProductoDTO productoDTO = dozerBeanMapper.map(producto, ProductoDTO.class);
		final ProductoDTO createdProductoDTO = productoRepository.save(productoDTO);
		return dozerBeanMapper.map(createdProductoDTO, Producto.class);
	}

	@Override
	public Pagina<Producto> getPagina(int numeroPagina, 
									  int numeroElementos) {
		final Page<ProductoDTO> page = productopageableRepository.findAll(PageRequest.of(numeroPagina, numeroElementos));
		return this.getPagina(page);
	}

	@Override
	public Pagina<Producto> getByCategoriaPrecioMenor(Categoria cat, double precio, int numeroPagina,int numeroElementos) throws Exception {
		
		CategoriaDTO categoriaDTO = dozerBeanMapper.map(cat,CategoriaDTO.class);
		
		Page<ProductoDTO> page = productopageableRepository.findByCategoriaOrPrecioLessThan(
				categoriaDTO, 
				precio,
				PageRequest.of(numeroPagina, numeroElementos));
		
		return this.getPagina(page);
	}
	
	
	/*
	 * 
	 * Método privado
	 * 
	 * convierte una Page<ProductoDTO> a Pagina<Producto>
	 * 
	 */
	
	private Pagina<Producto> getPagina (Page<ProductoDTO> page){
		
		Pagina<Producto> pagina = new Pagina<Producto>();
		
		List<Producto> elementos = page.getContent().stream()
				.map(x -> dozerBeanMapper.map(x, Producto.class))
				.collect(Collectors.toList());
		
		pagina.setElementos(elementos);
		
		pagina.setNumeroTotalElementos(page.getTotalElements());
		pagina.setNumeroPagina(page.getNumber());
		pagina.setNumeroTotalPaginas(page.getTotalPages());
		pagina.setNumeroElementos(page.getSize());
		
		pagina.setPrimeraPagina(page.isFirst());
		pagina.setUltimaPagina(page.isLast());
		
		return pagina;
	}

}
