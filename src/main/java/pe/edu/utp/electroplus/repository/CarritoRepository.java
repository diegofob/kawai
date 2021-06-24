package pe.edu.utp.electroplus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.utp.electroplus.model.Carrito;


public interface CarritoRepository extends JpaRepository<Carrito, Long> {
    public List<Carrito> findByIdUsuario(Long idUsuario);   

}