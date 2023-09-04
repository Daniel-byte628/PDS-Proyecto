package co.edu.javeriana.app.services.patronSingleton;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class AppConfig {

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        // Obtener el idioma actual desde LanguageManager
        // Configurar el basename dinámicamente según el idioma actual
        messageSource.setBasename("messages_" + "en");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LanguageManager myLanguageManager() {
        return LanguageManager.getInstance();
    }
}
