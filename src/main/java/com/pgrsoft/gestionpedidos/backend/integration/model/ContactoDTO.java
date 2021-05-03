package com.pgrsoft.gestionpedidos.backend.integration.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ContactoDTO implements Serializable {
	private static final long serialVersionUID = 10809483L;
	
	private String nombre;
	private String telefono;
	
	public ContactoDTO() {
		
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
		return "ContactoDTO [nombre=" + nombre + ", telefono=" + telefono + "]";
	}
	

}
