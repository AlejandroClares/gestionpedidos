package com.pgrsoft.gestionpedidos.backend.appcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
@RequestMapping("/app")
public class AppHomeController {

	@GetMapping("/home")
	public String generarVistaListado() throws Exception {
		return "home";
	}
	
}
