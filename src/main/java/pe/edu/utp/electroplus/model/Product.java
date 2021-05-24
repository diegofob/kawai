package pe.edu.utp.electroplus.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@Entity
@Table(name = "t_product2")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;

    @NotEmpty
    private String name;

    @NotEmpty
    private Double pricing;

    @NotEmpty
    private String discount;

    @NotEmpty
    private String description;
}
