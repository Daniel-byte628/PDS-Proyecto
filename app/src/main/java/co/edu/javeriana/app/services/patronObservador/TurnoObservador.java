package co.edu.javeriana.app.services.patronObservador;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.javeriana.app.persistence.entities.UsuarioEntity;
import co.edu.javeriana.app.services.EmailService;

public class TurnoObservador implements ObservadorTurno {
    private UsuarioEntity usuario;
    @Autowired
    private EmailService emailService;

    public TurnoObservador(UsuarioEntity usuario, EmailService emailService) {
        this.usuario = usuario;
        this.emailService = emailService;
    }

    @Override
    public void actualizar(String turno) {
        // Lógica para enviar una notificación por correo electrónico al usuario
        String asunto = "Nuevo turno asignado";
        String cuerpo = "Su nuevo turno es: " + turno;

        // Llama al servicio de correo electrónico para enviar el correo a través de la instancia de EmailService
        emailService.enviarCorreo(usuario.getCorreo(), asunto, cuerpo);
    }
}
