package com.pgrsoft.gestionpedidos.backend.presentation.model;

import java.io.Serializable;
import java.util.List;

public class ClienteVO implements Serializable{
	private static final long serialVersionUID = 15454L;
	
	private Long codigo;
	private String nombre;
	
	private List<ContactoVO> contactos;
	
	public ClienteVO() {
		
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
	
	public List<ContactoVO> getContactos() {
		return contactos;
	}

	public void setContactos(List<ContactoVO> contactos) {
		this.contactos = contactos;
	}

	@Override
	public String toString() {
		return "ClienteVO [codigo=" + codigo + ", nombre=" + nombre + ", contactos=" + contactos + "]";
	}

}
