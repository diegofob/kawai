package pe.edu.utp.kawaifood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.utp.kawaifood.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    public Role findByCodigo(String codigo);
}
