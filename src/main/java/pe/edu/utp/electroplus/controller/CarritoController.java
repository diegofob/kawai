package pe.edu.utp.electroplus.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class CarritoController {

    @GetMapping("/carrito")
    public String carrito(Principal principal) {
        return "carrito";
    }

}
