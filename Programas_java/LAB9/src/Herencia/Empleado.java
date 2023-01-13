/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

/**
 *
 * @author Daniel
 */
public class Empleado extends Persona{
    //atributos
    private String codigo;
    private int salario;
    private final int plus=300;
    
    //metodo constructor

    public Empleado(String codigo, int salario, String nombre, int edad) {
        super(nombre, edad);
        this.codigo = codigo;
        this.salario = salario;
    }

   
    public String getCodigo() {
        return codigo;
    }


    public int getSalario() {
        return salario;
    }

    public int getPlus() {
        return plus;
    }
    
  
    
}
