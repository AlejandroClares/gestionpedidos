package com.pgrsoft.gestionpedidos.backend.presentation.model;

import java.io.Serializable;

public class CamareroVO implements Serializable {
	private static final long serialVersionUID = -89385743L;
	
	private Long codigo;
	private String nombre;
	
	public CamareroVO() {
		
	}
	
	public CamareroVO(Long codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "CamareroVO [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
}
