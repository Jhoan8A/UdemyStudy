package com.bolsadeideas.springboot.app.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

    //controlador para creacion de rutas 
    @GetMapping("/")
    public String index(){
        return "params/index";
    }
    //controlador que recibe la ruta con un parametro texto
    @GetMapping("/string")
    public String param(@RequestParam(name="texto", required=false, defaultValue="algún Valor....") String texto, Model model){

        model.addAttribute("resultado", "El parametro enviado es: " + texto);
        return "params/ver";
    } 
    
    //controlador que recibe la ruta con varios parametros 
    @GetMapping("/mix-params")
    public String paramsMix(@RequestParam String saludo, Integer numero, Model model){

        model.addAttribute("resultado", "'El resultado del saludo es: '" + saludo + "'y el numero es: '" 
        + numero);
        return "params/ver";
    }

    //controlador que recibe la ruta con varios parametros a travez del httpparamsrequest que nos permite pedir cualquier parametro 
    @GetMapping("/mix-params-request")
    public String paramsMixHttp(HttpServletRequest request, Model model){
        String saludo = request.getParameter("saludo");
        Integer numero = null;
        try {
            numero = Integer.parseInt(request.getParameter("numero"));
        }catch(NumberFormatException e){
            numero=0;
        }
       
        model.addAttribute("resultado", "'El resultado del saludo es: '" + saludo + "'y el numero es: '" 
        + numero);
        return "params/ver";
    }
}

//como de pasa el parametro en url http://localhost:8070/params/string?texto=Hola%20carechimba
