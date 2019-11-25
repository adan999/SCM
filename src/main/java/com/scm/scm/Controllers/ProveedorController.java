package com.scm.scm.Controllers;

import com.scm.scm.Constant.ViewConstant;
import com.scm.scm.Model.Proveedor;
import com.scm.scm.Services.impl.ProveedorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/proveedor")
public class ProveedorController {

    //Bean que nos permitira tener acceso a los elementos de la tabla compra y sus metodos correspondientes
    @Autowired
    private ProveedorServiceImpl proveedorServiceImpl;

    //Al entrar en esta ruta se obtendran los datos de la lista y se pasaran a la vista proporcionada
    @GetMapping(path = "/consultar")
    public String consultarProveedor(Model model){
        try {
            model.addAttribute("proveedor", proveedorServiceImpl.consultarProveedor());
            model.addAttribute("proveedores",new Proveedor());
        }
        catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }

        return ViewConstant.MANTPROVEEDORES;
    }

    /*Metodo que permite agregar regisitros, en donde se utiliza @PostMapping
     * para solamente realizar la accion y redirigir a la pagina proporcionada*/
    @PostMapping(path = "/addProveedor")
    public String registrarProveedor(Proveedor proveedor, Model model){
        List<Proveedor> proveedores = proveedorServiceImpl.consultarProveedor();
        proveedores.add(proveedor);
        model.addAttribute("proveedores",proveedores);

        //Se Manda el objeto al metodo  save() donde nos regresara un resultado booleano, true si se registro y false en el caso contrario
        if(proveedorServiceImpl.registrarProveedor(proveedor)){
            System.out.println("Entro");
        }
        else{
            System.out.println("No entro");
        }

        return "redirect:/proveedor/consultar";
    }


    /*Metodo utilizado para cambiar el estado de una compra de "Realizada" a "Cancelada" y despues redirecciona a
     * la misma página de consultar para obtener los datos actualizados*/
    @GetMapping(path = "/modificar")
    public String cancelCompra(@RequestParam(name = "id", required = true)int id, Proveedor proveedor){
        proveedorServiceImpl.modificarProveedor(id, proveedor);
        return "redirect:/proveedor/consultar";
    }

    @GetMapping(path = "/buscarProveedor")
    public String consultaEspecificaProveedor(@RequestParam(name = "id",required = true)int id, Model model){
        Proveedor proveedor = proveedorServiceImpl.findById(id);
        model.addAttribute("proveedorE",proveedor);

        return "";
    }
}
