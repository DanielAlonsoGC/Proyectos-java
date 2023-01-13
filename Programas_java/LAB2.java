/*UNMSM – Facultad de Ing. Electrónica y Eléctrica
Escuela Profesional de Ingeniería Electrónica
Curso: Programación Avanzada
Docente: Mg. Ávila López, B. Patricio
Estudiante: Gutierrez Castillon Daniel Alonso
Fecha: 2/11/2020
Laboratorio Calificado 02
Objetivos:
Datos de entrada: sensor de gas ,sensor de humo, temperatura.
Determinar la activacion de la alarma contra incendios teniendo en cuenta algunas restricciones
Afianzar los conocimientos de los siguientes temas: Tipos de Datos, Estructuras Selectivas 
Dominar los fundamento de Java
Restricciones: 
No se permite el ingreso de temperatura de un valor de tipo de dato distinto de float
Solo se permite ingresar s o n para decir si los sencores se encuantran acticados


 */
package gutierrez_castillon_daniel_labo02;
import javax.swing.*;//importaremos la esta libreria para ingresar datos datos por ventana//

/**
 *
 * @author Daniel
 */
public class Gutierrez_Castillon_Daniel_labo02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //declaracion de variables 
        String a1,a2,a3;
        float T;
        char SensorGas,SensorHumo,opcion;
        
        //el bucle do-while nos va a permitir retornar al programa 
        do{
        //nos muestra el tema del progrma en una ventana//
        JOptionPane.showMessageDialog(null," DETERMINAR LA ACTIVACION DE ALARMA CONTRA INCENDIOS");  
        //Pregunta al usuario para el ingreso de la temperatura que se encuentra el edificio
        
        //La sentencia try ,catch , finally nos van a permitir evaluar si existe un error//
        try{
         T=Float.parseFloat(JOptionPane.showInputDialog("DIGITE LA TEMPERATURA (ºC) "));//almacena el valor ingresado de temperatura en la variable v
       
        //El bucle do while nos va a permitir seguir preguntando si se ingresa un valor distinto de s o n 
         do{
           a1 = JOptionPane.showInputDialog("Si detecta gas , digite s: "+"\n"+"Si no detecta gas , digite n:");
           SensorGas=a1.charAt(0);//almacena el valor ingresado del sensor de gas si esta activado o no 
           //La sentencia if nos va notificar un error si ingresamos un dato incorrecto y nos preguntara de nuevo para el ingreso de s y n 
           if(SensorGas != 's'&& SensorGas !=  'n'){
               JOptionPane.showMessageDialog(null,"¡Dato ingresado no valido!");
               a1 = JOptionPane.showInputDialog("Si detecta gas , digite s: "+"\n"+"Si no detecta gas , digite n:");
               SensorGas=a1.charAt(0);
           }
        }while(SensorGas != 's'&& SensorGas !=  'n');//fin del bucle do-while
         
        //El bucle do while nos va a permitir seguir preguntando si se ingresa un valor distinto de s o n 
        do{
            a2 = JOptionPane.showInputDialog("Si detecta humo , digite s: "+"\n"+"Si no detecta humo , digite n:");
            SensorHumo=a2.charAt(0);//almacena el valor ingresado del sensor de humo si esta activado o no 
           //La sentencia if nos va notificar un error si ingresamos un dato incorrecto y nos preguntara de nuevo para el ingreso de s y n 
           if(SensorHumo != 's'&& SensorHumo !=  'n'){
            JOptionPane.showMessageDialog(null,"¡Dato ingresado no valido!");
            a2 = JOptionPane.showInputDialog("Si detecta humo , digite s: "+"\n"+"Si no detecta humo , digite n:");
            SensorHumo=a2.charAt(0);
           }
        }while(SensorHumo != 's' && SensorHumo != 'n');//fin del bucle do-while
        
        
        //Proceso de la activacion o no activacion de la alarma de incendios//
        
        //La sentencia if-else nos va permitir analizar el caso de que la temperatura sea mayor que 60°
         if(T>60){
             JOptionPane.showMessageDialog(null," ¡ALARMA DE INCENDIOS ACTIVADA! ");  
         }
         //el else nos va a permitir analizar los casos donde la temperatura sea menor que 60
         else{
             // la sentencia if-else nos va apermitir evaluar el caso donde temperatura este entre 45 a 60 grados
             if(T<60 && T>45){
                //la sentencia if -else va a permitir determinar si la alarma se activa 
                //caso donde la alarma se activa si y solo el sensor de gas o de humo se activan o si ambos sensores se encuentran activados
                    if(SensorGas == 's' || SensorHumo=='s' || (SensorGas == 's' && SensorHumo=='s') ){
                        JOptionPane.showMessageDialog(null," ¡ALARMA DE INCENDIOS ACTIVADA! ");//nos muestra un mensaje si la alarma de incendios se activa 
                    }
                    else{
                        JOptionPane.showMessageDialog(null," ¡ALARMA DE INCENDIOS DESACTIVADA! ");//nos muestra un mensaje si la alarma de incendio no se activa
                    }
                 }
             else{
                    //caso donde la alarma se activa cuando la temperatura es menor a 45 y la alarma se activa si solo si el sensor de gas y de humo se encuentran activados
                    if(SensorGas == 's' && SensorHumo=='s'){
                        JOptionPane.showMessageDialog(null," ¡ALARMA DE INCENDIOS ACTIVADA! ");//nos muestra un mensaje si la alarma de incendios se activa 
                    }
                    else{
                        JOptionPane.showMessageDialog(null," ¡ALARMA DE INCENDIOS DESACTIVADA! ");//nos muestra un mensaje si la alarma de incendio no se activa
                    }//fin de la sentencia if-else
                }//fin de la sentencia  if-else
             
            }
            //fin de la sentencia if-else
        }
        // excepccion que debe tenr encuentra nuestro programa
        catch(NumberFormatException e){//no me permite el ingreso de otro tipo de dato
               JOptionPane.showMessageDialog(null, " ! DATO NO PERMITIDO ¡ ");//nos muestra un mensaje de que el dato ingresado no es correcto para la variable T
        } 
        catch(NullPointerException e){//me restringe de que se debe ingresar si o si un dato
               JOptionPane.showMessageDialog(null, " ! NO SE DIGITO NINGUN DATO ¡ ");//nos muestra un mensaje que nos dice que no se registro ningun ingreso de dato para la avariable T
        }
        finally{
                //el do-while nos va permitir restringir la entrada de datos solo para a y b
                do{
                opcion=JOptionPane.showInputDialog("¿DESEA REGRESAR AL PROGRAMA?"+"\n"+"¡Escoja a o b!"+"\n"+"a)SI"+"\n"+"b)NO").charAt(0);
                }while(opcion!='a' && opcion!='b');
                //fin de do-while
        }
        
        }while(opcion!='b'); //fin de do-while
        //nos muestra un mensaje que nos dice que el programa ha terminado 
        JOptionPane.showMessageDialog(null, " ! PROCESO TERMINADO ¡ "); 
         
    }
}

