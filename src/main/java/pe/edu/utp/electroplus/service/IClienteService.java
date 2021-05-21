package pe.edu.utp.electroplus.service;

import java.util.List;

import pe.edu.utp.electroplus.model.Cliente;


public interface IClienteService {

	public List<Cliente> listarTodos();
	public void  guardar(Cliente cliente);
	public Cliente buscarPorId (Long id);
	public void eliminar(Long id);
	
}
