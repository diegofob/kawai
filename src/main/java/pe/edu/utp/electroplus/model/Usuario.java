package pe.edu.utp.electroplus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_cliente")
public class Usuario {

    public Usuario(boolean update) {
        this.isUpdate = update;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellidos;

    @Column(unique = true)
    private String username;

    private String password;
    private String passwordencode;

    @ManyToOne
    private Role role;

    @Transient
    private String codigoRole;

    @Transient
    private Boolean isUpdate = Boolean.FALSE;

    @Transient
    private String confirmarpassword;
}
