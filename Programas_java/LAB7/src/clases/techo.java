/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import javax.swing.*;

/**
 *
 * @author Daniel
 */
public class techo {
    //atributos del techo
    float dimension_lado;
    float dimension_base;
    double area;
    
    //Metodo para ingresar valores de las dimensiones del techo
    public void IngreseDatos2(){
        
        this.dimension_lado=Float.parseFloat(JOptionPane.showInputDialog("Ingrese la dimension del lado del techo \n L1 :"));
        if(dimension_lado<=0){
            JOptionPane.showMessageDialog(null,"Dato incorrecto \n Ingrese L1>0");
            do{
            this.dimension_lado=Float.parseFloat(JOptionPane.showInputDialog("Ingrese la dimension del lado del techo \n L1 :"));
            }
            while(dimension_lado<=0);
        }
     
        
        
        this.dimension_base=Float.parseFloat(JOptionPane.showInputDialog("Ingrese la dimension de la base del techo \n B1 :"));
        //caso para cuando el 
        if(dimension_base<=0){
            JOptionPane.showMessageDialog(null,"Dato incorrecto \n Ingrese B1>0");
           do{
            this.dimension_base=Float.parseFloat(JOptionPane.showInputDialog("Ingrese la dimension del lado del techo \n B1 :"));
           }
           while(dimension_base<=0);
        }
    }
            
    
    //Metodo para calcular el area de una sola parte del techo
    public double AreaParteTecho(){
        double semiperimetro=(2*dimension_lado+dimension_base)/2;//calculo del semiperimetro
        double producto=semiperimetro*Math.pow(semiperimetro-dimension_lado,2)*(semiperimetro-dimension_base);//calculo del producto 
       return  area=Math.pow(producto,0.5);// calculo de area y retorno de valor
    }
    //Matodo para cacular el area total del techo
    public double AreaTotalTecho(){
        this.area=6*AreaParteTecho();//calculando el area total 
        return area;//retornando la variable area
        
    }
    

}