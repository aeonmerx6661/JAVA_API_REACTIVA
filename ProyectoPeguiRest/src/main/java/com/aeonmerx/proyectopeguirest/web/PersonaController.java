package com.aeonmerx.proyectopeguirest.web;

import com.aeonmerx.proyectopeguirest.modelos.Persona;
import com.aeonmerx.proyectopeguirest.servicios.persona.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import reactor.core.publisher.Mono;


@Slf4j
@Controller
public class PersonaController {
    @Autowired
 private PersonaService personaService ;
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("/personas")
    public Mono<String> inicio(Model model) {
        model.addAttribute("personas", personaService.listarPersonas());
        return Mono.just("personas/verpersonas") ;
    }
    @GetMapping("/modificarpersona")
    public Mono<String> agregar(Persona persona) {return Mono.just("personas/modificarpersona");}
    @PostMapping("/guardarpersona")
    public Mono<String> guardarPersona(Persona persona){
       personaService.guardar(persona);
       return Mono.just("redirect:/personas");
    }
    @GetMapping("/editarpersona/{id}")
    public Mono<String> editarPersona(Persona persona, Model model){
       persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona",persona);
       return Mono.just("personas/modificarpersona");
    }
    @GetMapping("/eliminarpersona")
    public Mono<String> eliminarPersona(Persona persona){
        personaService.eliminar(persona);
        return Mono.just("redirect:/personas");
    }
}
