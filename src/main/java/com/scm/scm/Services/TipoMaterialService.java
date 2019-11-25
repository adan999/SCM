package com.scm.scm.Services;

import com.scm.scm.Model.Compra;
import com.scm.scm.Model.TipoMaterial;
import org.springframework.stereotype.Service;

import java.util.List;

//Interface de Repositorio Generico,
// ya que en la mayoria de los modelos se utilizaran los mismo metodos
@Service("tipoMaterialService")
public interface TipoMaterialService {

    public List<TipoMaterial> consultarTipoMaterial();

    public TipoMaterial findById(int Id);

    public boolean realizarTipoMaterial(TipoMaterial tipoMaterial);

    public boolean modificarTipoMaterial(TipoMaterial tipoMaterial);

    public boolean modificarCantidadTipo(int id, double cantidad);

}
