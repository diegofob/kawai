package pe.edu.utp.electroplus.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

    @GetMapping("/micuenta")
    public String micuenta(Principal principal) {
        return "usuario/usuario";
    }
}
