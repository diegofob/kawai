package pe.edu.utp.electroplus.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;

import javax.validation.Valid;

import pe.edu.utp.electroplus.model.Contacto;
import pe.edu.utp.electroplus.repository.ContactoRepository;

@Controller
@AllArgsConstructor
public class ContactoController {
    private static final String INDEX = "/contacto/create";
    private static final String MODEL_CONTACTO = "contacto";

    private final ContactoRepository contactsData;

    @GetMapping("/contacto/create")
    public String index(Model model) {
        model.addAttribute(MODEL_CONTACTO, new Contacto());
        return INDEX;
    }

    @PostMapping("/contacto/create")
    public String createSubmitForm(Model model,
                                   @Valid Contacto objContact, BindingResult result) {
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
