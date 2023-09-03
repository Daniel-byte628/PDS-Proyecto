package co.edu.javeriana.app.services.patronFactoryMethod;

import co.edu.javeriana.app.persistence.entities.RestauranteEntity;
import co.edu.javeriana.app.persistence.entities.UsuarioEntity;

public interface IPedido {
    void procesarPedido();
    RestauranteEntity getRestaurante();
    UsuarioEntity getUsuario();
}
