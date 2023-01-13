/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;
import javax.swing.*;
/**
 *
 * @author Daniel
 */
public class Repartidor extends Empleado {
    //atributos 
    private String zona;
    //metodo constructor

    public Repartidor(String zona, String codigo, int salario, String nombre, int edad) {
        super(codigo, salario, nombre, edad);
        this.zona = zona;
    }
   
    //metodos

    public String getZona() {//metodo getter par la variable zona
        return zona;
    }
    
    public int aplicarPlusRepartidor(){//metodo que nos va apedir retornar plus si cumple ciertas condiciones
        if(getEdad()<25 && zona=="Centro"){
          
           return getSalario()+getPlus();//retoranara plus si cumple la condicion de edad y zona 
        }
        else{
            return getSalario();//retornara un plus de 0 soles si no cumple la condicion de edad y de zona
        }
        
    }
    
    
}
