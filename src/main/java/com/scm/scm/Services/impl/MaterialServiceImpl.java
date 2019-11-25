package com.scm.scm.Services.impl;

import com.scm.scm.Mapper.MaterialMapper;
import com.scm.scm.Model.Material;
import com.scm.scm.Services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MaterialServiceImpl")
public class MaterialServiceImpl implements MaterialService {

    //Bean que nos permite tener acceso a las instrucciones que se le mandaran a nuestra base de datos
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean realizarMaterial(Material object) {
        try {
            String sql = String.format("insert into Material (IdMaterial, NomMaterial, UnidadMedida,  CantidadInicial, Entradas, Salidas, CantidadActual, MaterialCategoria_idMaterialCat) " +
                            "values('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                    object.getIdMaterial(), object.getNomMaterial(), object.getUnidadMedida(), object.getCantidadInicial(), object.getEntradas(), object.getSalidas(), object.getCantidadActual(), object.getIdMaterialCat());
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //Metodo para Obtener todos los datos pertenecientes a la tabla tipoMaterial y mandarlos a una lista de tipo TipoMaterial
    @Override
    public List<Material> consultarMaterial() {
        return jdbcTemplate.query("Select idMaterial, nomMaterial, material.unidadMedida, cantidadInicial, material.entradas," +
                " material.salidas, cantidadActual, idMaterialCat, nomCategoria from Material join TipoMaterial" +
                " ON (material.MaterialCategoria_idMaterialCat = idMaterialCat)", new MaterialMapper());
    }


    //Metodo para Obtener todos los datos pertenecientes a la tabla tipoMaterial en donde el id sea igual al proporcionado y mandarlos a una lista de tipo TipoMaterial
   /* @Override
    public Material findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("Select * from Material where idMaterial=?",params,new MaterialMapper());
    }*/


    @Override
    public boolean modificarMaterial(Material object) {
        try {
            String sql = String.format("UPDATE Material SET NomMaterial = '" + object.getNomMaterial() + "' WHERE idMaterial = '" + object.getIdMaterial() + "'");
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
