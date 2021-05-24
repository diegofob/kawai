package pe.edu.utp.electroplus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UsuarioController {

    @GetMapping("/micuenta")
    public String micuenta(Principal principal) {
        return "usuario/usuario";
    }
}
