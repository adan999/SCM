package com.scm.scm.Services;

import com.scm.scm.Model.Proveedor;
import org.springframework.stereotype.Service;

import java.util.List;

//Interface donde se declararan los metodos para manipular los datos de Proveedores
@Service("proveedorService")
public interface ProveedorService {

    public boolean registrarProveedor(Proveedor proveedor);

    public void modificarProveedor(int id, Proveedor proveedor);

    public List<Proveedor> consultarProveedor();

    public Proveedor findById(int Id);
}
