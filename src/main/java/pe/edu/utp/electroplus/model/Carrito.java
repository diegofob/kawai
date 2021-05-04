package pe.edu.utp.electroplus.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "t_carrito")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long idProducto;

    @NotNull
    private Long idUsuario;

    @NotNull
    private Integer cantidad;
}
