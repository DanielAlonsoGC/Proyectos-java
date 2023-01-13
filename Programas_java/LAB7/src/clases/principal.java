/*UNMSM – Facultad de Ing. Electrónica y Eléctrica
Escuela Profesional de Ingeniería Electrónica
Curso: Programación Avanzada
Docente: Mg. Ávila López, B. Patricio
Estudiante: Gutierrez Castillon Daniel Alonso
Fecha: 21/12/2020
Laboratorio Calificado 07
Entradas:B1,B2,L1,L2 
Objetivos
Calcular el area externa de la casa de juguete
Aprender el uso de clases y obejetos 
Afianzar los conocimientos de programacion orientada a objetos en java.
Restricciones:
_Cuando se ingreso un parametro del techo o pared este tiene que ser mayor que 0 
_B1>B2
*/
package clases;
import javax.swing.*;
/**
 *
 * @author Daniel
 */
public class principal {
    
    public static void main(String[] args) {
        double AreaSobresalidaTotal=0;
        double AreaHexagonoTecho=0;
        double AreaHexagonoPared=0;
        double AreaTechoyPared=0;
        int opc,opc1,opc2;
        //instanciando objeto pared
       Pared pared1=new Pared();
       //instanciando obejto techo 
       techo techo1=new techo();
       try{
       do{
       pared1.IngreseDatos1();//llamando metodo de pared para ingresar datos
       techo1.IngreseDatos2();//llamnado metodo de techo para ingresar datos
       if(pared1.dimension_base>techo1.dimension_base){
           JOptionPane.showMessageDialog(null,"Dato no valido \n Tiene que cumplir B1>B2 : ");
           do{
              techo1.dimension_base=Float.parseFloat(JOptionPane.showInputDialog("Ingrese la dimension del lado del techo \n B1 :"));
           }
           while(pared1.dimension_base>techo1.dimension_base);
       }
       pared1.AreaTotalPared();//llamando metodo para calcular el area del pared
       techo1.AreaTotalTecho();//llamando metodo para calcular el area del techo
       
       //calculo de area sobrante
       AreaHexagonoTecho=6*(Math.pow(techo1.dimension_base,2)*Math.sqrt(3))/4;
       AreaHexagonoPared=6*(Math.pow(pared1.dimension_base,2)*Math.sqrt(3))/4;
       AreaTechoyPared=AreaHexagonoTecho-AreaHexagonoPared;
       //calculo del area total externa
       AreaSobresalidaTotal=pared1.area+techo1.area+AreaTechoyPared;
       do{
       //Nos va permitir ingresar un numero de 1 al 6 para realizar una accion
               opc=Integer.parseInt(JOptionPane.showInputDialog(null,"Que desea calcular de la casa de juguete?\n Elija una opcion:\n 1)Area de una sola pared de la casa de juguete \n "
               + "2)Area de una sola parte del techo de la casa de juguete \n "
               + "3)Area total de las paredes de la casa de juguete \n "
               + "4)Area total del techo de la casa de juguete \n "
               + "5)Area total sobrante entre el techo y las paredes de la casa de juguete \n "
               + "6)Area total externa de la casa de juguete","Casa de Juguete",JOptionPane.INFORMATION_MESSAGE));
       if(opc<=0 || opc>=7){//cuando el valor ingresado es menor igual que 0 y mayor igual que 7
            JOptionPane.showMessageDialog(null,"Ingreso de dato incorrecto");
            do{
                   //se repite la accion en caso de que se haiga ingresado un dato incorrecto 
                    opc=Integer.parseInt(JOptionPane.showInputDialog(null,"Que desea calcular de la casa de juguete?\n Elija una opcion:\n 1)Area de una sola pared de la casa de juguete \n "
                    + "2)Area de una sola parte del techo de la casa de juguete \n "
                    + "3)Area total de las paredes de la casa de juguete \n "
                    + "4)Area total del techo de la casa de juguete \n "
                    + "5)Area total sobrante entre el techo y las paredes de la casa de juguete \n "
                    + "6)Area total externa de la casa de juguete","Casa de Juguete",JOptionPane.INFORMATION_MESSAGE));
            
            }while(opc<=0 || opc>=7);
       }//Fin de if
       //sentecnia switch que nos va a permitir evaluar la variable opc ingresada
            switch(opc){
                case 1: 
                    //Muestra el area de una sola pared de la casa de juguete 
                    JOptionPane.showMessageDialog(null,"El area de una sola pared de la casa de juguete es: "+pared1.AreaPartePared());break;//se aumenta el valor de la posicion en 4
                case 2:
                    //Muestra el area de una sola parte del techo de la casa de juguete
                    JOptionPane.showMessageDialog(null,"El area de una sola parte del techo de la casa de juguete es: "+techo1.AreaParteTecho());break;//se aumenta el valor de la posicion en 4
                case 3: 
                    //Muestra el area total de la paredes
                    JOptionPane.showMessageDialog(null,"El area total de la paredes es : "+ pared1.AreaTotalPared());break;
                case 4: 
                    //Muestra el area total del techo
                    JOptionPane.showMessageDialog(null,"El area total del techo  es : "+ techo1.AreaTotalTecho());break;
                case 5:
                    //Muestra el area total sobrante entre el techo y las paredes de la casa de juguete 
                    JOptionPane.showMessageDialog(null,"El area total sobrante entre el techo y las paredes de la casa de juguete "+ AreaTechoyPared );break;
                case 6:
                    //Muestra el area total externa de la casa de juguete
                    JOptionPane.showMessageDialog(null,"El area total externa de la casa de juguete "+AreaSobresalidaTotal);break;
                default: break; 
            }//fin de switch
            opc1=JOptionPane.showConfirmDialog(null, "Deseas regresar al panel de operaciones a escoger?");
            
       }
       while(opc1==0);
       
       opc2=JOptionPane.showConfirmDialog(null, "Desea volver a ingresar nuevos parametros  y calcular nuevas operaciones?");
       
       }while(opc2==0);
       }
       catch(NullPointerException e){
             JOptionPane.showMessageDialog(null,"NO INGRESO DATO : ");//acccion que se realiza cuando no se ingresa algun dato
        }
        catch(NumberFormatException e){
             JOptionPane.showMessageDialog(null,"INGRESÓ UN DATO INCORRECTO : ");//acccion que se realiza cuando se ingresa un tipo de dato dsitinto
       }
    }
}
