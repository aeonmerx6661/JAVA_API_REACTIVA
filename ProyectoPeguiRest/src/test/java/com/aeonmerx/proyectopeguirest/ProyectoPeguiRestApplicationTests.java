package com.aeonmerx.proyectopeguirest;

import com.aeonmerx.proyectopeguirest.modelos.Empresa;
import com.aeonmerx.proyectopeguirest.modelos.Persona;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class ProyectoPeguiRestApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper; // ObjectMapper para convertir objetos a JSON

    @Test
    void debeDevolverStatus200EnRutaRaiz() throws Exception {
        // Realiza la solicitud GET a la ruta raíz
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void debeGuardarPersonaRetornarStatus201() throws Exception {
        // Crea una instancia de Persona para enviar en la solicitud
        Persona persona = new Persona();
        persona.setNombres("NombrePrueba");
        persona.setApellidos("ApellidoPrueba");
        persona.setTelefono("123456789");
        persona.setCorreo("correo@ejemplo.com");

        // Convierte la instancia de Persona a JSON
        String personaJson = objectMapper.writeValueAsString(persona);

        // Realiza la solicitud POST al endpoint /api/personas
        mockMvc.perform(MockMvcRequestBuilders.post("/api/personas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(personaJson))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
    @Test
    void debeGuardarEmpresaRetornarStatus201() throws Exception {
        // Crea una instancia de Empresa para enviar en la solicitud
        Empresa empresa = new Empresa();
        empresa.setNombre("NombreEmpresaPrueba");
        empresa.setPais("PaisPrueba");
        empresa.setCiudad("CiudadPrueba");
        empresa.setNumero_empleados("1000");

        // Convierte la instancia de Empresa a JSON
        String empresaJson = objectMapper.writeValueAsString(empresa);

        // Realiza la solicitud POST al endpoint /api/empresas
        mockMvc.perform(MockMvcRequestBuilders.post("/api/empresas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(empresaJson))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

}
