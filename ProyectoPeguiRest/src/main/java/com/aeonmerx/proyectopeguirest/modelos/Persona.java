package com.aeonmerx.proyectopeguirest.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


@Data
@Entity
@Table(name="personas")

public class Persona implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String nombres ;
    private String apellidos ;
    private String telefono ;
    private String correo ;

}
