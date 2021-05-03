package com.pgrsoft.gestionpedidos.backend.business.model;

import java.io.Serializable;

public class Contacto implements Serializable {
	private static final long serialVersionUID = 10809483L;
	
	private String nombre;
	private String telefono;
	
	public Contacto() {
		
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
		return "Contacto [nombre=" + nombre + ", telefono=" + telefono + "]";
	}
	
}
