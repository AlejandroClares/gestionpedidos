package com.pgrsoft.gestionpedidos.backend.integration.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class LineaPedidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_PRODUCTO")
	private ProductoDTO producto;

	private int cantidad;
	
	private double precio;
	
	public LineaPedidoDTO() {
		
	}
	
	public LineaPedidoDTO(ProductoDTO producto, int cantidad, double precio) {
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public ProductoDTO getProducto() {
		return producto;
	}

	public void setProducto(ProductoDTO producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "LineaPedidoDTO [producto=" + producto + ", cantidad=" + cantidad + ", precio=" + precio + "]";
	}
	
	
}
