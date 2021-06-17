package pe.edu.utp.electroplus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_carrito")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "producto no puede ser nulo")
    @ManyToOne
    private Producto producto;

    @NotNull(message = "idUsuario no puede ser nulo")
    private Long idUsuario;

    @NotNull(message = "cantidad no puede ser nulo")
    private Integer cantidad;
}
