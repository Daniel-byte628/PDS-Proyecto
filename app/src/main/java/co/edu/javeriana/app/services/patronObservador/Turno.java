package co.edu.javeriana.app.services.patronObservador;

import java.util.ArrayList;
import java.util.List;

public class Turno {
    private List<ObservadorTurno> observadores = new ArrayList<>();
    private String turnoActual;

    public void agregarObservador(ObservadorTurno observador) {
        observadores.add(observador);
    }

    public void removerObservador(ObservadorTurno observador) {
        observadores.remove(observador);
    }

    public void asignarTurno(String nuevoTurno) {
        this.turnoActual = nuevoTurno;
        notificarObservadores();
    }

    private void notificarObservadores() {
        for (ObservadorTurno observador : observadores) {
            observador.actualizar(turnoActual);
        }
    }
}
