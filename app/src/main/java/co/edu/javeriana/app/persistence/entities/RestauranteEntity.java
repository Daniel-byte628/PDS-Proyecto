package co.edu.javeriana.app.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class RestauranteEntity {
    @Id
    private long id;
    private String nombre;
}
