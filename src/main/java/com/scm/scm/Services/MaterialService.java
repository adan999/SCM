package com.scm.scm.Services;


import com.scm.scm.Model.Material;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MaterialService")
public interface MaterialService {
    public List<Material> consultarMaterial();

    public Material findById(int Id);

    public boolean realizarMaterial(Material material);

    public boolean modificarMaterial(Material material);

    public boolean entradasMaterial(int id, double cantidad);

}
