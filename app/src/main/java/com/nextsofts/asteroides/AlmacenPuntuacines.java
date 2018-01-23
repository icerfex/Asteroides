package com.nextsofts.asteroides;

import java.util.Vector;

/**
 * Cabe destacar que esta clase es una clase abstracta osea un clase en donde se indican los metodos pero no se implementan
 * en este caso tbm se dise que los metodos son abstractos..................
 * esta clase pues sera implementada desde otras clases para fines de almacenar puntuacines
 * Created by ariel on 21-12-17.
 * Un interface en java no implementa sus metodos nunca los cuales siempre tienen que ser publicos
 * Para heredar de esta clase se va usar la palabra reservada implements
 *
 * Con esta clase lo que quiero es implemetar un clase padre que implemente eses metodos y asi esta clase herede
 * los atributos y medodos de la clase padre automaticamente bueno eso si son publicos.
 *
 * Cabe destacar que esta clase no se instancia
 *
 * En java no existe la multi herencia por ello la implmente trata de sustituirlo esto una clase puede heredar
 * de un clase padre o de muchos cosa que en java no se puede pero con implmente
 *
 * SUBCLASE
 *
 */
public interface AlmacenPuntuacines {

    public void guardarPuntuacion(int puntos,String nombre,long fecha);
    public Vector listaPuntuaciones(int cantidad);
}
