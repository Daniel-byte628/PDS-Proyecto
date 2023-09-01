package co.edu.javeriana.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.javeriana.app.persistence.entities.UsuarioEntity;
import co.edu.javeriana.app.services.IUsuarioService;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    IUsuarioService usuarioService;


    @PostMapping("/create")
    public ResponseEntity<UsuarioEntity> createUser(@RequestBody UsuarioEntity user) {
        try {
            System.out.println(user);
            UsuarioEntity createdUser = usuarioService.createUser(user);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<UsuarioEntity>> getAllUsers() {
        try {
            List<UsuarioEntity> users = usuarioService.getAllUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("get/{userId}")
    public ResponseEntity<UsuarioEntity> getUserById(@PathVariable Long userId) {
        try {
            Optional<UsuarioEntity> user = usuarioService.getUserById(userId);
            return user.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<UsuarioEntity> updateUser(@PathVariable Long userId, @RequestBody UsuarioEntity newUser) {
        try {
            UsuarioEntity updatedUser = usuarioService.updateUser(userId, newUser);
            if (updatedUser != null) {
                return new ResponseEntity<>(updatedUser, HttpStatus.OK);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<HashMap<String, String>> deleteUser(@PathVariable Long userId) {
        try {
            HashMap<String, String> response = usuarioService.deleteUser(userId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}