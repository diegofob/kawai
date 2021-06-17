package pe.edu.utp.electroplus.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "t_producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "nombre no puede ser nulo")
    private String nombre;

    @NotNull(message = "precio no puede ser nulo")
    private BigDecimal precio;

    @NotNull(message = "descuento no puede ser nulo")
    private BigDecimal descuento;

    @NotNull(message = "imagen no puede estar vacio")
    @Column(columnDefinition = "TEXT")
    private String imagen;

    @NotNull(message = "nombre de la imagen no puede ser nulo")
    private String nombreimagen;

    @NotNull(message = "catergoria no puede ser nula")
    private Integer categoria;

    @NotNull(message = "descripcion no puede ser nula")
    private String descripcion;

    @Transient
    private BigDecimal precioDescuento;

}
