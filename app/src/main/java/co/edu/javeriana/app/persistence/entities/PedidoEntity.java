package co.edu.javeriana.app.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name = "pedidos")
@Entity
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo; // Comida, bebida, servicio, etc.
    
    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private RestauranteEntity restaurante;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

    public void setId(Long id) {
        this.id = id;
    }
    public void setRestaurante(RestauranteEntity restaurante) {
        this.restaurante = restaurante;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
    public Long getId() {
        return id;
    }
    public RestauranteEntity getRestaurante() {
        return restaurante;
    }
    public String getTipo() {
        return tipo;
    }
    public UsuarioEntity getUsuario() {
        return usuario;
    }
    

}

