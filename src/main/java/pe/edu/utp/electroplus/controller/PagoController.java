package pe.edu.utp.electroplus.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;

import pe.edu.utp.electroplus.model.Usuario;
import pe.edu.utp.electroplus.model.DetallePedido;
import pe.edu.utp.electroplus.model.Pago;
import pe.edu.utp.electroplus.model.Pedido;
import pe.edu.utp.electroplus.model.Carrito;
import pe.edu.utp.electroplus.repository.ClienteRepository;
import pe.edu.utp.electroplus.repository.DetallePedidoRepository;
import pe.edu.utp.electroplus.repository.PagoRepository;
import pe.edu.utp.electroplus.repository.PedidoRepository;
import pe.edu.utp.electroplus.repository.CarritoRepository;
import pe.edu.utp.electroplus.service.ClienteService;
import pe.edu.utp.electroplus.repository.ProductoRepository;
import pe.edu.utp.electroplus.model.Producto;


import javax.validation.Valid;


import java.util.ArrayList;
import java.util.Date;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
public class PagoController {
    private static final String VIEW_INDEX ="pago/create";
    private static String MODEL_VIEW="pago";
    private final CarritoRepository carritoData;
    private final ClienteRepository clienteData;
    private final PagoRepository pagoData;
    private final PedidoRepository pedidoData;
    private final DetallePedidoRepository detallePedidoData;
    private final ClienteService clienteService;
    private final ProductoRepository productoRepository;

    @GetMapping("/pago/create")
    public String index(Model model, Principal principal){
        Usuario user = clienteService.findByUsername(principal.getName());
        List<Carrito> carritos = carritoData.findByIdUsuario(user.getId());
        if(carritos.isEmpty()){
            model.addAttribute("mensaje", "Carrito Vacio");
            return "proforma/index";
        }
        List<Producto> productos = carritos.stream().map(Carrito::getProducto).collect(Collectors.toList());
        BigDecimal montoTotal = productos.stream().map(Producto::getPrecio).reduce(BigDecimal.ZERO, BigDecimal::add);
        Pago pago = new Pago();
        pago.setFechaPago(new Date());
        pago.setMontoTotal(montoTotal);
        pago.setClienteId(user.getId());
        pago.setNombreTarjeta(
            user.getNombre().concat(" ").
            concat(user.getApellidos()));
        model.addAttribute(MODEL_VIEW, pago);
        return VIEW_INDEX;
    } 
    
    @PostMapping("/pago/create")
    public String createSubmitForm(Model model, Principal principal,
        @Valid Pago objPago, BindingResult result ){
        Usuario user = clienteService.findByUsername(principal.getName());
        if(result.hasFieldErrors()) {
            model.addAttribute("mensaje", "No se puede registrar pago");
        }else{
            Pedido pedido = new Pedido();
            pedido.setClienteId(objPago.getClienteId());
            pedido.setMontoTotal(objPago.getMontoTotal());
            pedido.setOrderDate(new Date());
            pedidoData.save(pedido);
            List<Carrito> carritos = carritoData.findByIdUsuario(user.getId());
            carritos.stream().forEach(o -> o.setStatus("PROCESED"));
            carritoData.saveAll(carritos);
            List<DetallePedido> detalles = new ArrayList<DetallePedido>();
            for (Carrito pro : carritos) {
                DetallePedido dp = new DetallePedido();
                dp.setPedido(pedido);
                dp.setProduct(pro.getProducto());   
                dp.setPrecio(pro.getPrecio());                         
                dp.setCantidad(pro.getCantidad());
                detalles.add(dp);
            }
            detallePedidoData.saveAll(detalles);
            objPago.setFechaPago(new Date());
            pagoData.save(objPago);
            model.addAttribute(MODEL_VIEW, objPago);
            pedidoData.flush();
            model.addAttribute("mensaje", "Se registro su pago y se genero su pedido nro "+ pedido.getId());
        }
        return VIEW_INDEX;
    }

   
}

