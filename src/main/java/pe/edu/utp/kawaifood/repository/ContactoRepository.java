package pe.edu.utp.kawaifood.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.utp.kawaifood.model.Contacto;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Integer>{

}
