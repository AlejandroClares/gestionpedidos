package com.pgrsoft.gestionpedidos.backend.presentation.services;

import java.util.List;

import com.pgrsoft.gestionpedidos.backend.presentation.model.LineaPedidoVO;
import com.pgrsoft.gestionpedidos.backend.presentation.model.PedidoVO;

public interface PedidoPresentationServices {

	public PedidoVO getById(Long id) throws Exception;
	
	public List<PedidoVO> getAll() throws Exception;
	
	public PedidoVO create(PedidoVO pedidoVO) throws Exception;
	
	public List<LineaPedidoVO> getAllLineas() throws Exception;
	
	public PedidoVO getUltimo() throws Exception;
	
	public List<LineaPedidoVO> getLineasPedidoByCodigoProducto(long codigoProducto) throws Exception;
	
}
