package pe.edu.utp.electroplus.controller;

import static pe.edu.utp.electroplus.utils.Constants.MENSAJE;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import pe.edu.utp.electroplus.model.Contacto;
import pe.edu.utp.electroplus.model.Role;
import pe.edu.utp.electroplus.model.Usuario;
import pe.edu.utp.electroplus.repository.ContactoRepository;
import pe.edu.utp.electroplus.service.ClienteService;
import pe.edu.utp.electroplus.service.LoginService;

@Controller
@AllArgsConstructor
@RequestMapping("/public")
public class PublicController {

    private final ClienteService clienteService;
    private final LoginService loginService;
    private final ContactoRepository contactsData;

    private static final String INDEX = "contacto/create";
    private static final String MODEL_CONTACTO = "contacto";

    @GetMapping("/cliente")
    public String formularioCreate(Model model) {
        List<Role> listadoRoles = clienteService.listarRoles();
        if (loginService.isAuthenticated()) {
            return "redirect:/";
        }

        model.addAttribute("titulo", "REGISTRARME");
        model.addAttribute("cliente", new Usuario());
        model.addAttribute("roles", listadoRoles);
        return "public/registrarme";
    }

    @PostMapping("/cliente")
    public String guardar(@ModelAttribute Usuario usuario, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            redirect.addAttribute(MENSAJE, "Ocurrió un error al registrarse.");
            return "public/registrarme";
        }
        clienteService.guardar(usuario);
        loginService.iniciarSesion(usuario.getUsername(), usuario.getPassword());
        redirect.addAttribute(MENSAJE, "Cliente Agregado con éxito");
        return "redirect:/login";
    }

    
}