package com.pgrsoft.gestionpedidos.backend.presentation.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.business.model.Producto;
import com.pgrsoft.gestionpedidos.backend.business.services.ProductoServices;
import com.pgrsoft.gestionpedidos.backend.common.Pagina;
import com.pgrsoft.gestionpedidos.backend.presentation.model.ProductoVO;
import com.pgrsoft.gestionpedidos.backend.presentation.services.ProductoPresentationServices;

@Service
public class ProductoPresentationServicesImpl implements ProductoPresentationServices {

	@Autowired
	private ProductoServices productoServices;
	
	@Autowired
	private DozerBeanMapper dozerBeanMapper;
	
	@Override
	public List<ProductoVO> getAll() throws Exception {
		
		List<ProductoVO> productosVO =  null;
		
		try {
			final List<Producto> productos = productoServices.getAll(); 
			
			productosVO = productos.stream()
					.map(x -> this.dozerBeanMapper.map(x, ProductoVO.class))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
		
		return productosVO;
	}

	@Override
	public ProductoVO getById(Long id) throws Exception{
		
		ProductoVO productoVO = null;
		
		try {
			final Producto producto = productoServices.getById(id);
			productoVO = dozerBeanMapper.map(producto, ProductoVO.class);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return productoVO;
	}

	@Override
	public ProductoVO create(ProductoVO newProductoVO) throws Exception {
		
		ProductoVO createdProductoVO = null;
		
		try {
			final Producto newProducto = dozerBeanMapper.map(newProductoVO, Producto.class);
			final Producto createdProducto = productoServices.create(newProducto);
			createdProductoVO = dozerBeanMapper.map(createdProducto, ProductoVO.class);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return createdProductoVO;
	}

	@Override
	public Pagina<ProductoVO> getPagina(int numeroPagina, int numeroElementos) throws Exception{
		
		Pagina<Producto> pagina = this.productoServices.getPagina(numeroPagina, numeroElementos);
		
		Pagina<ProductoVO> paginaVO = new Pagina<>();
		
		List<ProductoVO> productosVO = pagina.getElementos()
				.stream()
				.map(x -> dozerBeanMapper.map(x,ProductoVO.class))
				.collect(Collectors.toList());
				
		paginaVO.setElementos(productosVO);
		
		paginaVO.setNumeroTotalElementos(pagina.getNumeroTotalElementos());
		paginaVO.setNumeroPagina(pagina.getNumeroPagina());
		paginaVO.setNumeroElementos(pagina.getNumeroElementos());
		paginaVO.setNumeroTotalPaginas(pagina.getNumeroTotalPaginas());
		
		paginaVO.setPrimeraPagina(pagina.isPrimeraPagina());
		paginaVO.setUltimaPagina(pagina.isUltimaPagina());
	
		return paginaVO;

	}

}
