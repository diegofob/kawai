package pe.edu.utp.electroplus.controller;

import java.security.Principal;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import pe.edu.utp.electroplus.model.Usuario;
import pe.edu.utp.electroplus.model.DetallePedido;
import pe.edu.utp.electroplus.model.Pedido;
import pe.edu.utp.electroplus.service.ClienteService;
import pe.edu.utp.electroplus.repository.ClienteRepository;
import pe.edu.utp.electroplus.repository.DetallePedidoRepository;
import pe.edu.utp.electroplus.repository.PedidoRepository;
import lombok.AllArgsConstructor;

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