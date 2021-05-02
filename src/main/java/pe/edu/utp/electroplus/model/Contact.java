package pe.edu.utp.electroplus.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "t_contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String phone;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birtdate;
    private String gender;
    private String maritalStatus;
    private Integer childrens;
}
