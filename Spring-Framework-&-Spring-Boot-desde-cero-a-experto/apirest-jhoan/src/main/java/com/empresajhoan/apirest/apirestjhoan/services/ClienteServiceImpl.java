package com.empresajhoan.apirest.apirestjhoan.services;

import java.util.List;

import com.empresajhoan.apirest.apirestjhoan.dao.IClienteDao;
import com.empresajhoan.apirest.apirestjhoan.models.entity.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements IClienteService {
    //injection of dependency 
    @Autowired
    //inyectamos el cliente DAO
    private IClienteDao clienteDao;
    @Override
    /*nos permite manejar transaccion en el metodo es un select asi que solo lo ponemos de lectura
     esta anotacion ya viene implicita en el CrudRepository, pero aqui la usamos como para hacerla mas
     explicita ya que sobreescribe la del CrudRepository*/
    @Transactional(readOnly=true)
    public List<Cliente> findAll() {
      //como el metodo retorna un iterable toca agregar un cast de List<Cliente>
        return (List<Cliente>) clienteDao.findAll();
    }
    
    
}
