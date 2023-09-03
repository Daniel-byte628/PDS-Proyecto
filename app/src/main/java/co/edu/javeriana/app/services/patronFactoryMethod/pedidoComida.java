package co.edu.javeriana.app.services.patronFactoryMethod;

import co.edu.javeriana.app.persistence.entities.RestauranteEntity;
import co.edu.javeriana.app.persistence.entities.UsuarioEntity;

public class pedidoComida implements IPedido {

    private RestauranteEntity restaurante; // Agrega un campo para el restaurante
    private UsuarioEntity usuario;

       // Constructor que acepta el restaurante como parámetro
    public pedidoComida(RestauranteEntity restaurante,UsuarioEntity usuario) {
        this.restaurante = restaurante;
        this.usuario = usuario;
    }

    @Override
    public void procesarPedido() {
       // Lógica específica para procesar pedidos de comida
    }

    @Override
    public RestauranteEntity getRestaurante() {
        return restaurante;
    }

    @Override
    public UsuarioEntity getUsuario() {
        return usuario;
    }
}
