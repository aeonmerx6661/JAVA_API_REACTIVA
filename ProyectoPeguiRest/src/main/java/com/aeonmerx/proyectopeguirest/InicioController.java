package com.aeonmerx.proyectopeguirest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

@Slf4j
@Controller
public class InicioController {

  @GetMapping("/")
    public Mono<String> inicio(Model model){
        return Mono.just("index") ;
    }
}
