package com.scm.scm.Services;

import com.scm.scm.Model.Compra;
import com.scm.scm.Model.CompraMinorista;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("compraMinoristaService")
public interface CompraMinoristaService {

    public boolean realizarCompraMinorista(CompraMinorista compraMinorista);

    public void cancelarCompraMinorista(String folioSegura);

    public List<CompraMinorista> consultarCompraMinorista();

    public CompraMinorista findByFolio(String folio);
}
