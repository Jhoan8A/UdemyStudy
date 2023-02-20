package com.bolsadeideas.springboot.app.springbootweb.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bolsadeideas.springboot.app.springbootweb.models.Usuario;

@Controller
//agregamos RequestMapping para agregar una ruta generica para acceder a todos los metodos de este controller
//para acceder al metodo index, debemos poder primero localhost://8080/app/index
@RequestMapping("/app")
public class IndexController {
    //debemos mapear la ruta para que cuando el usuario invoque el home o index el invoque este metodo
    //cuando el usuario acceda a esa ruta ejecutara este metodo
    //tambien se puede colocal el tipo de methodo por el que se llama esta ruta por defecto es get => method = RequestMethod.GET
    //pero se puede poner el que se necesite: method = RequestMethod.POST, method = RequestMethod.PUT etc.
    //@RequestMapping(value="/index", method = RequestMethod.GET )
    
    //Pero para evitar codigo se puede usar el Mapping del tipo de peticion que se necesite como el siguiente:
    //@GetMapping(value="/index"), @PostMapping(value="/index"), @PutMapping(value="/index")etc.

    //asi ya sabemos que es GET el tipo de peticion y hasta podemos omitir el value= porque ya sabe que es get y tomara la url
    //@GetMapping("/index")

    //si incluimos llaves puede estar mapeado a varias rutas, es decil que cualquiera de esas rutas que llame el user, ejecutara el metodo index()
    @GetMapping({"/index", "/","", "/home"})
    //agregar ese parametro (Model model) nos permite agregar atributos para pasar a la interfaz de usuario como el "titulo"
    public String index(Model model){
        model.addAttribute("titulo", "Hola desde el controller Index!!");
        model.addAttribute("subtitulo", "Jhoan 8A");
        return "index";
    }

    @GetMapping("/perfil")
    public String perfil(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("JHOAN");
        usuario.setApellido("OCHOA");
        //usuario.setEmail("Jhoan@mail.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "PERFIL DEL USUARIO: ".concat(usuario.getNombre()));
        return "perfil";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        List<Usuario> usuarios =  new ArrayList<>();
        usuarios.add(new Usuario("Jhoan", "Ochoa", "pepe@pepe.com"));
        usuarios.add(new Usuario("Juan", "Parra", "pepe1@pepe.com"));
        usuarios.add(new Usuario("Jose", "Mendez", "pepe2@pepe.com"));
        model.addAttribute("titulo", "Listado de Usuarios.");
        model.addAttribute("usuarios", usuarios);
        return "listar";

    }

    /*se usa para pasar datos a la vista, en este ejemplo enviar la lista de usuarios, pero se usa para enviar 
    datos de varios metodos handled o como todos los de arriba y solo usamos este metodo para enviar los datos
    a la vista, ejemplo este controller podria ser un formulario, es decir que este metodo nos permite enviar datos a cualquier
    vista de la aplicacion*/
    //uso para verlo en varias vistas y lo pueden usar varios metodos
    //como parametro le pasamos como esta arriba el attributeName ("usuarios")
    //aqui usamos ("usuarios2")para mostrar otra forma de agregar usuarios a la lista
    @ModelAttribute("usuarios2")
    public List<Usuario> poblarUsuarios(){
        List<Usuario> usuarios2 = Arrays.asList(new Usuario("Andres", "Pedroza", "A@mail.com"),
                new Usuario("Jorge", "Malagan", "Jm@gmail.com"),
                new Usuario("Jesus", "Corredor", "jc@mail.com"));

        return usuarios2;

    }

    
}
