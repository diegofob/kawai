package pe.edu.utp.electroplus.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pe.edu.utp.electroplus.model.Cliente;
import pe.edu.utp.electroplus.model.Producto;
import pe.edu.utp.electroplus.repository.ProductoRepository;
import pe.edu.utp.electroplus.service.IClienteService;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class RouterController {

    private final ProductoRepository productoRepository;
    private final IClienteService clienteService;

    @GetMapping({"/", "/inicio"})
    public String index(Model model) {
        model.addAttribute("productos", listarProductos());
        return "catalogo";
    }

    /**
     * Navegación Lista de productos
     */
    @GetMapping("/productos")
    public String navigateActualizar(Model model) {
        model.addAttribute("productos", listarProductos());
        return "productos";
    }

    @GetMapping("/carrito")
    public String carrito(Principal principal) {
        return "carrito";
    }

    @GetMapping("/micuenta")
    public String micuenta() {
        return "usuario";
    }
    

    @GetMapping("/clientes")
    public String usuario(Model model) {

		List<Cliente> listadoClientes = clienteService.listarTodos();	
		
		model.addAttribute("titulo","Lista de cliente");
		model.addAttribute("clientes",listadoClientes);
		return "/clientes/listar";
    }

    public List<Producto> listarProductos() {
        return productoRepository.findAll().stream().peek(p -> p.setPrecioDescuento(p.getDescuento().add(p.getPrecio())))
                .collect(Collectors.toList());
    }

}