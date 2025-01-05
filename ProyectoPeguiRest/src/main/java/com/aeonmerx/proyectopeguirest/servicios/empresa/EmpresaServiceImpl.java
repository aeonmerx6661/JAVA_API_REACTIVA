package com.aeonmerx.proyectopeguirest.servicios.empresa;
import com.aeonmerx.proyectopeguirest.dao.InterfazEmpresaDao;
import com.aeonmerx.proyectopeguirest.modelos.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmpresaServiceImpl implements EmpresaService {
    @Autowired
    private InterfazEmpresaDao interfazEmpresaDao ;
    @Override
    @Transactional(readOnly = true)
    public List<Empresa> listarEmpresas() {
        return (List<Empresa>) interfazEmpresaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Empresa empresa) {

        interfazEmpresaDao.save(empresa);
    }
    @Override
    @Transactional
    public void eliminar(Empresa empresa) {
        interfazEmpresaDao.delete(empresa);
    }

    @Override
    @Transactional(readOnly = true)
    public Empresa encontrarEmpresa(Empresa empresa) {
        return  interfazEmpresaDao.findById(empresa.getId()).orElseThrow(null);
    }
}
