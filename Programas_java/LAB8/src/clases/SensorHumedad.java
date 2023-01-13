/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Daniel
 */
public class SensorHumedad {

    private boolean estado;//variable para recibir un valor de true o false
    private String nombreEstado;//variable que nos va a permitir darle un nombre a lo que representa 0 y 1

    public void setEstado() {
        estado = Math.random() < 0.5;//asignacion de el valor de true o false aleatoriamente

    }

    public boolean getEstado() {

        return estado;//devolver el valor asigado aleatoriamente en la variable estado
    }

    public void setNombreEstado() {
        if (estado == true) {
            nombreEstado = "TIERRA SECA";//asigna un nombre a la variable nombreEstado cuando estado es igual a true
        }
        if (estado == false) {
            nombreEstado = "TIERRA HUMEDA";//asigna un nombre a la variables nombre Estado cuando estado es igual a false        
        }
    }

    public String getNombreEstado() {
        return nombreEstado;//devuelve el valor de la variable nombreEstado ya asignado
    }

}
