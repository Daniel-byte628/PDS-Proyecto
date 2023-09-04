package co.edu.javeriana.app.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.javeriana.app.services.patronSingleton.LanguageManager;
@Controller
public class EjemploController {

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @Autowired
    private LanguageManager languageManager;

    @GetMapping("/cambiarIdioma")
    public String cambiarIdioma(@RequestParam String idioma) {
        Locale nuevoLocale = Locale.forLanguageTag(idioma);
        messageSource.setBasename("messages_" + idioma);
        languageManager.setCurrentLocale(nuevoLocale);
        return "redirect:/hola"; // Redirige a la página de inicio para aplicar el nuevo idioma
    }

    @GetMapping("/hola")
    public String home(Model model) {
        String greeting = messageSource.getMessage("greeting", null,languageManager.getCurrentLocale() );
        System.out.println(languageManager.getCurrentLocale());
        model.addAttribute("greeting", greeting);
        return "prueba";
    }
}
