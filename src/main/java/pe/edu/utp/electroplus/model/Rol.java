package pe.edu.utp.electroplus.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
}
