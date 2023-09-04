package co.edu.javeriana.app.services.patronSingleton;

import java.util.Locale;

import org.springframework.stereotype.Component;

@Component
public class LanguageManager {

    private Locale currentLocale = Locale.getDefault();
    private static LanguageManager instance;

    private LanguageManager() {
        // Constructor privado para evitar la creación de instancias externas
    }

    public static synchronized LanguageManager getInstance() {
        if (instance == null) {
            instance = new LanguageManager();
        }
        return instance;
    }

    public Locale getCurrentLocale() {
        return currentLocale;
    }

    public void setCurrentLocale(Locale locale) {
        currentLocale = locale;
    }
}

