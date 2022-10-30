package br.com.futurodev.primeiraapi.services;

import br.com.futurodev.primeiraapi.model.Pedido;
import br.com.futurodev.primeiraapi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CadastroPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Transactional
    public Pedido salvar (Pedido pedido){
        return  pedidoRepository.save(pedido);
    }

    @Transactional
    public void delete (Long idPedido){
        pedidoRepository.deleteById(idPedido);
    }

    public Pedido getPedidoById (Long idPedido){
        return pedidoRepository.findById(idPedido).get();
    }

    public List<Pedido> getPedidosByIdCliente (Long idCliente){
        List<Pedido> pedidos = pedidoRepository.getPedidosByIdCliente(idCliente);
        return pedidos;
    }

    public List<Pedido> getPedidos(){
        return (List<Pedido>) pedidoRepository.findAll();
    }
}
