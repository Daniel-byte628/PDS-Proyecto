package co.edu.javeriana.app.services.patronFactoryMethod;

import org.springframework.stereotype.Component;

import co.edu.javeriana.app.persistence.entities.RestauranteEntity;
import co.edu.javeriana.app.persistence.entities.UsuarioEntity;

@Component
public interface IPedidoFactory {
    IPedido crearPedido(RestauranteEntity restaurante,UsuarioEntity usuario);
}
