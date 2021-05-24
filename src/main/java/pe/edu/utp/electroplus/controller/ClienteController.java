package pe.edu.utp.electroplus.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.electroplus.model.Cliente;
import pe.edu.utp.electroplus.model.Rol;
import pe.edu.utp.electroplus.service.IClienteService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

    private final IClienteService clienteService;

    @GetMapping("/log")
    public String Log(Model model) {

        model.addAttribute("titulo", "INICIAR SESSION");
        return "/clientes/login";
    }

    @GetMapping("/lista")
    public String listarClientes(Model model) {

        List<Cliente> listadoClientes = clienteService.listarTodos();

        model.addAttribute("titulo", "Lista de cliente");
        model.addAttribute("clientes", listadoClientes);
        return "/clientes/listar";
    }

    @GetMapping("/create")
    public String crear(Model model) {

        Cliente cliente = new Cliente();
        List<Rol> listadoRoles = clienteService.listarRoles();

        model.addAttribute("titulo", "REGISTRAR CLIENTE");
        model.addAttribute("cliente", cliente);
        model.addAttribute("roles", listadoRoles);
        return "clientes/formulario";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Cliente cliente) {

        clienteService.guardar(cliente);
        System.out.println("Cliente Agregado Con Exito");
        return "redirect:/clientes/lista";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idCliente, Model model) {

        Cliente cliente = clienteService.buscarPorId(idCliente);
        List<Rol> listadoRoles = clienteService.listarRoles();

        model.addAttribute("titulo", "ACTUALIZAR CLIENTE");
        model.addAttribute("cliente", cliente);
        model.addAttribute("roles", listadoRoles);
        return "clientes/formulario";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long idCliente) {

        clienteService.eliminar(idCliente);
        System.out.println("Registro Eliminado:");
        return "redirect:/clientes/lista";
    }
}
