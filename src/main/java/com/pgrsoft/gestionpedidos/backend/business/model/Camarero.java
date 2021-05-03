package com.pgrsoft.gestionpedidos.backend.business.model;

import java.io.Serializable;

public class Camarero implements Serializable {
	private static final long serialVersionUID = -89385743L;
	
	private Long id;
	private String nombre;
	
	public Camarero() {
		
	}
	
	public Camarero(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Camarero [id=" + id + ", nombre=" + nombre + "]";
	}

}
