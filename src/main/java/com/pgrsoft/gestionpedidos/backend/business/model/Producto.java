package com.pgrsoft.gestionpedidos.backend.business.model;

import java.io.Serializable;
import java.util.Date;

public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private String nombre;
	private double precio;
	private String descripcion;
	private Date fechaAlta;
	private boolean descatalogado;
	
	private Categoria categoria;
	
	public Producto() {
		
	}
	
	public Producto(Long codigo, String nombre, double precio, String descripcion, Date fechaAlta,
			boolean descatalogado, Categoria categoria) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.fechaAlta = fechaAlta;
		this.descatalogado = descatalogado;
		this.categoria = categoria;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public boolean isDescatalogado() {
		return descatalogado;
	}

	public void setDescatalogado(boolean descatalogado) {
		this.descatalogado = descatalogado;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", descripcion="
				+ descripcion + ", fechaAlta=" + fechaAlta + ", descatalogado=" + descatalogado + ", categoria="
				+ categoria + "]";
	}
	
}
