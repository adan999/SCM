package com.scm.scm.Services;

import com.scm.scm.Model.Compra;
import org.springframework.stereotype.Service;
import java.util.List;

//Interface donde se declararan los metodos para manipular los datos de Compras
@Service("compraService")
public interface CompraService {

    public boolean realizarCompra(Compra compra);

    public void cancelarCompra(int id);

    public List<Compra> consultarCompra();

    public Compra findById(int Id);
}
