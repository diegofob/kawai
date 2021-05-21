package pe.edu.utp.electroplus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.utp.electroplus.model.Cliente;
import pe.edu.utp.electroplus.service.IClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;
 
	@GetMapping("/log")
	public String Log(Model model){
		 
	    model.addAttribute("titulo","INICIAR SESSION");
	    return "/clientes/login";
	}
	
	@GetMapping("/lista")
	public String listarClientes(Model model){
		
		List<Cliente> listadoClientes = clienteService.listarTodos();	
		
		model.addAttribute("titulo","Lista de cliente");
		model.addAttribute("clientes",listadoClientes);
		return "/clientes/login";
	}
	
	@GetMapping("/create")
	public String crear(Model model){
		
		Cliente cliente = new Cliente();
	 
		
		model.addAttribute("titulo","REGISTRAR CLIENTE");
		model.addAttribute("cliente",cliente); 
		return "/clientes/frmCrear";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Cliente cliente) {
		
		clienteService.guardar(cliente);
		System.out.println("Cliente Agregado Con Exito");
		return "redirect:/clientes";
	}

	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Long idCliente,Model model){
		
		Cliente cliente = clienteService.buscarPorId(idCliente);
		 
		
		model.addAttribute("titulo","ACTUALIZAR CLIENTE");
		model.addAttribute("cliente",cliente);
		 
		return "/clientes/frmCrear";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Long idCliente){
		
		clienteService.eliminar(idCliente);
		System.out.println("Registro Eliminado:");
		
		return "redirect:/clientes";
	}
	
	//LOGIN
	
 
	
}
