package com.aeonmerx.proyectopeguirest.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;


@Data
@Entity
@Table(name="empresas")
public class Empresa implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String nombre ;
    private String pais ;
    private String ciudad ;
    private String numero_empleados ;

}
