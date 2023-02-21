package com.empresajhoan.apirest.apirestjhoan.dao;

import org.springframework.data.repository.CrudRepository;
import com.empresajhoan.apirest.apirestjhoan.models.entity.Cliente;

//dentro de <nameClassEntity, idType> va el nombre de la clase entity que vamos a usar osea la tabla que vamos a afectar, y luegova el tipo de dato de la llave ID

public interface IClienteDao extends CrudRepository<Cliente, Long>  {
    
}
