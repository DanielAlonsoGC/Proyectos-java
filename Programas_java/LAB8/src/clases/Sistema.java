/*UNMSM – Facultad de Ing. Electrónica y Eléctrica
Escuela Profesional de Ingeniería Electrónica
Curso: Programación Avanzada
Docente: Mg. Ávila López, B. Patricio
Estudiante: Gutierrez Castillon Daniel Alonso
Fecha: 28/12/2020
Laboratorio Calificado 07
Entradas:
*opc,valores daleatorios de los sensores.
Objetivos:
-Saber en que situaciones el sistema de riego actuara con determinadas caracteristicas
-Aprender el uso de clases y objetos 
-Afianzar los conocimientos de programacion orientada a objetos en java.
Restricciones:
_el sistema regara si y solo si cuando la tierra donde se encuentra la planta se encuentra seca y el deposito este lleno
_el sistema regara dia y noche todos los meses excepto en enero,febrero y marzo que solo regara de noche
 */
package clases;

import javax.swing.*;

/**
 *
 * @author Daniel
 */
public class Sistema {

    public static void main(String[] args) {
        int opc;//eleccion por si queremos obtener nuestras caracteristicas del sistema
        CelulaFotoelectrica miCelulaFotoelectrica = new CelulaFotoelectrica();//instaciamos el objeto CelulaFotoelectrica
        SensorDeposito miSensorDeposito = new SensorDeposito();//instaciamos el objeto SensorDeposito
        SensorHumedad miSensorHumedad = new SensorHumedad();//instaciamos el objeto SensorHumedad
        Mes elMes = new Mes();//instaciamos el objeto Mes
        do {//nos va permitir obtener nuevas caracteristicas del sistema
            //ESTABLECEMOS VALORES INICIALES ALEATORIOS DE CADA CLASE CREADA 
            elMes.setValorMes();//Invocamos el metodo getter del atributo ValorMes de la clase Mes
            elMes.setNombreMes();//Invocamos el metodo setter del atributo ValorMes de la clase Mes
            miCelulaFotoelectrica.setEstado();//Invocamos el metodo setter del atributo Estado de la clase CelulaFotoelectrica;
            miCelulaFotoelectrica.setNombreEstado();//Invocamos el metodo getter del atributo NombreEstado de la clase CelulaFotoelectrica;
            miSensorDeposito.setEstado();//Invocamos el metodo setter del atributo Estado de la clase SensorDeposito;
            miSensorDeposito.setNombreEstado();//Invocamos el metodo getter del atributo NombreEstado de la clase SensorDeposito;
            miSensorHumedad.setEstado();//Invocamos el metodo setter del atributo Estado de la clase SensorHumedad;
            miSensorHumedad.setNombreEstado();//Invocamos el metodo getter del atributo NombreEstado de la clase SensorHumedad;

            // MOSTRAR CARACTERISTAS DEL SISTEMA
            JOptionPane.showMessageDialog(null,
                    "-----------------------------------------------SISTEMA DE RIEGO AUTOMATIZADO------------------------------------------" + "\n"
                    + "CARACTERISTICAS DEL SISTEMA: " + "\n"
                    + "*HOY NOS ENCONTRAMOS EN EL MES DE : " + elMes.getNombreMes() + "\n"
                    + "*LA CELULA FOTOELECTRICA MARCA QUE ES DE : " + miCelulaFotoelectrica.getNombreEstado() + "\n"
                    + "*EL SENSOR DE DEPOSITO MARCA QUE EL DEPOSITO SE ENCUENTRA : " + miSensorDeposito.getNombreEstado() + "\n"
                    + "*EL SENSOR DE HUMEDAD MARCA QUE LA TIERRA DE LA PLANTA SE ENCUENTRA : " + miSensorHumedad.getNombreEstado(), "SISTEMA DE RIEGO AUTOMATIZADO", JOptionPane.INFORMATION_MESSAGE);
            //HACIENDO NUESTRO MAPA DE KARNAUGH y AGREGANDO LA CONDICION DE MES
            //HACEMOS LA RELACION LOGICA GRACIAS AL IF ELSE
            if (!miSensorDeposito.getEstado() && miSensorHumedad.getEstado()) {
                if (elMes.getValorMes() == 1 || elMes.getValorMes() == 2 || elMes.getValorMes() == 3) {
                    if (miCelulaFotoelectrica.getEstado()) {
                        JOptionPane.showMessageDialog(null, "SENSOR DE ACCIONADOR DE BOMBA : 'NO ACTIVADO'" + "\n" + "EL SISTEMA NO REGARA LA PLANTA", "SISTEMA DE RIEGO AUTOMATIZADO", JOptionPane.INFORMATION_MESSAGE);//MUESTRA QUE LA PLANTA NO SE REGARA

                    } else {
                        JOptionPane.showMessageDialog(null, "SENSOR DE ACCIONADOR DE BOMBA : 'ACTIVADO'" + "\n" + "EL SISTEMA REGARA LA PLANTA", "SISTEMA DE RIEGO AUTOMATIZADO", JOptionPane.INFORMATION_MESSAGE);//MUESTRA QUE LA PLANTA SE REGARA
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "SENSOR DE ACCIONADOR DE BOMBA : 'ACTIVADO'" + "\n" + "EL SISTEMA REGARA LA PLANTA", "SISTEMA DE RIEGO AUTOMATIZADO", JOptionPane.INFORMATION_MESSAGE);//MUESTRA QUE LA PLANTA SE REGARA
                }

            } else {

                JOptionPane.showMessageDialog(null, "SENSOR DE ACCIONADOR DE BOMBA : 'NO ACTIVADO'" + "\n" + "EL SISTEMA NO REGARA LA PLANTA", "SISTEMA DE RIEGO AUTOMATIZADO", JOptionPane.INFORMATION_MESSAGE);//MUESTRA QUE LA PLANTA SE NO REGARA

            }
            //nos permite decidir si queremos obtener otras caracteristicas de nuestro sistema    
            opc = JOptionPane.showConfirmDialog(null, "DESEA OBTENER OTRAS CARACTERISTICAS DEL SISTEMA?", "SISTEMA DE RIEGO AUTOMATIZADO", JOptionPane.INFORMATION_MESSAGE);
        } while (opc == 0);

    }
}
