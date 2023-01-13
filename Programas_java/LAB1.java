/*UNMSM – Facultad de Ing. Electrónica y Eléctrica
Escuela Profesional de Ingeniería Electrónica
Curso: Programación Avanzada
Docente: Mg. Ávila López, B. Patricio
Estudiante: Gutierrez Castillon Daniel Alonso
Fecha: 26/10/2020
Laboratorio Calificado 01
Objetivo: Calculo de de diversos parametros en un Movimiento Parabolico.
Datos de entrada: velocidad,tiempo,angulo.
Restricciones: 
El valor de la velocidad ingresada no debe ser negativo
El valor del tiempo ingresado no debe ser negativo
El valor del angulo ingresado debe estar entre 0 y 90 grados
Para el calculo de los alcances horizontales y verticales en cierto instante de tiempo,el tiempo ingresado debe ser menor al tiempo de vuelo
Objetivos:
Poder determinar los diversos parametros que intervienen en un movimiento parabolico
Familiarizarnos con la programacion en Java 
Conocer diversos operadores,funciones,sentencias para el desarrollo de progrmas futuros 
*/
package labo01;

import java.util.Scanner;//importamos la clase scanner

/**
 *
 * @author Daniel
 */
public class Labo01 {

    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);//Definimos el nombre de nuestra varible de tipo scanner 
        final var g = 9.81;//creacion de la constante gravedad
            System.out.println("--------------------MOVIMIENTO PARABOLICO-------------------");//nos muestra el tema del programa
            
                //Pregunta al usuario para el ingreso de la velocidad con que fue lanzado el objeto
                System.out.println("Digite la velocidad con que fue lanzado el objeto :");
                var v = consola.nextFloat(); //almacena el valor ingresado de la velocidad en la variable v
                
                    //La sentencia if nos permite evaluar el valor velocidad ingresada si es menor a 0 o negativo
                    if (v < 0) {
                        //El bucle do while nos va a permitir seguir preguntando si se ingresa un valor de v menor a 0 o un valor negativo
                        do {
                            System.out.println("el valor de la velocidad digitada no valida,la velocidad ingrasada debe ser positiva");
                            System.out.println("Digite la velocidad con que fue lanzado el objeto :");//pregunta al usuario otra vez por haber ingresado un dato no valido
                            v = consola.nextFloat();//almacena y actualiza el valor reciente ingresado de v
                        } while (v < 0);
                        // Fin del bucle do while
                    }//Fin del If
                    
                //Pregunta al usuario para el ingreso del tiempo t en cada instante
                System.out.println("Digite el valor del tiempo   : ");
                var t = consola.nextFloat();//almacena el valor ingresado del tiempo en cierto instante en la variable t
                
                    //La sentencia if nos permite evaluar el valor del tiempo ingresado si es menor a 0 o negativo
                    if (t < 0) {
                        //El bucle do while nos va a permitir seguir preguntando si se ingresa un valor de t es menor a 0 o un valor negativo
                        do {
                            System.out.println("el valor del tiempo digitado no valido, el tiempo debe ser positivo");
                            System.out.println("Digite la tiempo en el instante a evaluar  :");//pregunta al usuario otra vez por haber ingresado un dato no valido
                            t = consola.nextFloat();//almacena y actualiza el valor reciente ingresado de t
                        } while (t < 0);
                        //Fin del Do while
                    }//Fin del If
                
                //Pregunta al usuario para el ingreso del angulo con que fue lanzado el objeto
                System.out.println("Digite el angulo con que fue lanzado el objeto :");
                var angle = consola.nextFloat();//almacena el valor ingresado del angulo con que fue lanzado en la variable angle
                
                    //La sentencia if nos permite evaluar el valor angulo ingresado es menor que 0° o mayor a 90°
                    if (angle <= 0 || angle >= 90) {
                        //El bucle do while nos va a permitir seguir preguntando si se ingresa un valor de angle que sea menor que 0° o mayor a 90°
                        do {
                            System.out.println("el valor de la angulo digitado no valido");
                            System.out.println("Digite el angulo con que fue lanzado el objeto entre 0 y 90 grados :");//pregunta al usuario otra vez por haber ingresado un dato no valido
                            angle = consola.nextFloat();//almacena y actualiza el valor reciente ingresado de angle
                        } while (angle <= 0 || angle >= 90);
                        //Fin del Do while
                    }//Fin del if

                //Mostraremos todos los datos de entrada adecuados ingresados por el usuario 
                
                System.out.println("---------------------------------------------------");
                System.out.println("LOS DATOS INGRESADOS POR EL USUARIO SON: ");
                System.out.println("la velocidad digitada es : " + v + " " + "m/s");
                System.out.println("el tiempo digitado es : " + t + " " + "s");
                System.out.println("el angulo digitado es : " + angle + " " + "°");
                
                //Proceso de calculo de los parametros del movimiento Parabolico  
                
                var angle_rad = Math.toRadians(angle);//conversion de grados sexagesimales a radianes ya que las funciones trigonometricos solo reciben angulos en radianes
                var x = v * Math.cos(angle_rad) * t;//calculo del alacance horizontal en un instante t
                var y = v * Math.sin(angle_rad) * t - 0.5 * g * Math.pow(t, 2);//calculo del alcance vertical en un instante t 
                var h_maxima = (Math.pow(v, 2) * Math.pow(Math.sin(angle_rad),2)) / (2 * g);//Calculo de la altura maxima que alcanza el objeto
                var t_maximo = (v * Math.sin(angle_rad)) / g;//calculo del tiempo que tarda el objeto en alcanzar la altura maxima 
                var x_maxima = (Math.pow(v, 2) * Math.sin(2 * angle_rad)) / g;//calculo del alcance horizontal maximo que el objeto alcanza
                var t_caida = (2 * v * Math.sin(angle_rad)) / g;//calculo del tiempo que tarda el objeto desde el momento que fue lanzado hasta su caida(tiempo de vuelo)
                
                //Mostrares los valores obtenidos del proceso de calculo
                
                /*La sentencia If-else nos va permitir mostrar los valores si cumple con que el tiempo de vuelo 
                es mayor al tiempo ingresado por el usuario*/
                
                if (t_caida > t) {
                        
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("El valor de la distancia horizontal(x) recorrida en t segundos es  : " + x + " m ");//muestra el valor del alacance horizontal en un instante t
                    System.out.println("El valor de la distancia vertical(y) recorrida en t segundos es : " + y + " m ");//muestra el valor del alcance vertical en un instante t 
                    System.out.println("El valor de la altura maxima es : " + h_maxima + " m ");//muestra el valor de la altura maxima que alcanza el objeto
                    System.out.println("El valor del tiempo de caida del objeto es : " + t_maximo + " s ");//muestra el valor del tiempo que tarda el objeto en alcanzar la altura maxima 
                    System.out.println("El valor de la alcance maximohorizontal  es : " + x_maxima + " m ");//muestra el valor alcance horizontal maximo que el objeto alcanza
                    System.out.println("El valor del tiempo de caida del objeto es : " + t_caida + " s ");//muestra el valor del tiempo que tarda el objeto desde el momento que fue lanzado hasta su caida(tiempo de vuelo)

                } else {
                    //Nos muestra los valores obtenidos menos los valores de x y y ya que no es posible 
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("El valor de la distancia horizontal(x) y vertical(y) en t segundos no es posible debido a que el tiempo ingresado no puede ser mayor al tiempo total(vuelo)");//muestra un aviso que nos dice que los alcanzes horizontal y vertical en instantes t no es posible
                    System.out.println("El valor de la altura maxima es : " + h_maxima + " m ");//muestra el valor de la altura maxima que alcanza el objeto
                    System.out.println("El valor del tiempo de caida del objeto es : " + t_maximo + " s ");//muestra el valor del tiempo que tarda el objeto en alcanzar la altura maxima
                    System.out.println("El valor de la alcance maximohorizontal  es : " + x_maxima + " m ");//muestra el valor alcance horizontal maximo que el objeto alcanza
                    System.out.println("El valor del tiempo de caida del objeto es : " + t_caida + " s ");//muestra el valor del tiempo que tarda el objeto desde el momento que fue lanzado hasta su caida(tiempo de vuelo)
                    
                }
                //Fin de la sentencia If-else
    }

}
