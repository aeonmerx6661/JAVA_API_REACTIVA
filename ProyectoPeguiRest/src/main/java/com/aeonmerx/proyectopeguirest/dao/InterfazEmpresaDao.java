package com.aeonmerx.proyectopeguirest.dao;

import com.aeonmerx.proyectopeguirest.modelos.Empresa;
import org.springframework.data.repository.CrudRepository;

public interface InterfazEmpresaDao extends CrudRepository<Empresa , Integer> {

}
