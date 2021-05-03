package com.pgrsoft.gestionpedidos.backend.business.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.business.model.LineaPedido;
import com.pgrsoft.gestionpedidos.backend.business.model.Pedido;
import com.pgrsoft.gestionpedidos.backend.business.services.PedidoServices;
import com.pgrsoft.gestionpedidos.backend.integration.model.CamareroDTO;
import com.pgrsoft.gestionpedidos.backend.integration.model.LineaPedidoDTO;
import com.pgrsoft.gestionpedidos.backend.integration.model.PedidoDTO;
import com.pgrsoft.gestionpedidos.backend.integration.repositories.CamareroRepository;
import com.pgrsoft.gestionpedidos.backend.integration.repositories.PedidoRepository;
import com.pgrsoft.gestionpedidos.backend.integration.repositories.ProductoRepository;

@Service
@Transactional
public class PedidoServicesImpl implements PedidoServices {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CamareroRepository camareroRepository;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private DozerBeanMapper dozerBeanMapper;
	
	@Override
	public Pedido getById(Long id) {
		
		Optional<PedidoDTO> optional = pedidoRepository.findById(id);
		
		PedidoDTO pedidoDTO = null;
		
		if (optional.isPresent()) {
			pedidoDTO = optional.get();
		}
		
		final Pedido pedido = dozerBeanMapper.map(pedidoDTO, Pedido.class);
		
		return pedido;
	}

	@Override
	public List<Pedido> getAll() {
		
		final List<PedidoDTO> pedidosDTO = pedidoRepository.findAll();
		
		List<Pedido> pedidos = pedidosDTO.stream()
				.map(x -> dozerBeanMapper.map(x, Pedido.class))
				.collect(Collectors.toList());

		return pedidos;
	}

	
	@Override
	public Pedido create(Pedido pedido) throws Exception {
		
		final PedidoDTO pedidoDTO = dozerBeanMapper.map(pedido, PedidoDTO.class);
		final CamareroDTO camareroDTO = camareroRepository.getOne(pedidoDTO.getCamarero().getId());
		pedidoDTO.setCamarero(camareroDTO);
		
		pedidoDTO.getLineasPedido().stream()
		.forEach(x -> {
			x.setProducto(productoRepository.getOne(x.getProducto().getCodigo()));
		});
		
		PedidoDTO createdPedidoDTO = pedidoRepository.save(pedidoDTO);
		
		return dozerBeanMapper.map(createdPedidoDTO, Pedido.class);
		
	}

	@Override
	public List<LineaPedido> getLineasPedido() {
		
		final List<LineaPedidoDTO> lineasPedidoDTO = pedidoRepository.getLineasPedido();

		return lineasPedidoDTO.stream()
				.map(x -> dozerBeanMapper.map(x, LineaPedido.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<LineaPedido> getLineasPedidoByCodigoProducto(long codigoProducto) {
		
		final List<LineaPedidoDTO> lineasPedidoDTO = pedidoRepository.getLineasPedidoByProductoId(codigoProducto);
		
		return lineasPedidoDTO.stream()
				.map(x -> dozerBeanMapper.map(x, LineaPedido.class))
				.collect(Collectors.toList());
	}

	@Override
	public Pedido getUltimo() throws Exception {
		
		Long ultimoCodigo = pedidoRepository.getUltimoCodigo();
		Optional<PedidoDTO> optional = pedidoRepository.findById(ultimoCodigo);
		return optional.isPresent() ? dozerBeanMapper.map(optional.get(), Pedido.class) : null;		
	}
	
}
