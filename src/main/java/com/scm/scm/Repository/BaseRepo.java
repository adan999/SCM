package com.scm.scm.Repository;

import java.awt.print.Pageable;
import java.util.List;

//Interface de Repositorio Generico,
// ya que en la mayoria de los modelos se utilizaran los mismo metodos
public interface BaseRepo<T> {

    public boolean registrar(T object);

    public void modificar(int id);

    public List<T> consultar();

    public T findById(int Id);
}
