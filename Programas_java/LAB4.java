/*UNMSM – Facultad de Ing. Electrónica y Eléctrica
Escuela Profesional de Ingeniería Electrónica
Curso: Programación Avanzada
Docente: Mg. Ávila López, B. Patricio
Estudiante: Gutierrez Castillon Daniel Alonso
Fecha: 23/11/2020
Laboratorio Calificado 04
Entradas:
Variable numeros para almacenar los datos ingresaos por el usuario
varible matriz para almacenar los valores ingresados de manera aleatoria
variable matriz1 para almacenar las parejas de numeros encontradas
Objetivos
Poder encontrar el pareja correcta de numero en tablero
Mostrar un mensaje de ganador  cuando el jugador encuentre todas las parejas de numeros
Poder contabilizar el numero de parejas encontradas en el juego 
Afianzar los conocimientos de los siguientes temas de resolución de problemas y el manejo de arreglos.
Restricciones:
Los numeros escojidos deben ser 8 para el juego y deben de estar entre 10 y 99
El numero quer interviene el juego no puede repetirse en el tablero mas de dos veces
Cuando el jugador gane el juego termina automaticamente
Si el jugador sale sin haber encontrado todas las parejas el jugador pierde
*/
package labo4gutierrez;
import javax.swing.*;
/**
 *
 * @author Daniel
 */
public class Labo4Gutierrez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //algoritmo//
        //definimos entradas y variables 
           int[] numeros=new int[8];//varible para almacenar los datos escojidos del 10 al 99 por el ussuario
           int[][] matriz=new int[4][4];//matriz para almacenar los datos ingresados al azar
           String [][] matriz1=new String[4][4];//matriz1 del tablero que nos sirve para ir almacenando conforme encontremos los valores adecuados
           String cadena="";//variable para mostrar los numeros que se encuentra cada vez que se seleccionamos una casilla 
           String cadena1="";//variable para que se muestre la matriz real donde se encuentra los numeros al descubierto 
           int aux,fila=5,colum=5,fila1=5,colum1=5,opc=0,cont=0,evento=0;
           int c0=0,c1=0,c2=0,c3=0,c4=0,c5=0,c6=0,c7=0;
           long inicio = System.currentTimeMillis();
           
         
            try{
            JOptionPane.showMessageDialog(null,"DIGITE 8 NUMEROS ENTEROS POSITIVOS DE 2 CIFRAS"," JUEGO DE PARES DE NUMEROS",JOptionPane.INFORMATION_MESSAGE);
            //sentencia for para poder ingresar datos  y poder almacenarlos en la variable numero
            for(int i=0;i<8;i++){
               
               numeros[i]=Integer.parseInt(JOptionPane.showInputDialog("DIGITE NUMERO"+" "+(i+1)+" "+"es:"));
               //sentencia if ´para que nos permita ingresar un nuevo dato si es que el valor ingresado anteriormente esta fuera del rango de 10 y 99
               if(numeros[i]<10 || numeros[i]>99 ){
                   numeros[i]=Integer.parseInt(JOptionPane.showInputDialog("ERROR!"+"\n"+" USTED DIGITO UN NUMERO FUERA DEL RANGO"+"\n"+"DIGITE NUMERO"+" "+(i+1)+" "+"es:"));
               }//fin de if
              
            }//fin de for
                      
 
        //Algoritmo para  crear una matriz 4x4 y llenar la matriz al azar con datos ingresados
           
            for(int i=0;i<4;i++){//for para crear las columnas de la matriz
                for(int j=0;j<4;j++){//for para crear las filas de la matriz
                   do{
                        aux=(int)(Math.random()*8+1)-1;//valores al azar entre 0 y 7
                        if(aux==0){
                            if(c0!=2){
                            matriz[i][j]=numeros[aux];//almacenamos el un valor de la variable numeros en la matriz creada
                            c0++; //contabilizamos el valor de almacenar en matriz que no se repita mas de dos veces
                            }
                        }
                        if(aux==1){
                            if(c1!=2){
                            matriz[i][j]=numeros[aux];//almacenamos el un valor de la variable numeros en la matriz creada
                            c1++;//contabilizamos el valor de almacenar en matriz que no se repita mas de dos veces
                            }
                        }
                       if(aux==2){
                            if(c2!=2){   
                            matriz[i][j]=numeros[aux];//almacenamos el un valor de la variable numeros en la matriz creada
                            c2++; //contabilizamos el valor de almacenar en matriz que no se repita mas de dos veces
                            }
                        }
                       if(aux==3){
                            if(c3!=2){   
                            matriz[i][j]=numeros[aux];//almacenamos el un valor de la variable numeros en la matriz creada
                            c3++;//contabilizamos el valor de almacenar en matriz que no se repita mas de dos veces
                            }
                        }
                       if(aux==4){
                            if(c4!=2){   
                            matriz[i][j]=numeros[aux];//almacenamos el un valor de la variable numeros en la matriz creada
                            c4++;//contabilizamos el valor de almacenar en matriz que no se repita mas de dos veces
                            }
                        }
                       if(aux==5){
                            if(c5!=2){  
                            matriz[i][j]=numeros[aux];//almacenamos el un valor de la variable numeros en la matriz creada
                            c5++;//contabilizamos el valor de almacenar en matriz que no se repita mas de dos veces
                            }
                        }
                       if(aux==6){
                            if(c6!=2){  
                            matriz[i][j]=numeros[aux];//almacenamos el un valor de la variable numeros en la matriz creada
                            c6++;//contabilizamos el valor de almacenar en matriz que no se repita mas de dos veces
                            }
                        }
                       if(aux==7){
                            if(c7!=2){
                            matriz[i][j]=numeros[aux];//almacenamos el un valor de la variable numeros en la matriz creada
                            c7++;//contabilizamos el valor de almacenar en matriz que no se repita mas de dos veces
                            }
                        }
                    
                    }while(matriz[i][j]==0);//si no se consigue el valor nos sigue iterando hasta que aux atrape el valor adecuado 
                   
                }
            }//fin del llenado de la matriz
            
        /*   //mostramos la matriz de llenado real
           for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                
                cadena1=cadena1+"[ "+matriz[i][j]+" ]"+" ";
               
                }
                cadena1=cadena1+" "+"\n";
            }
            JOptionPane.showMessageDialog(null,cadena1);
        */
            //mostramos la matriz incognita//
            for(int i=0;i<4;i++){//nos va apermitir recorrer las columnas 
                for(int j=0;j<4;j++){//nos vapermitir recorrer las filas 
                    
                matriz1[i][j]="b";//llenamos la matriz con incognita b
                cadena=cadena+"[ "+matriz1[i][j]+" ]"+" ";//nos permite mostrar los valores ingresados en forma de matriz
               
                }//fin de for
                cadena=cadena+" "+"\n";//concatenamos las filas de matriz
            }//fin de for
            
            JOptionPane.showMessageDialog(null,"TABLERO DE MEMORIA"+"\n"+cadena);//nos muestra en ventana el tablero de con los valores ocultos
            //fin de la matriz incognita
            
            
            do{
                //Algoritmo para encontar el numero de una casilla ingresando filas y columnas
                fila=Integer.parseInt((JOptionPane.showInputDialog(null,"N° Fila a buscar: "," JUEGO DE MEMORIA DE NUMEROS",
                           JOptionPane.PLAIN_MESSAGE,null,new Object[]{"Seleccionar","1","2","3","4"},"Seleccionar")).toString());
                fila=fila-1;//almacenamos el valor de la fila ingresada del numero a buscar

                colum=Integer.parseInt((JOptionPane.showInputDialog(null,"N° Columna a buscar: "," JUEGO DE MEMORIA DE NUMEROS",
                           JOptionPane.PLAIN_MESSAGE,null,new Object[]{"Seleccionar","1","2","3","4"},"Seleccionar")).toString());
                colum=colum-1;//almacenamos el valor de la columna ingresada del mnumero a buscar
                JOptionPane.showMessageDialog(null,"EL NUMERO QUE ENCONTRO SE ENCUENTRA EN LA CASILLA "+"[ "+(fila+1)+" ]"+"[ "+(colum+1)+" ]"+"\n"+"EL NUMERO QUE ENCONTRO ES: "+matriz[fila][colum]);

                //mostrar el numero al escojer filas y columnas
            
                matriz1[fila][colum]=Integer.toString(matriz[fila][colum]);//vamos a asignar el dato ingresado a una posicion de la matriz1
                cadena="";//actualizmos el valor de cadena a vacia
                for(int i=0;i<4;i++){
                    for(int j=0;j<4;j++){
                
                    
                    cadena=cadena+"[ "+matriz1[i][j]+" ]"+" ";//nos permite mostrar los valores ingresados en forma de matriz1

                    }
                    cadena=cadena+" "+"\n";//nos permite mostrar el tablero al haber buscado el dato ingresado 
                }
            
                JOptionPane.showMessageDialog(null,"TABLERO DE MEMORIA"+"\n"+cadena);//nos permite mostrar todo el tablero 
            
                //algoritmo para bucar la pareja de la casilla 
                fila1=Integer.parseInt((JOptionPane.showInputDialog(null,"N° Fila a buscar: "," JUEGO DE MEMORIA DE NUMEROS",
                       JOptionPane.PLAIN_MESSAGE,null,new Object[]{"Seleccionar","1","2","3","4"},"Seleccionar")).toString());//nos permite buscar el valor de fila de numero a buscar
                fila1=fila1-1;
                colum1=Integer.parseInt((JOptionPane.showInputDialog(null,"N° Columna a buscar: "," JUEGO DE MEMORIA DE NUMEROS",
                       JOptionPane.PLAIN_MESSAGE,null,new Object[]{"Seleccionar","1","2","3","4"},"Seleccionar")).toString());//nos permite buscar el valor de fila de numero a buscar
                colum1=colum1-1;
                JOptionPane.showMessageDialog(null,"EL NUMERO QUE ENCONTRO SE ENCUENTRA EN LA CASILLA "+"[ "+(fila1+1)+" ]"+"[ "+(colum1+1)+" ]"+"\n"+"EL NUMERO QUE ENCONTRO ES: "+matriz[fila1][colum1]); 
                
            
                matriz1[fila][colum]=Integer.toString(matriz[fila][colum]);
                matriz1[fila1][colum1]=Integer.toString(matriz[fila1][colum1]);
                cadena="";//actualizamos el valor de cadena a vacia 
                for(int i=0;i<4;i++){//nos vapermitir recorrer las columnas
                    for(int j=0;j<4;j++){//nos vapermitir recorrer las filas 
                
                    
                    cadena=cadena+"[ "+matriz1[i][j]+" ]"+" ";//se muestra en ventana el valor que encontramos 

                    }
                    cadena=cadena+" "+"\n";//muestra el tablero del juego
                }
            
                JOptionPane.showMessageDialog(null,"TABLERO DE MEMORIA"+"\n"+cadena);
                //condiciones que debe de cumplir cuando se encuentre el par o no
                //si se encuentra par ,mostrar un anuncio de pareja correcta y seguimos pidiendo ingreso de fila y columna
                if(matriz[fila][colum]==matriz[fila1][colum1]){
                JOptionPane.showMessageDialog(null,"USTED ENCONTRO UNA PAREJA CORRECTA DE NUMEROS");
                cadena="";
                for(int i=0;i<4;i++){
                        for(int j=0;j<4;j++){


                        cadena=cadena+"[ "+matriz1[i][j]+" ]"+" ";//se muestra en ventana el valor que encontramos

                        }
                        cadena=cadena+" "+"\n";//muestra el tablero de que f
                    }

                JOptionPane.showMessageDialog(null,"TABLERO DE MEMORIA"+"\n"+cadena);//muestra el tablero del juego
                cont++;
                //Le preguntamos al ususario si deseamos seguir jugando 
                opc=Integer.parseInt(JOptionPane.showInputDialog("DESEA SEGUIR JUGANDO?"+"\n"+"SI ,DIGITE NUMERO ENTERO DISTINTO DE 1"+"\n"+"NO,DIGITE 1"));
                }
                //CASO DEL QUE NO ENCUENTRE LA PAREJA CORRECTA
                else{
                JOptionPane.showMessageDialog(null,"NO ENCONTRO LA PAREJA DE NUEMROS CORRECTA");
                matriz1[fila][colum]="b";
                matriz1[fila1][colum1]="b";
                cadena="";
                for(int i=0;i<4;i++){
                        for(int j=0;j<4;j++){


                        cadena=cadena+"[ "+matriz1[i][j]+" ]"+" ";//se muestra en ventana el valor que encontramos


                        }
                        cadena=cadena+" "+"\n";//muestra el tablero del juego 
                    }

                JOptionPane.showMessageDialog(null,"TABLERO DE MEMORIA"+"\n"+cadena);
                opc=Integer.parseInt(JOptionPane.showInputDialog("DESEA SEGUIR JUGANDO?"+"\n"+"SI ,DIGITE NUMERO ENTERO DISTINTO DE 1"+"\n"+"NO,DIGITE 1"));

                }

                //condicion que se debe de dar cuando el usuario gana el juego 
                if(cont==8){
                opc=1;
                evento=1;//esta varible nos representa el cuando el usuario sale automaticamente al haber ganado el juego;
                }
            
            }while(opc!=1);//fin del Do-while que termina cuando el usurio digita 1
           
           long fin = System.currentTimeMillis();
           double tiempo = (double) ((fin - inicio)/1000); 
           if(evento==1){
            JOptionPane.showMessageDialog(null," !FIN DEL JUEGO¡" +"\n"+"! USTED GANO EL JUEGO ¡"+" EN " + tiempo +" SEGUNDOS"," JUEGO DE MEMORIA DE NUMEROS",JOptionPane.INFORMATION_MESSAGE);
           }
           if(opc==1){
            JOptionPane.showMessageDialog(null," !FIN DEL JUEGO¡" +"\n"+"! USTED PERDIO EL JUEGO ¡"+"\n"+" USTED ENCONTRO "+cont+" PAREJAS"+" EN " + tiempo +" SEGUNDOS"," JUEGO DE MEMORIA DE NUMEROS",JOptionPane.INFORMATION_MESSAGE);   
           }
           
           
           }
           catch(NumberFormatException e){//no me permite el ingreso de otro tipo de dato
               JOptionPane.showMessageDialog(null, " ! DATO NO PERMITIDO ¡ ");//nos muestra un mensaje de que el dato ingresado no es correcto para la variable T
           } 
           catch(NullPointerException e){//me restringe de que se debe ingresar si o si un dato
               JOptionPane.showMessageDialog(null," ! NO SE DIGITO NINGUN DATO ¡ ");//nos muestra un mensaje que nos dice que no se registro ningun ingreso de dato para la avariable T
           }
          

    }
}
