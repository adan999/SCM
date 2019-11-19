package com.scm.scm.Services;

import com.scm.scm.Model.Compra;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

//Interface de Repositorio Generico,
// ya que en la mayoria de los modelos se utilizaran los mismo metodos
@Service("compraService")
public interface CompraService {

    public boolean realizarCompra(Compra compra);

    public void cancelarCompra(int id);

    public List<Compra> consultarCompra();

    public Compra findById(int Id);
}
