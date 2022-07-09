package pe.edu.utp.kawaifood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;
import pe.edu.utp.kawaifood.service.LoginService;

@Controller
@AllArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String Log(Model model, String error, String logout) {
        if (loginService.isAuthenticated()) {
            return "redirect:/";
        }
        if (error != null)
            model.addAttribute("message", "Email o Contraseña son incorrectos.");

        if (logout != null)
            model.addAttribute("message", "Se ha cerrado sesión satifactoriamente.");

        model.addAttribute("titulo", "INICIAR SESSION");
        return "login";
    }

}
