package com.pgrsoft.gestionpedidos.backend.pruebas;

import java.io.File;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pgrsoft.gestionpedidos.backend.presentation.model.PedidoVO;
import com.pgrsoft.gestionpedidos.backend.presentation.services.PedidoPresentationServices;

@RestController
public class AudioController {
	
	@Autowired
	private PedidoPresentationServices pedidoPresentationServices;

	@RequestMapping("/sintetizador")
	public String sintetizarVoz() {
		
		return "sintetizador de voz";
	}
	
// 	*****************************************************************************
	//	CREATE
	// 	*****************************************************************************
	
	@RequestMapping(value="/orders",
					method=RequestMethod.POST,
					consumes=MediaType.APPLICATION_JSON_VALUE,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public PedidoVO create(@RequestBody PedidoVO pedidoVO){
		
		//System.out.println("llega el objeto! : " + pedidoVO);
		
		PedidoVO createdPedidoVO = null;
		
		try {
			createdPedidoVO = this.pedidoPresentationServices.create(pedidoVO);
			
			Clip clip = AudioSystem.getClip();
			File file = new ClassPathResource("space.wav").getFile();
			
			AudioInputStream ais = AudioSystem.getAudioInputStream(file);
			
			clip.open(ais);
			
			clip.start();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return createdPedidoVO;
	}

	@RequestMapping("/orders")
	public List<PedidoVO> play() {
		
		List<PedidoVO> pedidos = null;
		
		try {
			
			pedidos = this.pedidoPresentationServices.getAll();
			
			Clip clip = AudioSystem.getClip();
			File file = new ClassPathResource("space.wav").getFile();
			
			AudioInputStream ais = AudioSystem.getAudioInputStream(file);
			
			clip.open(ais);
			
			clip.start();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} 
	
		return pedidos;
	}
	
}
