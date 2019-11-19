package com.scm.scm.Controllers;

import com.scm.scm.Constant.ViewConstant;
import com.scm.scm.Model.Compra;
import com.scm.scm.Services.impl.CompraServiceImpl;
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

//Notacion declarada para que el sistema sepa que esta clase pertenece al componente Controller
@Controller
@RequestMapping(path = "/compra")
public class CompraController {

    //Bean que nos permitira tener acceso a los elementos de la tabla compra y sus metodos correspondientes
    @Autowired
    private CompraServiceImpl compraServiceImpl;

    public static final double IVA = 1.08;

    //Al entrar en esta ruta se obtendran los datos de la lista y se pasaran a la vista proporcionada
    @GetMapping(path = "/consultar")
    public String consultarCompra(Model model){
        try {
            model.addAttribute("compra", compraServiceImpl.consultarCompra());
            model.addAttribute("compras",new Compra());
        }
        catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }

        return ViewConstant.CONSULTAC;
    }

    /*Metodo utilizado para entrar en la vista del formulario*/
    @GetMapping(path = "/realizar")
    public ModelAndView getForm(){

        return new ModelAndView(ViewConstant.REGISTROC).addObject("compra", new Compra());
    }

    /*Metodo que permite agregar regisitros, en donde se utiliza @PostMapping
     * para solamente realizar la accion y redirigir a la pagina proporcionada*/
    @PostMapping(path = "/addCompra")
    public String realizarCompra(Compra compra, Model model){
        List<Compra> compras = compraServiceImpl.consultarCompra();
        compras.add(compra);
        model.addAttribute("compras",compras);

        //Se multiplica la cantidad de material por su precio unitario y el 8% IVA y se le asigna al total del objeto de Compra
        double subTotal = compra.getCantidad()*compra.getPrecio()*IVA;
        compra.setTotal(Float.parseFloat(String.format("%.2f",subTotal)));

        //Se obtiene la fecha actual del sistema y se le asigna a la fecha del objeto de compra
        Date fecha = new Date();
        String fechaActual = fecha.getDate()+"/"+(fecha.getMonth()+1)+"/"+(fecha.getYear()+1900);

        compra.setFecha(fechaActual);

        //Se Manda el objeto al metodo  save() donde nos regresara un resultado booleano, true si se registro y false en el caso contrario
        if(compraServiceImpl.realizarCompra(compra)){
            System.out.println("Entro");
        }
        else{
            System.out.println("No entro");
        }

        return "redirect:/compra/consultar";
    }


    /*Metodo utilizado para cambiar el estado de una compra de "Realizada" a "Cancelada" y despues redirecciona a
    * la misma página de consultar para obtener los datos actualizados*/
    @GetMapping(path = "/cancelarCompra")
    public String cancelCompra(@RequestParam(name = "id", required = true)int id){
        compraServiceImpl.cancelarCompra(id);
        return "redirect:/compra/consultar";
    }

    @GetMapping(path = "/buscarEspecificaCompra")
    public String consultaEspecificaCompra(@RequestParam(name = "id",required = true)int id, Model model){
        Compra compras = compraServiceImpl.findById(id);
        model.addAttribute("compraE",compras);

        return "";
    }

}
