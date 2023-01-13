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
public class Pared {
    //atributos
    float dimension_altura;
    float dimension_base;
    double area;
    //metodos
   //Metodo para ingresar valores de las dimensiones de la pared
    
    public void IngreseDatos1(){
        
        this.dimension_altura=Float.parseFloat(JOptionPane.showInputDialog("Ingrese la dimension de la altura de la pared \n L2 :"));
        if(dimension_altura<0){
            JOptionPane.showMessageDialog(null,"Dato incorrecto \n Ingrese L2>0");
            do{
            this.dimension_altura=Float.parseFloat(JOptionPane.showInputDialog("Ingrese la dimension del lado del techo \n L2 :"));
            }
            while(dimension_altura<0);
        }
       
        this.dimension_base=Float.parseFloat(JOptionPane.showInputDialog("Ingrese la dimension de la base de la pared \n B2 :"));   
        
        if(dimension_base<0){
            JOptionPane.showMessageDialog(null,"Dato incorrecto \n Ingrese B2>0");
             do{
            this.dimension_base=Float.parseFloat(JOptionPane.showInputDialog("Ingrese la dimension del lado del techo \n B2 :"));
             }
             while(dimension_base<0); 
        }
        
       
    }
    public double AreaPartePared(){
        area=dimension_altura*dimension_base;
        return area;
    }
    public double AreaTotalPared(){
        
        this.area=6*AreaPartePared();
        return area;
        
    }
    
}
