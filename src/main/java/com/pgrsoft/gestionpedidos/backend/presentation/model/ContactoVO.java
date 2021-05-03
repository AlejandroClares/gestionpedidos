package com.pgrsoft.gestionpedidos.backend.presentation.model;

import java.io.Serializable;

public class ContactoVO implements Serializable{
	private static final long serialVersionUID = 1454L;
	
	private String nombre;
	private String telefono;
	
	public ContactoVO() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "ContactoVO [nombre=" + nombre + ", telefono=" + telefono + "]";
	}
	
}
