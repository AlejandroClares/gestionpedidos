package com.pgrsoft.gestionpedidos.backend.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgrsoft.gestionpedidos.backend.presentation.model.LineaPedidoVO;
import com.pgrsoft.gestionpedidos.backend.presentation.services.PedidoPresentationServices;

@RestController
@CrossOrigin
public class LineaPedidoController {

	@Autowired
	private PedidoPresentationServices pedidoPresentationServices;
	
	@RequestMapping("/lineas")
	public List<LineaPedidoVO> getAll() {
		
		List<LineaPedidoVO> lineasPedidoVO = null;
		
		try {
			lineasPedidoVO = pedidoPresentationServices.getAllLineas();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lineasPedidoVO;
	}
	
	@RequestMapping("/lineas/{idProducto}")
	public List<LineaPedidoVO> getFilteredByProductId (@PathVariable("idProducto") Long idProducto) {
		
		List<LineaPedidoVO> lineasPedidoVO = null;
		
		try {
			lineasPedidoVO = pedidoPresentationServices.getLineasPedidoByCodigoProducto(idProducto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lineasPedidoVO;
	}
	

}
