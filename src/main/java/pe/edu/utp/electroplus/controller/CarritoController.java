package pe.edu.utp.electroplus.controller;

import org.springframework.ui.Model;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class CarritoController {
    private static final String INDEX = "/carrito/create";

    @GetMapping("/carrito")
    public String carrito(Model model) {
        return INDEX;
    }
}
