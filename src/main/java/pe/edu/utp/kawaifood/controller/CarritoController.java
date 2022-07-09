package pe.edu.utp.kawaifood.controller;

import static pe.edu.utp.kawaifood.utils.Constants.MENSAJE;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import pe.edu.utp.kawaifood.model.Carrito;
import pe.edu.utp.kawaifood.model.Producto;
import pe.edu.utp.kawaifood.model.Usuario;
import pe.edu.utp.kawaifood.repository.CarritoRepository;
import pe.edu.utp.kawaifood.repository.ProductoRepository;
import pe.edu.utp.kawaifood.service.ClienteService;

@Controller
@AllArgsConstructor
public class CarritoController {
    
    private final CarritoRepository carritoRepository;
    private final ProductoRepository productoRepository;
    private final ClienteService clienteService;

    @GetMapping("/carrito")
    public String carrito(Model model, Principal principal) {
        Usuario user = clienteService.findByUsername(principal.getName());
        List<Carrito> carritos = carritoRepository.findByIdUsuario(user.getId());
        List<Producto> productos = carritos.stream().map(Carrito::getProducto).collect(Collectors.toList());
        BigDecimal sumPrecio = productos.stream().map(Producto::getPrecio).reduce(BigDecimal.ZERO, BigDecimal::add);

        model.addAttribute("carritos", carritos);
        model.addAttribute("total", sumPrecio);

        return "carrito/create";
    }

    @GetMapping("/carrito/agregar/{idProducto}")
    public String carritoAgregar(@PathVariable Long idProducto, Principal principal, RedirectAttributes redirect) {
        Usuario user = clienteService.findByUsername(principal.getName());
        Producto producto = productoRepository.getOne(idProducto);
        BigDecimal total = producto.getDescuento(); 
        total = total.add(producto.getPrecio());
        carritoRepository.saveAndFlush(Carrito.builder()
                .cantidad(1)                
                .precio(producto.getPrecio())                
                .producto(producto)
                .descuento(total)
                .idUsuario(user.getId())
                .build());
        redirect.addFlashAttribute(MENSAJE, "Producto agregado correcamente");

        return "redirect:/carrito";
    }

    @GetMapping("/carrito/eliminar/{idcarrito}")
    public String carritoEliminar(@PathVariable Long idcarrito, Principal principal, RedirectAttributes redirect) {
        carritoRepository.deleteById(idcarrito);
        redirect.addFlashAttribute(MENSAJE, "EL producto se ha quitado del carrito de compras.");

        return "redirect:/carrito";
    }

}
