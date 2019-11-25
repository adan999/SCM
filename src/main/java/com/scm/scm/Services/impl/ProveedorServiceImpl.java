package com.scm.scm.Services.impl;

import com.scm.scm.Mapper.ProveedorMapper;
import com.scm.scm.Model.Proveedor;
import com.scm.scm.Services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("proveedorServiceImpl")
public class ProveedorServiceImpl implements ProveedorService {

    //Bean que nos permite tener acceso a las instrucciones que se le mandaran a nuestra base de datos
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean registrarProveedor(Proveedor proveedor) {
        try {
            String sql = String.format("insert into proveedor (rfc, nomEmpresa, dir, numTel) " +
                            "values('%s', '%s', '%s', '%s')",
                    proveedor.getRfc(), proveedor.getNomEmpresa(), proveedor.getDir(), proveedor.getNumTel());
            jdbcTemplate.execute(sql);
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return  false;
        }
    }

    @Override
    public void modificarProveedor(int id, Proveedor proveedor) {
        try {
            String sql = String.format("UPDATE proveedor SET rfc = %s, nomEmpresa = %s," +
                    "dir = %s, numTel = %s WHERE idProveedor = '" + id + "'",
                    proveedor.getRfc(), proveedor.getNomEmpresa(), proveedor.getDir(), proveedor.getNumTel());
            jdbcTemplate.execute(sql);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Proveedor> consultarProveedor() {
        return jdbcTemplate.query("Select * from proveedor",new ProveedorMapper());
    }

    @Override
    public Proveedor findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("Select * from proveedor where idProveedor=?",params,new ProveedorMapper());
    }
}
