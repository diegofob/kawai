package pe.edu.utp.electroplus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class RouterController {

    @GetMapping("/")
    public String index(Principal principal) {
        return "catalogo";
    }

    @GetMapping("/inicio")
    public String catalogo(Principal principal) {
        return "catalogo";
    }

    @GetMapping("/carrito")
    public String carrito(Principal principal) {
        return "carrito";
    }

    @GetMapping("/micuenta")
    public String micuenta(Principal principal) {
        return "usuario";
    }

}
