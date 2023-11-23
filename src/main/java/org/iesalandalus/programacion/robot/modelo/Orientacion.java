//Adrián Visiedo Rodríguez

package org.iesalandalus.programacion.robot.modelo;

public enum Orientacion {
    NORTE("Norte"),
    SUR("Sur"),
    ESTE("Este"),
    OESTE("Oeste"),
    NORESTE("Noreste"),
    NOROESTE("Noroeste"),
    SURESTE("Sureste"),
    SUROESTE("Suroeste");

    private final String cadenaMostrar;

    Orientacion(String nombre) {
        this.cadenaMostrar = nombre;
    }

    @Override
    public String toString() {
        return cadenaMostrar;
    }
}