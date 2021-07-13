package pe.edu.utp.electroplus.controller;

import static pe.edu.utp.electroplus.utils.Constants.CATEGORIAS;
import static pe.edu.utp.electroplus.utils.Constants.MENSAJE;
import static pe.edu.utp.electroplus.utils.Constants.PRODUCTO;
import static pe.edu.utp.electroplus.utils.Constants.TITULO;

import java.io.Console;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.hibernate.mapping.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.utp.electroplus.model.DetallePedido;
import pe.edu.utp.electroplus.model.Producto;
import pe.edu.utp.electroplus.repository.CategoriaRepository;
import pe.edu.utp.electroplus.repository.DetallePedidoRepository;
import pe.edu.utp.electroplus.repository.ProductoRepository;

@Controller
public class HomeController {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    private final DetallePedidoRepository detallePedidoData;

    public HomeController(ProductoRepository productoRepository, CategoriaRepository categoriaRepository,DetallePedidoRepository detallePedidoData) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
        this.detallePedidoData = detallePedidoData;
    }

    @GetMapping("/dashboard")
    public String index(Model model) {
        model.addAttribute("productos", listarProductos());

       // List<Map<String, Object>> listItems = detallePedidoData.querySumaTotal();

        //list<DetallePedido> listItems = detallePedidoData.findItemsByPedido(1);

       // System.out.println("test33 : ");
        

        return "catalogo/dashboard";
    }

    public List<Producto> listarProductos() {
        return productoRepository.findAll().stream()
                .peek(p -> p.setPrecioDescuento(p.getDescuento().add(p.getPrecio()))).collect(Collectors.toList());
    }

    
}
