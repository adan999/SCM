package com.scm.scm.Repository;

import java.awt.print.Pageable;
import java.util.List;

//Interface de Repositorio Generico,
// ya que en la mayoria de los modelos se utilizaran los mismo metodos
public interface BaseRepo<T> {

    public boolean save(T object);

    public void update(int id);

    public List<T> findAll();

    public T findById(int Id);
}
