package co.edu.javeriana.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.app.persistence.entities.RestauranteEntity;
import co.edu.javeriana.app.persistence.entities.UsuarioEntity;
import co.edu.javeriana.app.persistence.repositories.RestauranteRepository;
import co.edu.javeriana.app.persistence.repositories.UsuarioRepository;
import co.edu.javeriana.app.services.businesslogic.PedidoService;
import co.edu.javeriana.app.services.patronFactoryMethod.IPedido;
import co.edu.javeriana.app.services.patronFactoryMethod.IPedidoFactory;
import co.edu.javeriana.app.services.patronFactoryMethod.pedidoBebidaFactory;

@RestController
@RequestMapping("/pedidos")
public class pedidoController {
    @Autowired
    private final PedidoService pedidoService;
    private final IPedidoFactory fabricaPedidoComida;
    private final IPedidoFactory fabricaPedidoBebida;

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    private final RestauranteRepository restauranteRepository;


    public pedidoController(PedidoService pedidoService,@Qualifier("fabricaPedidoComida") IPedidoFactory fabricaPedidoComida,
            @Qualifier("fabricaPedidoBebida") IPedidoFactory fabricaPedidoBebida, UsuarioRepository usuarioRepository,
            RestauranteRepository restauranteRepository) {
        this.pedidoService = pedidoService;
        this.fabricaPedidoComida = fabricaPedidoComida;
        this.fabricaPedidoBebida = fabricaPedidoBebida;
        this.usuarioRepository = usuarioRepository;
        this.restauranteRepository = restauranteRepository;
    }


    @PostMapping("/comida")
    public ResponseEntity<String> hacerPedidoComida(@RequestParam Long restauranteId,@RequestParam Long usuarioId) {
        RestauranteEntity restaurante = restauranteRepository.findById(restauranteId).orElse(null);
        UsuarioEntity usuario = usuarioRepository.findById(usuarioId).orElse(null);

        if (restaurante == null || usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Restaurante o usuario no encontrado.");
        }

        IPedido pedido = fabricaPedidoComida.crearPedido(restaurante, usuario);
        pedidoService.procesarPedido(pedido);

        return ResponseEntity.ok("Pedido de comida realizado con éxito.");
    }

    @PostMapping("/bebida")
    public ResponseEntity<String> hacerPedidoBebida(
            @RequestParam Long restauranteId,
            @RequestParam Long usuarioId) {
        RestauranteEntity restaurante = restauranteRepository.findById(restauranteId).orElse(null);
        UsuarioEntity usuario = usuarioRepository.findById(usuarioId).orElse(null);

        if (restaurante == null || usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Restaurante o usuario no encontrado.");
        }

        IPedido pedido = fabricaPedidoBebida.crearPedido(restaurante, usuario);
        pedidoService.procesarPedido(pedido);

        return ResponseEntity.ok("Pedido de bebida realizado con éxito.");
    }

}
