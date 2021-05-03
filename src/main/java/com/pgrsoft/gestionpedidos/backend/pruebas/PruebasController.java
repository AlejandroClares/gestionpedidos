package com.pgrsoft.gestionpedidos.backend.pruebas;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pgrsoft.gestionpedidos.backend.integration.model.CategoriaDTO;
import com.pgrsoft.gestionpedidos.backend.integration.model.ProductoDTO;
import com.pgrsoft.gestionpedidos.backend.integration.repositories.ProductoPageableRepository;
import com.pgrsoft.gestionpedidos.backend.integration.repositories.ProductoRepository;

@RestController
@CrossOrigin
public class PruebasController {

	@Autowired
	private ProductoPageableRepository productoPageableRepository;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	
	// ***************************************************************

	@GetMapping("/prueba1")
	public List<ProductoDTO> prueba1(){
		return productoRepository.findByCategoria(CategoriaDTO.POSTRE);
	}
	
	// ***************************************************************
	
	@GetMapping("/prueba2")
	public List<ProductoDTO> prueba2(){
		
		List<ProductoDTO> productos = productoRepository.findAll();
		List<ProductoDTO> productos2 = productoRepository.findByPrecioGreaterThanAndPrecioLessThan(10, 15);
	
		productos.stream().forEach(System.out::println);
		
		return productos2;
	}
	
	// ***************************************************************
	
	// Esta prueba nos permite la obtención de páginas
	
	// Para obtener cinco elementos de la primera página (es 0 based!):
	
	// http://localhost:8086/prueba4/pagina?p1=0&p2=5
	
	@RequestMapping(value= "/prueba4/pagina",
					produces=MediaType.APPLICATION_JSON_VALUE)
	public Page<ProductoDTO> getPage(@RequestParam ("p1") Integer p1,
									 @RequestParam ("p2") Integer p2){
		
		Pageable pageable = PageRequest.of(p1, p2);
		
		Page<ProductoDTO> pagina = productoPageableRepository.findAll(pageable);
		return pagina;
	}
	
	// ***************************************************************
	
	@RequestMapping(value="/prueba3/image-resource",
					method=RequestMethod.GET,
					produces=MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getImageAsResource() throws IOException{
		
		// Esta prueba es para descargar via HTTP imagenes de nuestro sistema de archivos
		// Las imágenes deben estar en c:/imagenes/
		
		FileSystemResource imgFile = new FileSystemResource("c:\\imagenes\\chic1.jpg");
		
		byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
		
		return ResponseEntity.ok().body(bytes);
	}
	
	// ***************************************************************
	
}
