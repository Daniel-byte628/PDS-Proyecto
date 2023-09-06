package co.edu.javeriana.app.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.javeriana.app.persistence.entities.ComidaEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.core.io.Resource;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class ComidaService {

    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;

    @Autowired
    public ComidaService(ObjectMapper objectMapper, ResourceLoader resourceLoader) {
        this.objectMapper = objectMapper;
        this.resourceLoader = resourceLoader;
    }

    public List<ComidaEntity> cargarComidasDesdeJson() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:data.json"); // Reemplaza 'nombre_de_tu_archivo.json' por el nombre real de tu archivo JSON en resources
        try (InputStream inputStream = resource.getInputStream()) {
            return objectMapper.readValue(inputStream, new TypeReference<List<ComidaEntity>>() {});
        }
    }
}




