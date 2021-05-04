package pe.edu.utp.electroplus.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.edu.utp.electroplus.model.Producto;
import pe.edu.utp.electroplus.repository.ProductoRepository;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class CarritoController {

    @GetMapping("/carrito")
    public String carrito(Principal principal) {
        return "carrito";
    }

}
