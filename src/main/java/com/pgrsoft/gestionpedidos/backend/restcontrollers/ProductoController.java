package com.pgrsoft.gestionpedidos.backend.restcontrollers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pgrsoft.gestionpedidos.backend.common.Pagina;
import com.pgrsoft.gestionpedidos.backend.presentation.model.ProductoVO;
import com.pgrsoft.gestionpedidos.backend.presentation.services.ProductoPresentationServices;
import com.pgrsoft.gestionpedidos.pdfviews.ProductoPdfView;

@RestController
@CrossOrigin
@RequestMapping(value="/productos")
public class ProductoController {
	
	private Logger logger = LoggerFactory.getLogger(ProductoController.class);

	@Autowired
	private ProductoPresentationServices productoPresentationServices;
	
	@Autowired
	private ProductoPdfView productoPdfView;
	
	
	@RequestMapping(value="",
					method=RequestMethod.GET,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public List<ProductoVO> getProductos(){
		
		List<ProductoVO> productos = null;
		
		try {
			productos = productoPresentationServices.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return productos;
	}
	
	
	@GetMapping(value="/p")
	public Pagina<ProductoVO> getPaginated(@RequestParam("page") Integer numeroPagina,
										   @RequestParam("size") Integer numeroElementos){
		
		Pagina<ProductoVO> pagina = null;
		
		try {
			pagina = productoPresentationServices.getPagina(numeroPagina, numeroElementos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pagina;
	}
	
	@GetMapping(value="/{codigo}")
	public ProductoVO getById(@PathVariable ("codigo") Long codigo) {
		
		
		ProductoVO producto = null;
		
		try {
			producto = productoPresentationServices.getById(codigo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			//e.printStackTrace();
		}
		
		return producto;
	}
	
	// 	*****************************************************************************
	//	GET PDF
	// 	*****************************************************************************
		
	
	@RequestMapping(value="/pdf",
					method=RequestMethod.GET,
					produces=MediaType.APPLICATION_PDF_VALUE)
	public ModelAndView getPDF() {
		
		List<ProductoVO> productos = null;
		
		try {
			productos = this.productoPresentationServices.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("productos", productos);
		
		mav.setView(productoPdfView);
		
		return mav;
	}
	
	// 	*****************************************************************************
	//	CREATE
	// 	*****************************************************************************	

	@RequestMapping(value="",
					method=RequestMethod.POST,
					consumes=MediaType.APPLICATION_JSON_VALUE,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public ProductoVO create(@RequestBody ProductoVO producto) {
		
		ProductoVO createdProducto = null;
		
		try {
			createdProducto = this.productoPresentationServices.create(producto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return createdProducto;
	}
}
