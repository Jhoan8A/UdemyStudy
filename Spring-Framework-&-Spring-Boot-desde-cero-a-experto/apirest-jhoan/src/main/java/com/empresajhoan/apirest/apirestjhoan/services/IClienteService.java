package com.empresajhoan.apirest.apirestjhoan.services;

import java.util.List;
import com.empresajhoan.apirest.apirestjhoan.models.entity.Cliente;

public interface IClienteService {
    //estamos haciendo una liosta de tipo Cliente que es la clase entity
    public List<Cliente> findAll();
}
