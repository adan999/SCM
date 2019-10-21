package com.scm.scm.Mapper;

import com.scm.scm.Model.Compra;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompraMapper implements RowMapper<Compra> {

    /*Metodo encargado de tener un mapeo de los datos que se encuentran en nuestro modelo asi como los que
    * pertenecen a la tabla Compra*/
    @Override
    public Compra mapRow(ResultSet rs, int i) throws SQLException{
        Compra compra = new Compra();

        compra.setIdCompras(rs.getInt("idCompras"));
        compra.setNombreProd(rs.getString("NombreProd"));
        compra.setCantidad(rs.getInt("Cantidad"));
        compra.setPrecio(rs.getDouble("Precio"));
        compra.setUnidad(rs.getString("Unidad"));
        compra.setEstado(rs.getString("Estado"));
        compra.setTotal(rs.getDouble("Total"));
        compra.setFecha(rs.getString("Fecha"));

        return compra;
    }
}
