package pe.edu.utp.electroplus.repository;

import pe.edu.utp.electroplus.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface  PagoRepository extends JpaRepository<Pago, Integer> {
    
}
