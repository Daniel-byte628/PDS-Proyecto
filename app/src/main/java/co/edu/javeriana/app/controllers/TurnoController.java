package co.edu.javeriana.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.app.persistence.entities.UsuarioEntity;
import co.edu.javeriana.app.services.EmailService;
import co.edu.javeriana.app.services.businesslogic.UsuarioServiceImpl;
import co.edu.javeriana.app.services.patronObservador.Turno;
import co.edu.javeriana.app.services.patronObservador.TurnoObservador;

@RestController
public class TurnoController {
    private Turno turnoSujeto = new Turno();
    private List<TurnoObservador> observadores = new ArrayList<>();

    @Autowired
    private EmailService emailService; // Inyecta el servicio de correo electrónico

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @PostMapping("/asignar-turno")
    public String asignarTurno() {
        // Lógica para asignar un nuevo turno
        String nuevoTurno = "Turno #" + obtenerNuevoTurno();

        // Asignar el nuevo turno y notificar a los observadores
        turnoSujeto.asignarTurno(nuevoTurno);

        // Enviar notificaciones por correo electrónico a los observadores
        for (TurnoObservador observador : observadores) {
            observador.actualizar(nuevoTurno);
        }

        return "Turno asignado: " + nuevoTurno;
    }

    private int obtenerNuevoTurno() {
        // Lógica para generar el próximo número de turno
        // Debes implementar esta lógica según tus requisitos
        return 1; // Ejemplo simplificado
    }

    @PostMapping("/suscribirse-turno/{userId}")
    public ResponseEntity<String> suscribirseATurno(@PathVariable Long userId) {
        // Buscar al usuario por su ID
        Optional<UsuarioEntity> usuario = usuarioService.getUserById(userId);

        if (usuario.isPresent()) {
            // Agregar al usuario como observador de turnos
            observadores.add(new TurnoObservador(usuario.get(), emailService));
            return new ResponseEntity<>("Usuario suscrito exitosamente a los turnos.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Usuario no encontrado.", HttpStatus.NOT_FOUND);
        }
    }
}
