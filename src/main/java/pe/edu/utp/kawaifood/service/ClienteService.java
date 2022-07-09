package pe.edu.utp.kawaifood.service;

import java.util.List;

import pe.edu.utp.kawaifood.model.Role;
import pe.edu.utp.kawaifood.model.Usuario;


public interface ClienteService {

    public List<Usuario> listarTodos();

    public void guardar(Usuario usuario);

    public Usuario buscarPorId(Long id);

    public void eliminar(Long id);

    public List<Role> listarRoles();

    public Usuario findByUsername(String username);

}
