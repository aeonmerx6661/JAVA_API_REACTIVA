package com.aeonmerx.proyectopeguirest.dao;

import com.aeonmerx.proyectopeguirest.modelos.Persona;
import org.springframework.data.repository.CrudRepository;

public interface InterfazPersonaDao extends CrudRepository<Persona , Integer> {

}
