package com.scm.scm.Controllers;

import com.scm.scm.Constant.ViewConstant;
import com.scm.scm.Model.TipoUsuario;
import com.scm.scm.Model.Usuario;
import com.scm.scm.Services.impl.TipoUsuarioServiceImpl;
import com.scm.scm.Services.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//Notacion declarada para que el sistema sepa que esta clase pertenece al componente Controller
@Controller
@RequestMapping(path = "/usuario")
public class UsuarioController {

    //Bean que nos permitira tener acceso a los elementos de la tabla Usuario y sus metodos correspondientes
    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    //Bean que nos permitira tener acceso a los elementos de la tabla TipoUsuario y sus metodos correspondientes
    @Autowired
    private TipoUsuarioServiceImpl tipoUsuarioServiceImpl;

    //Al entrar en esta ruta se obtendran los datos de la lista y se pasaran a la vista proporcionada
    @GetMapping(path = "/consultar")
    public String consultarTipoMaterial(Model model){
        try {
            model.addAttribute("usuario", usuarioServiceImpl.consultarUsuario());
            model.addAttribute("usuarios",new Usuario());
            model.addAttribute("tipoUsuario", tipoUsuarioServiceImpl.consultarTipoUsuario());
            model.addAttribute("tipoUsuarios", new TipoUsuario());
        }
        catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }

        return ViewConstant.MANTUSERS;
    }

    /*Metodo que permite agregar regisitros, en donde se utiliza @PostMapping
     * para solamente realizar la accion y redirigir a la pagina proporcionada*/
    @PostMapping(path = "/addUsuario")
    public String registrarUsuario(Usuario usuario, Model model){
        List<Usuario> usuarios = usuarioServiceImpl.consultarUsuario();
        usuarios.add(usuario);
        model.addAttribute("usuarios",usuarios);

        //Se Manda el objeto al metodo  save() donde nos regresara un resultado booleano, true si se registro y false en el caso contrario
        if(usuarioServiceImpl.registrarUsuario(usuario)){
            System.out.println("Entro");
        }
        else{
            System.out.println("No entro");
        }

        return "redirect:/usuario/consultar";
    }

    /*Metodo utilizado para modificar los datos de los usuarios y despues redirecciona a
     * la misma página de consultar para obtener los datos actualizados*/
    @PostMapping(path = "/modificarUsuario")
    public String modificarUsuario(Usuario usuario, Model model){
        List<Usuario> usuarios = usuarioServiceImpl.consultarUsuario();
        usuarios.add(usuario);
        model.addAttribute("usuarios",usuarios);

        if(usuarioServiceImpl.modificarUsuario(usuario)){
            System.out.println("Entro");
        }
        else{
            System.out.println("No entro");
        }
        return "redirect:/usuario/consultar";
    }
}
