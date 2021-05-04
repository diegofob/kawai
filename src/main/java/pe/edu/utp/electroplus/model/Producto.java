package pe.edu.utp.electroplus.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "t_producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nombre;

    @NotNull
    private BigDecimal precio;

    @NotNull
    private BigDecimal descuento;

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String imagen;

    @NotNull
    private String nombreimagen;

    @NotNull
    private Integer categoria;

    @NotNull
    private String descripcion;

    @Transient
    private BigDecimal precioDescuento;

}
