package com.pgrsoft.gestionpedidos.backend.appcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pgrsoft.gestionpedidos.backend.presentation.model.PedidoVO;
import com.pgrsoft.gestionpedidos.backend.presentation.services.PedidoPresentationServices;

@Controller
@CrossOrigin
@RequestMapping("/app")
public class AppPedidoController {

	@Autowired
	public PedidoPresentationServices pedidoPresentationServices; 
	
	@GetMapping("/pedidos")
	public String generarVistaListado(Model model) throws Exception {
	
		List<PedidoVO> pedidos = pedidoPresentationServices.getAll();
		
		model.addAttribute("pedidos", pedidos);
		
		return "listado-pedidos";
	}
	
	@GetMapping("/ultimo-pedido")
	public String ultimoPedido() {
		return "ultimo-pedido";
	}
	
	
	
}
