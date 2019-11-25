package com.scm.scm.Services.impl;

import com.scm.scm.Model.Usuario;
import com.scm.scm.Services.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements UsuarioService {
    @Override
    public boolean registrarUsuario(Usuario usuario) {
        return false;
    }

    @Override
    public void modificarUsuario(int id, Usuario usuario) {

    }

    @Override
    public List<Usuario> consultarUsuario() {
        return null;
    }

    @Override
    public Usuario findById(int Id) {
        return null;
    }
}
