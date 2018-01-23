package com.nextsofts.asteroides;

import java.util.Vector;

/**
 * Esta clase lo qeu hace es ser la super clase de la clase AlmacenPuntuaciones por ende pasara
 * a heredar los atributos y medodos y por ende pues heredara un arreglo ya con datos.
 *
 * AlmacenPuntuacionesArray <---pasara por herencia a-->AlmacenPuntuaciones
 *
 * AlmacenPuntuacionsArray implements  Interface
 *        (padre)                       (hijo)
 *
 * Created by ariel on 21-12-17.
 */
public class AlmacenPuntuacionesArray implements AlmacenPuntuacines {

    public Vector<String> puntuaciones;

    public AlmacenPuntuacionesArray() {
        /*creamos la instancia de la coleccion Vector y calgamos de objetos String*/
        puntuaciones= new Vector<String>();
        puntuaciones.add("123000 Pepito Domingez");
        puntuaciones.add("111000 Pedro Martinez");
        puntuaciones.add("011000 Paco Pérez");
        puntuaciones.add("123400 Jose Pinto");
        puntuaciones.add("111200 Jony Quinaya");
        puntuaciones.add("011033 Ector Paco");
        puntuaciones.add("123080 Leo Soliz");
        puntuaciones.add("551000 Maria Jose");
        puntuaciones.add("011066 joaquin Guzman");
    }
    /*aki es en donde se implementa el primero de los metodos abstractos de la clase AlmacenPuntuacines*/
    public void guardarPuntuacion(int puntos,String nombre, long fecha) {
        puntuaciones.add(0, puntos + " "+ nombre);
    }
    /*Aqui se implementa el 2do metodo abstracto de la clase abstracto AlmacenPuntuaciones, el cual como
    * retorno devuelve el vector que acavamos de llenar arriva*/
    public Vector listaPuntuaciones(int cantidad) {
        return  puntuaciones;
    }
}
