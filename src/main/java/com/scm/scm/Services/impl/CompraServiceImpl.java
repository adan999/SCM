package com.scm.scm.Services.impl;

import com.scm.scm.Mapper.CompraMapper;
import com.scm.scm.Model.Compra;
import com.scm.scm.Services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CompraServiceImpl")
public class CompraServiceImpl implements CompraService {

    //Bean que nos permite tener acceso a las instrucciones que se le mandaran a nuestra base de datos
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //Metodo para registrar compras
    @Override
    public boolean realizarCompra(Compra object) {
        try {
            String sql = String.format("insert into Compra (NombreProd, Cantidad, Estado, Fecha, Precio, Total, Unidad) " +
                    "values('%s', '%s', 'Realizada', '%s', '%s', '%s', '%s')",
                    object.getNombreProd(),object.getCantidad(), object.getFecha(), object.getPrecio(), object.getTotal(), object.getUnidad());
                jdbcTemplate.execute(sql);
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return  false;
        }
    }

    //Metodo que recibe un id entero para modificar el estado de la compra
    @Override
    public void cancelarCompra(int id)
    {
        try {
            String sql = String.format("UPDATE Compra SET Estado = 'Cancelado' WHERE idCompras = '" + id + "'");
            jdbcTemplate.execute(sql);
        }catch(Exception ex) {

        }
    }


    //Metodo para Obtener todos los datos pertenecientes a la tabla compra y mandarlos a una lista de tipo compra
    @Override
    public List<Compra> consultarCompra() {
        return jdbcTemplate.query("Select * from Compra",new CompraMapper());
    }

    //Metodo para Obtener todos los datos pertenecientes a la tabla compra en donde el id sea igual al proporcionado y mandarlos a una lista de tipo compra
    @Override
    public Compra findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("Select * from Compra where idCompras=?",params,new CompraMapper());
    }
}
