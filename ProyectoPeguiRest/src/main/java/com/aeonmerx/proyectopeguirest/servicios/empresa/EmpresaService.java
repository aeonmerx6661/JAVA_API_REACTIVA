package com.aeonmerx.proyectopeguirest.servicios.empresa;

import com.aeonmerx.proyectopeguirest.modelos.Empresa;
import java.util.List;

public interface EmpresaService {
    public List<Empresa> listarEmpresas();
    public void guardar(Empresa empresa);
    public void eliminar(Empresa empresa);
    public Empresa encontrarEmpresa(Empresa empresa);
}
