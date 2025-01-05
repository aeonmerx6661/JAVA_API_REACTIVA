package com.aeonmerx.proyectopeguirest.api;

import com.aeonmerx.proyectopeguirest.modelos.Persona;
import com.aeonmerx.proyectopeguirest.servicios.persona.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaApiController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public ResponseEntity<List<Persona>> obtenerTodasLasPersonas() {
        List<Persona> personas = personaService.listarPersonas();
        return ResponseEntity.ok(personas);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Persona> obtenerPersona(@RequestBody Persona persona) {
        persona =  personaService.encontrarPersona(persona);
        return ResponseEntity.ok(persona);
    }

    @PostMapping
    public ResponseEntity<Persona> guardarPersona(@RequestBody Persona persona) {
        personaService.guardar(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(persona);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> actualizarPersona( @RequestBody Persona persona) {
        Persona personaExistente = personaService.encontrarPersona(persona);
        if (personaExistente != null) {
            personaService.guardar(persona);
            return ResponseEntity.ok(persona);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPersona(@RequestBody Persona persona) {
        Persona personaExistente = personaService.encontrarPersona(persona);
        if (personaExistente != null) {
            personaService.eliminar(persona);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

