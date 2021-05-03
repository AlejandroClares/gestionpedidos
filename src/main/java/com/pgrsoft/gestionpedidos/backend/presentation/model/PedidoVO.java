package com.pgrsoft.gestionpedidos.backend.presentation.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PedidoVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Date fecha;
	private int mesa;
	private CamareroVO camarero;

	private List<LineaPedidoVO> lineasPedido;
	
	public PedidoVO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getMesa() {
		return mesa;
	}

	public void setMesa(int mesa) {
		this.mesa = mesa;
	}

	public CamareroVO getCamarero() {
		return camarero;
	}

	public void setCamarero(CamareroVO camarero) {
		this.camarero = camarero;
	}

	public List<LineaPedidoVO> getLineasPedido() {
		return lineasPedido;
	}

	public void setLineasPedido(List<LineaPedidoVO> lineasPedido) {
		this.lineasPedido = lineasPedido;
	}

	@Override
	public String toString() {
		return "PedidoVO [id=" + id + ", fecha=" + fecha + ", mesa=" + mesa + ", camarero=" + camarero + ", lineasPedido="
				+ lineasPedido + "]";
	}
	
}
