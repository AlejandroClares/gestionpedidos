package com.pgrsoft.gestionpedidos.backend.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pgrsoft.gestionpedidos.backend.presentation.model.PedidoVO;
import com.pgrsoft.gestionpedidos.backend.presentation.services.PedidoPresentationServices;
import com.pgrsoft.gestionpedidos.pdfviews.PedidoPdfView;

@RestController
@CrossOrigin
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoPresentationServices pedidoPresentationServices;
	
	@Autowired
	private PedidoPdfView pedidoPdfView;
	
	// 	*****************************************************************************
	//	GET BY ID
	// 	*****************************************************************************
	
	@RequestMapping(value="/{id}",
					method=RequestMethod.GET,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public PedidoVO getOne(@PathVariable ("id") Long id) {
		
		PedidoVO pedido = null;
		
		try {
			pedido = pedidoPresentationServices.getById(id);
		
		} catch (Exception e) {
			//logger.error(e.getMessage());
			//TODO
		}
		
		return pedido;
	}
	
	// 	*****************************************************************************
	//	GET ALL
	// 	*****************************************************************************
	
	@RequestMapping(value="",
					method=RequestMethod.GET,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public List<PedidoVO> getAll(){
		
		List<PedidoVO> pedidos = null;
		
		try {
			pedidos = pedidoPresentationServices.getAll();
		} catch (Exception e) {
			//logger.error(e.getMessage());
			//TODO responder JSON de error y código HTTP adecuado!
		}
		
		
		
		return pedidos;
	}
	
	@GetMapping("/ultimo")
	public PedidoVO getUltimo() throws Exception {
		return pedidoPresentationServices.getUltimo();
	}
	
	// 	*****************************************************************************
	//	CREATE
	// 	*****************************************************************************
	
	@RequestMapping(value="",
					method=RequestMethod.POST,
					consumes=MediaType.APPLICATION_JSON_VALUE,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public PedidoVO create(@RequestBody PedidoVO pedidoVO){
		
		//System.out.println("llega el objeto! : " + pedidoVO);
		
		PedidoVO createdPedidoVO = null;
		
		try {
			createdPedidoVO = this.pedidoPresentationServices.create(pedidoVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return createdPedidoVO;
	}
	
	// 	*****************************************************************************
	//	GET PDF
	// 	*****************************************************************************
	
	@RequestMapping(value="/{id}/pdf",
					method=RequestMethod.GET,
					produces=MediaType.APPLICATION_PDF_VALUE)
	public ModelAndView getPDF(@PathVariable ("id") Long id)  {

		PedidoVO pedidoVO = null;
		
		try {
			pedidoVO = this.pedidoPresentationServices.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pedido", pedidoVO);
		
		mav.setView(pedidoPdfView);
		return mav;
	}

}
