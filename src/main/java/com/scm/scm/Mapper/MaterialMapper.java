package com.scm.scm.Mapper;

import com.scm.scm.Model.Material;
import com.scm.scm.Model.TipoMaterial;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MaterialMapper implements RowMapper<Material> {

    @Override
    public Material mapRow(ResultSet rs, int i) throws SQLException {
        Material material = new Material();

        material.setIdMaterial(rs.getInt("idMaterial"));
        material.setNomMaterial(rs.getString("nomMaterial"));
        material.setUnidadMedida(rs.getString("material.unidadMedida"));
        material.setCantidadInicial(rs.getDouble("cantidadInicial"));
        material.setEntradas(rs.getDouble("material.entradas"));
        material.setSalidas(rs.getDouble("material.salidas"));
        material.setCantidadActual(rs.getDouble("cantidadActual"));
        material.setIdMaterialCat(rs.getInt("idMaterialCat"));
        material.setNomCategoria(rs.getString("nomCategoria"));


        return material;
    }
}
