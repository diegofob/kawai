package pe.edu.utp.electroplus.controller;

import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import pe.edu.utp.electroplus.model.Producto;
import pe.edu.utp.electroplus.repository.CategoriaRepository;
import pe.edu.utp.electroplus.repository.ProductoRepository;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@Controller
@AllArgsConstructor
public class ProductoController {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    @GetMapping("/producto")
    public String navigate(Model model) {
        Producto producto = new Producto();
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "registrarproducto";
    }

    @PostMapping("/producto/registrar")
    public String registrarProducto(Model model, @Valid Producto producto, BindingResult result) {
        log.info("{}", producto.toString());
        if (result.hasFieldErrors()) {
            model.addAttribute("mensaje", "Debe completar los campos requeridos");
        } else {
            productoRepository.saveAndFlush(producto);
            model.addAttribute("producto", producto);
            model.addAttribute("mensaje", "Se registro un nuevo producto");
        }
        return "redirect:/producto";
    }

    /**
     * Actualizar Productos
     */

    @GetMapping("/producto/{id}")
    public String navigateActualizar(Model model, @PathVariable Long id) {
        Producto producto = productoRepository.getOne(id);
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "actualizarproducto";
    }

    @PostMapping("/producto/actualizar")
    public String actualizarProducto(Model model, @Valid Producto producto, BindingResult result) {
        if (result.hasFieldErrors()) {
            model.addAttribute("mensaje", "Debe completar los campos requeridos");
        } else {
//            Producto update = productoRepository.getOne(producto.getId());
//            update.setNombre(producto.getNombre());
//            update.setPrecio(producto.getPrecio());
//            update.setImagen(producto.getImagen());
//            update.setDescripcion(producto.getDescripcion());
//            update.setCategoria(producto.getCategoria());
            productoRepository.save(producto);
            model.addAttribute("producto", producto);
            model.addAttribute("mensaje", "Se registro un nuevo producto");
        }
        return "redirect:/producto/" + producto.getId();
    }
}
