package co.edu.javeriana.app.services.businesslogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.javeriana.app.persistence.entities.PedidoEntity;
import co.edu.javeriana.app.persistence.repositories.PedidoRepository;
import co.edu.javeriana.app.services.patronFactoryMethod.IPedido;

@Service
public class PedidoService {
    
    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

     public void procesarPedido(IPedido pedido) {
        
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setTipo(pedido.getClass().getSimpleName()); 
        pedidoEntity.setRestaurante(pedido.getRestaurante()); 
        pedidoEntity.setUsuario(pedido.getUsuario()); 
        pedidoRepository.save(pedidoEntity);
    }
}
