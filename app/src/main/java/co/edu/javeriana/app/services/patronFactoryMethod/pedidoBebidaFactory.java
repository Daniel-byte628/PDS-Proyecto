package co.edu.javeriana.app.services.patronFactoryMethod;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.edu.javeriana.app.persistence.entities.RestauranteEntity;
import co.edu.javeriana.app.persistence.entities.UsuarioEntity;

@Component
@Qualifier("fabricaPedidoBebida")
public class pedidoBebidaFactory implements IPedidoFactory {
  
    @Override
    public IPedido crearPedido(RestauranteEntity restaurante, UsuarioEntity usuario) {
        IPedido pedido = new pedidoComida(restaurante,usuario);
        return pedido;
        
    }
}