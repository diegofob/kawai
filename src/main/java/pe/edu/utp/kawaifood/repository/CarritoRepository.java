package pe.edu.utp.kawaifood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.utp.kawaifood.model.Carrito;


public interface CarritoRepository extends JpaRepository<Carrito, Long> {
    public List<Carrito> findByIdUsuario(Long idUsuario);   

}