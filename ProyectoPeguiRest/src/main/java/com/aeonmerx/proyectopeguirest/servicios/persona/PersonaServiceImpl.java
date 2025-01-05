package com.aeonmerx.proyectopeguirest.servicios.persona;

import com.aeonmerx.proyectopeguirest.dao.InterfazPersonaDao;
import com.aeonmerx.proyectopeguirest.modelos.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private InterfazPersonaDao interfazPersonaDao ;
    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
        return (List<Persona>) interfazPersonaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {

        interfazPersonaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
 interfazPersonaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
       return  interfazPersonaDao.findById(persona.getId()).orElseThrow(null);
    }
}
