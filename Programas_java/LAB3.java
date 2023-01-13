/*UNMSM – Facultad de Ing. Electrónica y Eléctrica
Escuela Profesional de Ingeniería Electrónica
Curso: Programación Avanzada
Docente: Mg. Ávila López, B. Patricio
Estudiante: Gutierrez Castillon Daniel Alonso
Fecha: 9/11/2020
Laboratorio Calificado 03
Entradas:posicion ,indicador de salida,indicador de salida para la cantidad de veces que gano,valor del dado,indicador del turno,variables de respuesta(opc1 y opc2) 
Objetivos
Aprender a utilizar las sentencias repetitivas y las sentencias de decision para lograr obtener un algoritmo adecuado para el Juego de tablero 
Aprender  a utilizar el comando ramdom que nos permite obtener valores aleatorios.
Afianzar los conocimientos de fundamentos de progrmacion en java.
Restricciones:
los valores que puede tomar el dado solo es del 1 al 6
cuando el jugador decida salirse del juego automaticamente pierde
*/
package labo3_gutierrez;
import javax.swing.*;

 /*
 * @author Daniel
 */
public class Labo3_Gutierrez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         int posicion=0,salida=0,salida1=0,valor_dado,i=0;//variables de salida, i nos permite contar el nuemro de lanzamientos,salida1 nos permite contar el numero de veces que gano el usuario
         int opc1,opc2;//variables de entrada para seleccionar si se desea lanzar dado o no y si se desea salir o no
        try{
        //inicio de do-while , esta sentencia nos va a permitir repetir el lanzamiento del dado 
        do{ 
            i=i+1;//nos permite aumentas el valor del turno
            //esta sentencia do while nos va a permitir repetir el lanzamiento del dado siempre y cuando el usurio digite un valor diferente de a o b
            do{
            opc1=Integer.parseInt(JOptionPane.showInputDialog("LANZAMIENTO N°: "+i+"\n"+"¿DESEA LANZAR DADO ?"+"\n"+"digite 0 --->SI"+"\n"+"digite 1 --->NO, DESEO SALTAR TURNO"));
                   
                   if(opc1!=0 && opc1!=1){//la sentencia if nos va a permitir mostrar un mensaje de que se ingreso un dato no valido 
                   JOptionPane.showMessageDialog(null,"¡Dato ingresado no valido!");
                   opc1=Integer.parseInt(JOptionPane.showInputDialog("TURNO: "+i+"\n"+"¿DESEA LANZAR DADO ELECTRONICO?"+"\n"+"digite 0 --->SI"+"\n"+"digite 1 --->NO,DESEO SALTAR TURNO"));
                   } 
            }
            while(opc1!=0 && opc1!=1);
            //fin de do-while
            
            if(opc1==0){
                valor_dado = (int)(Math.random()*6+1);//se almacena el valor del dado en la variable valor_dado
                JOptionPane.showMessageDialog(null,"EL VALOR DEL DADO OBTENIDO ES : "+valor_dado);//nos permite mostrar el valor del dado que se obtuvo
                posicion=posicion+valor_dado;//nos permite incrementar el valor de la posicion en el juego sabiendo el valor de dado
                
                //proceso de decision para saber que pasa cuando nos encontramos en ciertas casilla
                //inicio de la sentencia if-else,para el caso donde el valor de la posicion es menor de 10
                if(posicion<10){
                    switch(posicion){
                        case 1: posicion=posicion+4;break;//se aumenta el valor de la posicion en 4
                        case 3: posicion=posicion+4;break;//se aumenta el valor de la posicion en 4
                        case 6: posicion=posicion-2;break;//se disminuye el valor de la posicion en 2
                        case 8: posicion=posicion-4;break;//se disminuye el valor de la posicion en 4
                        case 9: posicion=2;break;//el valor de la posicion se establece en 2
                        default: break; 
                    }
                }
                //sentencia else para los casos donde el valor de la posicion  es mayor o igual a 10
                else if(posicion==10){//inicio de otra sentencia if-else para el caso de donde el valor de la posicion es igual a 10
                        posicion=0;//establecemos el valor de la posicion en 0;
                     }
                     else if(posicion>10){//caso donde el valor de posisicion de es mayor a 10
                          posicion=10-(posicion-10);//asignamos el valor de la posicion que se debe de encontar si el valor de la posicion excede a 10
                          switch(posicion){
                                case 1: posicion=posicion+4;break;//se aumenta el valor de la posicion en 4
                                case 3: posicion=posicion+4;break;//se aumenta el valor de la posicion en 4
                                case 6: posicion=posicion-2;break;//se disminuye el valor de la posicion en 2
                                case 8: posicion=posicion-4;break;//se disminuye el valor de la posicion en 4
                                case 9: posicion=2;break;//establecemos el valor de la posicion en 2
                                default: break;
                          }//fin if-else
                }//fin de la sentecnia if-else
                
                //inicio de if-else,esta sentencia nos a permitir mostrar el mensaje de la posicion siempre y cuando no se haiga llegado a la casilla 10
                if(posicion!=0){
                    JOptionPane.showMessageDialog(null,"USTED SE ENCUENTRA EN LA CASILLA  : "+posicion);//se muestra la posicion en que se encuentra el jugador
                }else{
                    JOptionPane.showMessageDialog(null,"¡GANASTE!"+"\n"+"¡TE ENCUENTRAS LA CASILLA 10!");//se muestra un mensaje de ganaste el juego
                    salida1=salida1+1;
                }
                //fin de la sentencia if-else

                do{
                    opc2=Integer.parseInt(JOptionPane.showInputDialog("DESEA SALIR DEL JUEGO : "+"\n"+"digite 0 --->SI"+"\n"+"digite 1 --->NO"));
                    if(opc2!=0 && opc2!=1){//la sentencia if nos va a permitir mostrar un mensaje de que se ingreso un dato no valido 
                    JOptionPane.showMessageDialog(null,"¡Dato ingresado no valido!");
                    opc2=Integer.parseInt(JOptionPane.showInputDialog("DESEA SALIR DEL JUEGO : "+"\n"+"digite 0 --->SI"+"\n"+"digite 1 --->NO"));
                    }
                  }
                  while(opc2!=0 && opc2!=1);
                //inicio de if cuando se desea salir del juego 
                if(opc2==0){
                    salida=1;//se le asigna el valor de 1 ya que se desea salir del juego
                }

            }//fin de if para el caso de lanzar dado
            //inici de la sentecia if,nos va permitir saltar un turno 
            if(opc1==1){
                //esta sentencia do-while nos va a permitir volver a digitir a o b si se a ingresado un valor distinto de ellos
                do{
                opc2=Integer.parseInt(JOptionPane.showInputDialog("DESEA SALIR DEL JUEGO : "+"\n"+"digite 0 --->SI"+"\n"+"digite 1 --->NO"));
                if(opc2!=0 && opc2!=1){//la sentencia if nos va a permitir mostrar un mensaje de que se ingreso un dato no valido 
                    JOptionPane.showMessageDialog(null,"¡Dato ingresado no valido!");
                    opc2=Integer.parseInt(JOptionPane.showInputDialog("DESEA SALIR DEL JUEGO : "+"\n"+"digite 0 --->SI"+"\n"+"digite 1 --->NO"));
                    }
                }
                while(opc2!=0 && opc2!=1);//fin do-while
                //esta sentencia if nos va a permitir salir del juego 
               
            }//fin de la sentecnia if cuando se escoje de que se desea saltar el turno
        
   
        }while(salida==0);//fin de do while
        //Sentencia if si se desea salir del juego cuando usted ya gano
        }
        catch(NullPointerException e){
             JOptionPane.showMessageDialog(null,"NO INGRESO DATO : ");
        }
        catch(NumberFormatException e){
             JOptionPane.showMessageDialog(null,"INGRESÓ UN DATO INCORRECTO : ");
        }
  
        //Sentencia if si se desea salir salir del juego sin haber ganado por lo tanto pierde      
        if(salida==1){
            if(salida1==0){
            JOptionPane.showMessageDialog(null,"¡FIN DEL JUEGO!"+"\n"+"USTED PERDIO");//se muestra un mensaje cuando se llega a salir del juego
            }
            else{
            JOptionPane.showMessageDialog(null,"¡FIN DEL JUEGO!"+"\n"+"USTED GANO"+" "+salida1+" "+"veces"); //se muestra un mensaje cuando se sale del juego pero indicando las veces que se gano
            }
        }//fin if
        
        
    }
        
}
    
