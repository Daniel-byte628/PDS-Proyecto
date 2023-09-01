package co.edu.javeriana.app.persistence.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class UsuarioEntity {

    @Id
    private long id;
    private String nombre;
    private String apellido;
    private String correo;


}