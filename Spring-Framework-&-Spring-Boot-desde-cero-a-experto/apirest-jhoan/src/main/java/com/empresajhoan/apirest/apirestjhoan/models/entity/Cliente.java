package com.empresajhoan.apirest.apirestjhoan.models.entity;

import java.io.Serializable;
import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Temporal;

/*La serialización es el proceso de convertir un objeto en una 
secuencia de bytes para almacenarlo o transmitirlo a la memoria, 
a una base de datos o a un archivo. Su propósito principal es guardar 
el estado de un objeto para poder volver a crearlo cuando sea necesario. El proceso inverso se denomina deserialización*/

@Entity
/*si se llama igual la tabla que la clase se omite el @Table, pero las tablas
 deben nombrarse con la primera letra en minuscula y en plural*/
@Table(name="clientes")
public class Cliente implements Serializable{
    //lo usamos para decir que el id sera la llave primaria
    @Id
    //Usamos IDENTITY en mysql en oracle se usa SEQUENCE normalmente para el id autoincrementable 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    //@Colum() se usa si el atributo se llama diferente en la bd, si queremos que acepte nulos, el tamaño etc.
    private String nombre;
    private String apellido;
    private String email;
    //aqui usamos el @Column ya que en bd se separa con guion al piso y se usa solo minusculas create_at 
    @Column(name="create_at")
    //usamos este para cambiar la fecha de java a la fecha de mysql
    @Temporal(TemporalType.DATE)
    private Date createAT;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateAT() {
        return createAT;
    }

    public void setCreateAT(Date createAT) {
        this.createAT = createAT;
    }

}
