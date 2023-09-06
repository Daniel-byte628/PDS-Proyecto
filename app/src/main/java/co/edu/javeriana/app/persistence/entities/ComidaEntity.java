package co.edu.javeriana.app.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "comida")
@Getter
@Setter
public class ComidaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String nombre;
    private String imagenComida;
    private String logo;
    
    // Si deseas relacionar la comida con un restaurante, puedes usar la anotación @ManyToOne
    // Aquí, asumimos que cada comida pertenece a un restaurante.
    @ManyToOne
    private RestauranteEntity restaurante;
}

