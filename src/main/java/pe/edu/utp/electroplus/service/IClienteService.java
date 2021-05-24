package pe.edu.utp.electroplus.service;

import pe.edu.utp.electroplus.model.Cliente;
import pe.edu.utp.electroplus.model.Rol;

import java.util.List;


public interface IClienteService {

	public List<Cliente> listarTodos();
	public void  guardar(Cliente cliente);
	public Cliente buscarPorId (Long id);
	public void eliminar(Long id);
	public List<Rol> listarRoles();
	
}
