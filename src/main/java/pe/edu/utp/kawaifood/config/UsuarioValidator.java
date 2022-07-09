package pe.edu.utp.kawaifood.config;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import lombok.AllArgsConstructor;
import pe.edu.utp.kawaifood.model.Usuario;
import pe.edu.utp.kawaifood.service.ClienteService;

@Component
@AllArgsConstructor
public class UsuarioValidator implements Validator {

    private final ClienteService clienteService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Usuario.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Usuario user = (Usuario) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "El campo Correo Electrónico no debe ser vacío.");
        if (!user.getIsUpdate())
            if (clienteService.findByUsername(user.getUsername()) != null) {
                errors.rejectValue("username", "El email registrado ya existe");
            }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
                "El campo Confirmar contraseña no debe ser vacío.");
        if (!user.getConfirmarpassword().equals(user.getPassword())) {
            errors.rejectValue("confirmarpassword", "Las contraseñas no coinciden");
        }
    }
}
