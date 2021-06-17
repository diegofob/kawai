package pe.edu.utp.electroplus.service;

import java.util.List;

import pe.edu.utp.electroplus.model.Role;
import pe.edu.utp.electroplus.model.Usuario;


public interface ClienteService {

    public List<Usuario> listarTodos();

    public void guardar(Usuario usuario);

    public Usuario buscarPorId(Long id);

    public void eliminar(Long id);

    public List<Role> listarRoles();

    public Usuario findByUsername(String username);

}
