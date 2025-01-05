package com.aeonmerx.proyectopeguirest.api;

import com.aeonmerx.proyectopeguirest.modelos.Empresa;
import com.aeonmerx.proyectopeguirest.servicios.empresa.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaApiController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<List<Empresa>> obtenerTodasLasEmpresas() {
        List<Empresa> empresas = empresaService.listarEmpresas();
        return ResponseEntity.ok(empresas);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Empresa> obtenerEmpresa(@RequestBody Empresa empresa) {
        empresa =  empresaService.encontrarEmpresa(empresa);
        return ResponseEntity.ok(empresa);
    }

    @PostMapping
    public ResponseEntity<Empresa> guardarEmpresa(@RequestBody Empresa empresa) {
        empresaService.guardar(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> actualizarEmpresa( @RequestBody Empresa empresa) {
        Empresa empresaExistente = empresaService.encontrarEmpresa(empresa);
        if (empresaExistente != null) {
            empresaService.guardar(empresa);
            return ResponseEntity.ok(empresa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpresa(@RequestBody Empresa empresa) {
        Empresa empresaExistente = empresaService.encontrarEmpresa(empresa);
        if (empresaExistente != null) {
            empresaService.eliminar(empresa);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

