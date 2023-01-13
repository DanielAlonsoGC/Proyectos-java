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
public class Vendedor extends Empleado {
    //atributos 
    private double comision ;
    
    //metodo constructor

    public Vendedor(double comision, String codigo, int salario, String nombre, int edad) {
        super(codigo, salario, nombre, edad);
        this.comision = comision;
    }

    
    //metodos para la clase vendedor

    public double getComision() {
        return comision;
    }
    
    public int aplicarPlusVendedor(){
        
        if(getEdad() >30 && comision>200){
            return getSalario()+getPlus();
        
           //"EL vendedor recibira 300 soles de plus si cumple las condiciones de edad y comision; 
        }
        else{
            return getSalario();
            //Retornara 0 soles de plus si no cumple la condicion de edad y comision 
        }
    }
  
}
