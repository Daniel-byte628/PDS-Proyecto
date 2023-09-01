package co.edu.javeriana.app.services.businesslogic;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.javeriana.app.persistence.entities.UsuarioEntity;
import co.edu.javeriana.app.persistence.repositories.UsuarioRepository;
import co.edu.javeriana.app.services.IUsuarioService;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    @Autowired
    UsuarioRepository userRepository;

    @Override
    public UsuarioEntity createUser(UsuarioEntity user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            LOGGER.error("Error while creating user: {}", e.getMessage());
            throw new RuntimeException("Error creating user");
        }
    }

    @Override
    public List<UsuarioEntity> getAllUsers() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            LOGGER.error("Error while fetching all users: {}", e.getMessage());
            throw new RuntimeException("Error fetching users");
        }
    }

    @Override
    public Optional<UsuarioEntity> getUserById(Long userId) {
        try {
            return userRepository.findById(userId);
        } catch (Exception e) {
            LOGGER.error("Error while fetching user by ID: {}", e.getMessage());
            throw new RuntimeException("Error fetching user by ID");
        }
    }

    @Override
    public UsuarioEntity updateUser(Long userId, UsuarioEntity newUser) {
        try {
            UsuarioEntity existingUser = userRepository.findById(userId).orElse(null);
            if (existingUser != null) {
                existingUser.setNombre(newUser.getNombre());
                existingUser.setApellido(newUser.getApellido());
                existingUser.setCorreo(newUser.getCorreo());

                return userRepository.save(existingUser);
            }
            throw new RuntimeException("User not found");
        } catch (Exception e) {
            LOGGER.error("Error while updating user: {}", e.getMessage());
            throw new RuntimeException("Error updating user");
        }
    }

    @Override
    public HashMap<String, String> deleteUser(Long userId) {
        try {
            HashMap<String, String> response = new HashMap<>();
            response.put("message", "User deleted succesfully!");
            userRepository.deleteById(userId);
            return response;
        } catch (Exception e) {
            LOGGER.error("Error while deleting user: {}", e.getMessage());
            throw new RuntimeException("Error deleting user");
        }
    }
}