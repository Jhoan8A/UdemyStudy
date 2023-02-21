package com.empresajhoan.apirest.apirestjhoan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.empresajhoan.apirest.apirestjhoan.models.entity.Cliente;
import com.empresajhoan.apirest.apirestjhoan.services.IClienteService;
/*AQUI CONFIGURAMOS LOS DOMINIOS QUE PUEDEN ACCEDER A LOS RECURSOS DE LA API, PUEDEN SER VARIOS EN ESTE CASO CONFIGURAMOS EL DE ANGULAR
 http://localhost:4200, tambien se pueden agregar los metodos permitidos (GET, PUT ETC) y las cabeceras permitidas*/
@CrossOrigin(origins= {"http://localhost:4200"})
//anotacion para apis rest, no controller normal como en otra app
@RestController
@RequestMapping("/api")
public class ClienteRestController {
    @Autowired
    private IClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> index(){
        return clienteService.findAll();
    }
}
