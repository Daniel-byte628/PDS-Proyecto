package co.edu.javeriana.app.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.javeriana.app.persistence.entities.ComidaEntity;
import co.edu.javeriana.app.services.ComidaService;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/comida")
public class ComidaController {
    private final ComidaService comidaService;

    @Autowired
    public ComidaController(ComidaService comidaService) {
        this.comidaService = comidaService;
    }

     

    @GetMapping("/mostrarcomida")
    public String mostrarPagina(Model model) {
        try {
            List<ComidaEntity> comidas = comidaService.cargarComidasDesdeJson();
            model.addAttribute("comidas", comidas);
        } catch (IOException e) {
            // Manejo de errores si ocurre un problema al cargar el JSON
            e.printStackTrace();
        }
        return "Cliente_paginaprincipal1";
    }
}
