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
public class Mes {

    private int valorMes;//variable para recibir un valor del 1 al 12
    private String nombreMes;//variable que nos va a permitir darle un nombre a lo que representa 1 al 12

    public void setValorMes() {
        valorMes = (int) (Math.random() * 12 + 1);//asignacion de un valor del 1 al 12 aleatoriamente

    }

    public int getValorMes() {
        return valorMes;   //devolver el valor asigado aleatoriamente en la variable valorMes
    }

    public void setNombreMes() {
        //sentencia switch nos ´permite establecer un valor para la variable nombreMes segun la variable valorMes
        switch (valorMes) {
            case 1:
                nombreMes = "ENERO";
                break;
            case 2:
                nombreMes = "FEBRERO";
                break;
            case 3:
                nombreMes = "MARZO";
                break;
            case 4:
                nombreMes = "ABRIL";
                break;
            case 5:
                nombreMes = "MAYO";
                break;
            case 6:
                nombreMes = "JUNIO";
                break;
            case 7:
                nombreMes = "JULIO";
                break;
            case 8:
                nombreMes = "AGOSTO";
                break;
            case 9:
                nombreMes = "SETIEMBRE";
                break;
            case 10:
                nombreMes = "OCTUBRE";
                break;
            case 11:
                nombreMes = "NOVIEMBRE";
                break;
            case 12:
                nombreMes = "DICIEMBRE";
                break;

            default:
                break;
        }
    }

    public String getNombreMes() {

        return nombreMes;//devuelve el valor asiganado para la variable nombreMes
    }

}
