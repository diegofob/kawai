package pe.edu.utp.kawaifood.controller;

import java.security.Principal;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.AllArgsConstructor;
import pe.edu.utp.kawaifood.model.DetallePedido;
import pe.edu.utp.kawaifood.model.Pedido;
import pe.edu.utp.kawaifood.model.Usuario;
import pe.edu.utp.kawaifood.repository.ClienteRepository;
import pe.edu.utp.kawaifood.repository.DetallePedidoRepository;
import pe.edu.utp.kawaifood.repository.PedidoRepository;
import pe.edu.utp.kawaifood.service.ClienteService;

@Controller
@AllArgsConstructor
public class PedidoController {

    private static final String VIEW_INDEX ="pedido/index";
    private final PedidoRepository pedidoData;
    private final DetallePedidoRepository detallePedidoData;
    private final ClienteRepository clienteData;
    private final ClienteService clienteService;

    @GetMapping("/pedido/index")
    public String index(Model model, Principal principal){
        Usuario user = clienteService.findByUsername(principal.getName());
        List<Pedido> listItems = pedidoData.findItemsByCliente(user.getId());
        model.addAttribute("pedidos",listItems);
        return VIEW_INDEX;
    }    

    @GetMapping("/pedido/view/{id}")
    public String createSubmitForm(@PathVariable("id") int id, 
            Model model ){
        Pedido pedido = pedidoData.getOne(id);
        List<DetallePedido> listItems = detallePedidoData.findItemsByPedido(pedido);
        model.addAttribute("detalles",listItems);
        return "pedido/detalle";
    }
}