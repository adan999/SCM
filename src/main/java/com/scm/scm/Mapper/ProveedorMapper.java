package com.scm.scm.Mapper;

import com.scm.scm.Model.Proveedor;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProveedorMapper implements RowMapper<Proveedor> {

    /*Metodo encargado de tener un mapeo de los datos que se encuentran en nuestro modelo asi como los que
    * pertenecen a la tabla Proveedor*/
    @Override
    public Proveedor mapRow(ResultSet rs, int i) throws SQLException {
        Proveedor proveedor = new Proveedor();

        proveedor.setIdProveedor(rs.getInt("idProveedor"));
        proveedor.setRfc(rs.getString("rfc"));
        proveedor.setNomEmpresa(rs.getString("nomEmpresa"));
        proveedor.setDir(rs.getString("dir"));
        proveedor.setNumTel(rs.getString("numTel"));

        return proveedor;
    }
}
