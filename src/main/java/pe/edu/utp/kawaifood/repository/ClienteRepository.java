package pe.edu.utp.kawaifood.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.utp.kawaifood.model.Usuario;

@Repository
public interface ClienteRepository extends JpaRepository<Usuario, Long> {

    public Usuario findByUsername(String username);

    public Optional<Usuario> findByUsernameAndPassword(String username, String password);
}
