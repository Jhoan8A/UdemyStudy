package com.bolsadeideas.springboot.app.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
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
    @GetMapping({"/index", "/", "/home"})
    public String index(){
        return "index";
    }
    
}
