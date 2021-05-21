package pe.edu.utp.electroplus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.electroplus.model.Cliente;
import pe.edu.utp.electroplus.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> listarTodos() {
		 
		return clienteRepository.findAll();
	}

	@Override
	public void guardar(Cliente cliente) {
		clienteRepository.save(cliente);
        
	}

	@Override
	public Cliente buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return clienteRepository.findById(id).orElse(null) ;
	}

	@Override
	public void eliminar(Long id) {
		clienteRepository.deleteById(id);

	}

}
