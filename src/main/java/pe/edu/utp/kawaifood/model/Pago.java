package pe.edu.utp.kawaifood.model;

import java.math.BigDecimal;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_pago")
public class Pago {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaPago;

    private String nombreTarjeta;
    @NotNull(message = "el numero de la tarjeta no puede ser nulo")
    private String numeroTarjeta;
    
    @Transient
    private String fechaVen;
    
    @NotNull(message = "el cvv no puede ser nulo")
    @Transient
    private String cvv;
    
    private BigDecimal montoTotal;
    
    private Long clienteId;
    
    @NotNull(message = "el tipo documento no puede ser nulo")
    private String documento; 
    
    @NotNull(message = "el documento no puede ser nulo")
    private String dni; 
    
    @NotNull(message = "las cuotas no puede ser nulo")
    private String cuota;
    
    @NotNull(message = "la direccion no puede ser nulo")
    private String direccion; 
}
