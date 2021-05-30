package pe.edu.utp.electroplus.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.utp.electroplus.model.Contacto;
import pe.edu.utp.electroplus.model.Usuario;
import pe.edu.utp.electroplus.model.Role;
import pe.edu.utp.electroplus.repository.ContactoRepository;
import pe.edu.utp.electroplus.service.ClienteService;
import pe.edu.utp.electroplus.service.LoginService;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/public")
public class PublicController {

    private final ClienteService clienteService;
    private final LoginService loginService;
    private final ContactoRepository contactsData;

    private static final String INDEX = "/contacto/create";
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
    public String guardar(@ModelAttribute Usuario usuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "public/registrarme";
        }
        clienteService.guardar(usuario);
        loginService.iniciarSesion(usuario.getUsername(), usuario.getPassword());
        System.out.println("Cliente Agregado Con Exito");
        return "redirect:/login";
    }

    @GetMapping("/contacto")
    public String index(Model model) {
        model.addAttribute(MODEL_CONTACTO, new Contacto());
        return INDEX;
    }

    @PostMapping("/contacto")
    public String createSubmitForm(Model model, @Valid Contacto objContact, BindingResult result) {
        if (result.hasFieldErrors()) {
            model.addAttribute("mensaje", "No se registro un contacto");
        } else {
            this.contactsData.save(objContact);
            model.addAttribute(MODEL_CONTACTO, objContact);
            model.addAttribute("mensaje", "Se registro un contacto");
        }
        return INDEX;
    }
}