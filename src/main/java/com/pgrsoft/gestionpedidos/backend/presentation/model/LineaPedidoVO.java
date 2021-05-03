package com.pgrsoft.gestionpedidos.backend.presentation.model;

import java.io.Serializable;

public class LineaPedidoVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private ProductoVO producto;
	private int cantidad;
	private double precio;
	
	public LineaPedidoVO() {
		
	}

	public ProductoVO getProducto() {
		return producto;
	}

	public void setProducto(ProductoVO producto) {
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
		return "LineaPedidoVO [producto=" + producto + ", cantidad=" + cantidad + ", precio=" + precio + "]";
	}

}
