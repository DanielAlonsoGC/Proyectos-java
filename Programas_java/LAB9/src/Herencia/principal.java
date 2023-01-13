/*UNMSM – Facultad de Ing. Electrónica y Eléctrica
Escuela Profesional de Ingeniería Electrónica
Curso: Programación Avanzada
Docente: Mg. Ávila López, B. Patricio
Estudiante: Gutierrez Castillon Daniel Alonso
Fecha: 11/01/2021
Laboratorio Calificado 10
Entradas:
-salario para vendedor y repartidor
-codigo para vendedor y repartidor 
-nombre para vendedor y repartidor
-zona para repartidor
-comision para vendedor
-plus para cendedor y repartidor
Objetivos
Familiarizarse con el maejo de ficheros 
Poder construir un sistema de ingreso de infromacion de personas y poder almacenarlo en un registro.
Poner en practica los conocimientos de Herencia asi como refrozar los conocimientos de POO.
Restricciones:
*Cuendo se ingresa el numero de empleados,el numero de vendedores debe ser menor que el numero de empleados
*El programa no permite ingresar mas empleados de lo que inicialmente se define tanto vendedores y repartidores

*/
package Herencia;
import javax.swing.*;
import java.io.*;
/**
 *
 * @author Daniel
 */
public class principal {
    public static void main(String[] args) {
        int opc,opc1,opc2,cont1=0,cont2=0,cont3=0;//variables de seleccion
        int cantidad,cantidad1 , cantidad2,salario_vendedor,salario_repartidor,edad_vendedor,edad_repartidor;//cariables par adarles al consturctor de vendedor
        String codigo_vendedor,nombre_vendedor,codigo_repartidor,nombre_repartidor;
        String zona_repartidor;//variable propia del repartidor
        double comision_vendedor;//varible propia del vendedor
        String cadena="",cadena1="",cadena2="",empleado="",reporte="",cadena3="",cadena4="",cadena5="",cadena6="";//variables para almacenar texto
         //creacion de objeto archivo
         FileWriter fichero = null;
         PrintWriter pw = null;//creacion de objeto para poder escribir en un archivo
         FileWriter fichero1 = null;
         PrintWriter pw1 = null;//creacion de objeto para poder escribir en un archivo
         int flag=0,flag1=0;//vaeibles para que no cuentas la seleccion de vendedore y repartidor cuando no encuentra opcion 
        
       
        try{
           
           opc = JOptionPane.showConfirmDialog(null, "¿DESEA REGISTRAR EMPLEADOS EN LA EMPRESA? ", "GESTION DE EMPLEADOS DE UNA EMPRESA", JOptionPane.INFORMATION_MESSAGE);//pregunta al usuario si desea registrar empleados
           
               
           
           if(opc==0){//
            do{
            cantidad=Integer.parseInt(JOptionPane.showInputDialog(null, "------------------INGRESE LA CANTIDAD DE EMPLEADOS ENTRE VENDEDORES Y REPARTIDORES QUE DESEA REGISTRAR-------------------------"+"\n", "GESTION DE EMPLEADOS DE UNA EMPRESA", JOptionPane.INFORMATION_MESSAGE));
            //pide al usuario que ingrese la cantidad de empleados que son vendedores
            cantidad1= Integer.parseInt(JOptionPane.showInputDialog(null, "INGRESE LA CANTIDAD DE VENDEDORES QUE DESEA REGISTRAR : "+"\n", "GESTION DE EMPLEADOS DE UNA EMPRESA", JOptionPane.INFORMATION_MESSAGE));
            //la sentencia do nos permite restringir la condicion de numero de empleados debe ser mayor a la de numero de vendedores
            do{
                if(cantidad1<0 || cantidad1>cantidad){
                cantidad1= Integer.parseInt(JOptionPane.showInputDialog(null,"DATO NO PERMITIDO INGRESE UN VALOR MENOR A "+cantidad+" Y MAYOR QUE 0" +"\n"+"INGRESE LA CANTIDAD DE VENDEDORES QUE DESEA REGISTRAR : "+"\n", "GESTION DE EMPLEADOS DE UNA EMPRESA", JOptionPane.INFORMATION_MESSAGE));
                }
            }while(cantidad1<0 || cantidad1>cantidad);
            //hallando la cantidad de repatidores
            cantidad2=cantidad-cantidad1;
            //muestra en pantalla la cantidad de vendedores y repartidores se le debe ingresar informacion
            JOptionPane.showMessageDialog(null,"DEBE INGRESAR INFORMACION DE :\n "+cantidad1+" VENDEDORES"+"  y  "+cantidad2+" REPARTIDORES");

            //creacion del vector objto vendedor
            Vendedor vendedores[] =new Vendedor[cantidad1]; 
            cantidad1=cantidad1-1;
            //creacion del vector objeto repartidor
            Repartidor repartidores[] =new Repartidor[cantidad2]; 
            cantidad2=cantidad2-1;
            //
              do{
                 empleado=(JOptionPane.showInputDialog(null,"SELECCIONE EMPLEADO A AÑADIR INFORMACIO ","GESTION DE EMPLEADOS DE UNA EMPRESA",JOptionPane.PLAIN_MESSAGE,null,new Object[]{"Seleccionar","Vendedor","Repartidor"},"Seleccionar empleado")).toString();

                 if(empleado=="Vendedor"){
                     if(cont1<=cantidad1){
                         codigo_vendedor=JOptionPane.showInputDialog(null, "INGRESE CODIGO DE VENDEDOR "+(cont1+1)+" :"+"\n", "GESTION DE EMPLEADOS DE UNA EMPRESA", JOptionPane.INFORMATION_MESSAGE);
                         nombre_vendedor=JOptionPane.showInputDialog(null, "INGRESE NOMBRE DE VENDEDOR "+(cont1+1)+" :"+"\n", "GESTION DE EMPLEADOS DE UNA EMPRESA", JOptionPane.INFORMATION_MESSAGE);
                         edad_vendedor=Integer.parseInt(JOptionPane.showInputDialog(null, "INGRESE EDAD DE VENDEDOR "+(cont1+1)+" :"+"\n", "GESTION DE EMPLEADOS DE UNA EMPRESA", JOptionPane.INFORMATION_MESSAGE));
                         do{//sentencia do while para la restriccion
                              if(edad_vendedor<18 || edad_vendedor>65){
                              edad_vendedor= Integer.parseInt(JOptionPane.showInputDialog(null,"DATO NO PERMITIDO INGRESE UN VALOR ENTRE 18 Y 65"+"\n", "GESTION DE EMPLEADOS DE UNA EMPRESA", JOptionPane.INFORMATION_MESSAGE));
                              }
                         }while(edad_vendedor<18 || edad_vendedor>65);
                         salario_vendedor=Integer.parseInt(JOptionPane.showInputDialog(null, "INGRESE SALARIO DE VENDEDOR "+(cont1+1)+" :"+"\n", "GESTION DE EMPLEADOS DE UNA EMPRESA", JOptionPane.INFORMATION_MESSAGE));
                         comision_vendedor=Double.parseDouble(JOptionPane.showInputDialog(null, "INGRESE COMISION DE VENDEDOR "+(cont1+1)+" :"+"\n", "GESTION DE EMPLEADOS DE UNA EMPRESA", JOptionPane.INFORMATION_MESSAGE));
                         //llamando constructor
                         vendedores[cont1] =new Vendedor(comision_vendedor, codigo_vendedor, salario_vendedor, nombre_vendedor, edad_vendedor);

                        //guardando los datos de cada vendedor
                         cadena=vendedores[cont1].getCodigo()+";"
                                +vendedores[cont1].getNombre()+";"
                                +vendedores[cont1].getEdad()+";"
                                +vendedores[cont1].getSalario()+";"
                                +empleado+";"
                                +vendedores[cont1].getComision()+";"
                                +"NULL";
                                //"La cantidad total de salario del vendedor(incluyendo plus si sea el caso): "+vendedores[cont1].aplicarPlusVendedor()+" soles de plus"+"\n"+"\n";
                         //contador
                         cadena3=vendedores[cont1].getCodigo()+";"
                                 +vendedores[cont1].getNombre()+";"
                                 +vendedores[cont1].getPlus()+";";
                         cont1=cont1+1;
                     }
                     else{
                         //muestra en pantalla quen no se permite mas vendedores
                         JOptionPane.showMessageDialog(null,"Seleccion no permitida , ingrese datos de REPARTIDOR");
                         flag=1;
                     }
                 }
                 if(empleado=="Repartidor"){
                     if(cont2<=cantidad2){
                      codigo_repartidor=JOptionPane.showInputDialog(null, "INGRESE CODIGO DE REPARTIDOR "+(cont2+1)+" :"+"\n", "GESTION DE EMPLEADOS DE UNA EMPRESA", JOptionPane.INFORMATION_MESSAGE);
                      nombre_repartidor=JOptionPane.showInputDialog(null, "INGRESE NOMBRE DE REPARTIDOR "+(cont2+1)+" :"+"\n", "GESTION DE EMPLEADOS DE UNA EMPRESA", JOptionPane.INFORMATION_MESSAGE);
                      edad_repartidor=Integer.parseInt(JOptionPane.showInputDialog(null, "INGRESE EDAD DE REPARTIDOR "+(cont2+1)+" :"+"\n", "GESTION DE EMPLEADOS DE UNA EMPRESA", JOptionPane.INFORMATION_MESSAGE));
                      do{
                              if(edad_repartidor<18 || edad_repartidor>65){
                              edad_repartidor= Integer.parseInt(JOptionPane.showInputDialog(null,"DATO NO PERMITIDO INGRESE UN VALOR ENTRE 18 Y 65"+"\n", "GESTION DE EMPLEADOS DE UNA EMPRESA", JOptionPane.INFORMATION_MESSAGE));
                              }
                         }while(edad_repartidor<18 || edad_repartidor>65);
                      salario_repartidor=Integer.parseInt(JOptionPane.showInputDialog(null, "INGRESE SALARIO DE REPARTIDOR "+(cont2+1)+" :"+"\n", "GESTION DE EMPLEADOS DE UNA EMPRESA", JOptionPane.INFORMATION_MESSAGE));
                      zona_repartidor=(JOptionPane.showInputDialog(null,"SELECCIONE ZONA DE TRABAJO DEL REPARTIDOR ","GESTION DE EMPLEADOS DE UNA EMPRESA ",JOptionPane.PLAIN_MESSAGE,null,new Object[]{"Seleccionar","Norte","Centro","Sur"},"Seleccionar zona")).toString();
                        //llamando metodo
                      repartidores[cont2] =new Repartidor(zona_repartidor, codigo_repartidor,salario_repartidor, nombre_repartidor,edad_repartidor);

                      //permite almacenar los datos en la variable cadena
                      cadena1=repartidores[cont2].getCodigo()+";"
                                     +repartidores[cont2].getNombre()+";"
                                     +repartidores[cont2].getEdad()+";"
                                     +repartidores[cont2].getSalario()+";"
                                     +empleado+";"
                                     +"NULL"+";"
                                     +repartidores[cont2].getZona();
                                //"La cantidad total de salario del repartidor(incluyendo plus si sea el caso): "+repartidores[cont2].aplicarPlusRepartidor()+" soles de plus"+"\n"+"\n";
                     cadena4=repartidores[cont2].getCodigo()+";"
                            +repartidores[cont2].getNombre()+";"
                            +repartidores[cont2].getPlus();
                     //contador

                      cont2=cont2+1;
                      }
                     else{
                         //muestra en pantalla quen no se permite mas repartidores
                     JOptionPane.showMessageDialog(null,"Seleccion no permitida , ingrese datos de VENDEDOR");
                     flag1=1;
                     }
                 }
                cont3=cont1+cont2;
                //escribir fichero empleados.txt

                 try
                 {
                 fichero = new FileWriter("empleados.txt");//crea un archivo llamado empleados.txt
                 pw = new PrintWriter(fichero);
                 if(empleado=="Vendedor"){//si se selecciona vendedor
                     if(flag!=1){
                         cadena5=cadena5+cont3+";"+cadena+"\n";//condicion para que me muestre parte del fichero
                     }

                    }
                 if(empleado=="Repartidor"){//si se selcciona repartidor
                     if(flag1!=1){
                       cadena5=cadena5+cont3+";"+cadena1+"\n";   
                     }


                    }
                 pw.println(cadena5);


                 } catch (Exception e) {
                 e.printStackTrace();
                 } finally {
                 try {
                 // Nuevamente se aprovecha el finally para asegurar que se cierra el fichero.
                 if (null != fichero)
                 fichero.close();
                 } catch (Exception e2) {
                 e2.printStackTrace();
                 }
                 }

                //final de la escritura del fichero empleados
                //-------inicio de fichero de planilla.txt
                try
                 {
                 fichero1 = new FileWriter("planilla.txt");
                 pw1 = new PrintWriter(fichero1);
                 if(empleado=="Vendedor"){//si se selecciona vendedor
                     if(flag!=1){
                        cadena6=cadena6+cont3+";"+cadena3+"\n"; 
                     }

                 }
                 if(empleado=="Repartidor"){//si se selcciona repartidor
                     if(flag1!=1){
                        cadena6=cadena6+cont3+";"+cadena4+"\n";  
                     }


                    }
                 pw1.println(cadena6);


                 } catch (Exception e) {
                 e.printStackTrace();
                 } finally {
                 try {
                 // Nuevamente se aprovecha el finally para asegurar que se cierra el fichero.
                 if (null != fichero1)
                 fichero1.close();
                 } catch (Exception e2) {
                 e2.printStackTrace();
                 }
                 }
                //final de fichero planilla.txt
                flag=0;
                flag1=0;
                }while(cont3<=cantidad-1);//nos permite porder salir del bucle cuando se completa el llenado de informacion de los empleados

               opc1= JOptionPane.showConfirmDialog(null, "¿DESEA REGISTRAR NUEVAMENTE A LOS EMPLEADO? ", "GESTION DE EMPLEADOS DE UNA EMPRESA", JOptionPane.INFORMATION_MESSAGE);//pregunta al usuario si desea registrar empleados
           }while(opc1==0);  
            }
          
           else{
               JOptionPane.showMessageDialog(null,"NO SE INGRESO INFORMACION DE NINGUN EMPLEADO");
           }
  
           
           
        }catch(NumberFormatException e){//no me permite el ingreso de otro tipo de dato
               JOptionPane.showMessageDialog(null, " ! DATO NO PERMITIDO ¡ ");//nos muestra un mensaje de que el dato ingresado no es correcto para la variable T
        } 
        catch(NullPointerException e){//me restringe de que se debe ingresar si o si un dato
               JOptionPane.showMessageDialog(null," ! NO SE DIGITO NINGUN DATO ¡ ");//nos muestra un mensaje que nos dice que no se registro ningun ingreso de dato para la avariable T
        }
         
         
       
    }
    
}
