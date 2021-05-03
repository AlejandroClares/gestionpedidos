package com.pgrsoft.gestionpedidos.backend.business.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.pgrsoft.gestionpedidos.backend.business.model.Categoria;
import com.pgrsoft.gestionpedidos.backend.business.model.Producto;
import com.pgrsoft.gestionpedidos.backend.business.services.impl.ProductoServicesImpl;
import com.pgrsoft.gestionpedidos.backend.common.Pagina;
import com.pgrsoft.gestionpedidos.backend.integration.model.CategoriaDTO;
import com.pgrsoft.gestionpedidos.backend.integration.model.ProductoDTO;
import com.pgrsoft.gestionpedidos.backend.integration.repositories.ProductoPageableRepository;
import com.pgrsoft.gestionpedidos.backend.integration.repositories.ProductoRepository;

//@RunWith(SpringRunner.class)
//@ContextConfiguration
public class ProductoServicesTest {
/*
	@TestConfiguration
	static class ProductoSericeTestContextConfiguration{
		
		@Bean
		public ProductoServices productoService() {
			return new ProductoServicesImpl();		// Implementación que vamos a testear
		}	
		
		@Bean
		public DozerBeanMapper getMapper() {
			List<String> mappingFiles = Arrays.asList("dozer-configration-mapping.xml");
	        DozerBeanMapper dozerBean = new DozerBeanMapper();
	        dozerBean.setMappingFiles(mappingFiles);
	        return dozerBean;
		}
	}
	
	@Autowired
	private ProductoServices productoServices;
	
	@MockBean
	private ProductoRepository productoRepository;
	
	@MockBean
	private ProductoPageableRepository productoPageableRepository;
	
	@Before
	public void setUp() {
		
		// Configuramos varios productos de pruebas...
		
		ProductoDTO p1 = new ProductoDTO(1L,"PR. TEST",1.5,"DESC.",new Date(),false, CategoriaDTO.COMIDA);
		ProductoDTO p2 = new ProductoDTO(2L,"PR. TEST",1.5,"DESC.",new Date(),false, CategoriaDTO.COMIDA);
		ProductoDTO p3 = new ProductoDTO(3L,"PR. TEST",1.5,"DESC.",new Date(),false, CategoriaDTO.COMIDA);
		ProductoDTO p4 = new ProductoDTO(4L,"PR. TEST",1.5,"DESC.",new Date(),false, CategoriaDTO.COMIDA);
	
		// Programamos nuestro objeto mock
		
		Mockito.when(productoRepository.getOne(1L))
		       .thenReturn(p1);
		
		Mockito.when(productoRepository.findAll())
				.thenReturn(Arrays.asList(p1, p2, p3));
		
        Mockito.when(productoRepository.save(p1)).thenReturn(p1);
        Mockito.when(productoRepository.save(p2)).thenReturn(p2);
        Mockito.when(productoRepository.save(p3)).thenReturn(p3);
        Mockito.when(productoRepository.save(p4)).thenReturn(p4);
        
        Page<ProductoDTO> page1 = new PageImpl<ProductoDTO>(Arrays.asList(p1,p2,p3));
        Page<ProductoDTO> page2 = new PageImpl<ProductoDTO>(Arrays.asList(p1,p2));
        
        Mockito.when(productoPageableRepository.findAll(PageRequest.of(0, 3)))
        		.thenReturn(page1);
        
        Mockito.when(productoPageableRepository.findAll(PageRequest.of(0, 2)))
				.thenReturn(page2);
        
        Mockito.when(productoPageableRepository.findByCategoriaOrPrecioLessThan(CategoriaDTO.AGUA, 1000.0, PageRequest.of(0, 2)))
        		.thenReturn(page2);
        
	}
	
	@Test
	public void whenValidCodigo_thenProductoShouldBeFound() throws Exception {
		String nombre = "PR. TEST";
		Producto encontrado = productoServices.getById(1L);
		assertThat(encontrado.getNombre()).isEqualTo(nombre);
		assertThat(encontrado.getDescripcion()).isEqualTo("DESC.");
	}
	
	@Test
	public void whenGetAll() throws Exception {
		List<Producto> productos = productoServices.getAll();
		assertThat(productos.size()).isEqualTo(3);
	}
	
	@Test
	public void whenCreate() throws Exception {
		
		Producto productoNuevo = new Producto(1L,"PR. TEST",1.5,"DESC.",new Date(),false, Categoria.COMIDA);
	
		Producto productoCreado = productoServices.create(productoNuevo);
		
		assertThat(productoCreado.getCodigo()).isEqualTo(productoNuevo.getCodigo());
		
	}
	
	@Test
	public void whenGetPagina() throws Exception {
		
		Pagina<Producto> pagina = productoServices.getPagina(0, 3);
		
		assertThat(pagina.getElementos().size()).isEqualTo(3);
		
		pagina = productoServices.getPagina(0, 2);
		
		assertThat(pagina.getElementos().size()).isEqualTo(2);
		
	}
	
	@Test
	public void whenGetByCategoriaPrecioMenor() throws Exception {
		
		Categoria categoria = Categoria.AGUA;
		
		Pagina<Producto> pagina = this.productoServices.getByCategoriaPrecioMenor(categoria, 4.0, 0, 2)	;
			
		assertThat(pagina).isNotNull();
		
	
	}
*/	
}
