package co.edu.javeriana.app.services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import co.edu.javeriana.app.persistence.entities.UsuarioEntity;

public interface IUsuarioService {
    public UsuarioEntity createUser(UsuarioEntity user);
    public List<UsuarioEntity> getAllUsers();
    public Optional<UsuarioEntity> getUserById(Long userId);
    public UsuarioEntity updateUser(Long userId, UsuarioEntity newUser);
    public HashMap<String, String> deleteUser(Long userId);
}