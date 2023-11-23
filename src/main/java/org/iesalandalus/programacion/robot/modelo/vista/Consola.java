//Adrián Visiedo Rodríguez

package org.iesalandalus.programacion.robot.modelo.vista;

import org.iesalandalus.programacion.robot.modelo.*;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
    private Consola() {

    }

    public static void mostrarMenuPrincipal() {
        System.out.println("Menú Principal:");
        System.out.println(" ");
        System.out.println("1. Controlar un robot por defecto");
        System.out.println("2. Indicar zona");
        System.out.println("3. Indicar zona y orientación");
        System.out.println("4. Indicar zona, orientación y coordenada inicial");
        System.out.println("5. Ejecutar comando");
        System.out.println("6. Salir");
    }

    public static int elegirOpcion() {
        int opcion;
        do {
            mostrarMenuPrincipal();
            System.out.print("Elige una opción: ");
            opcion = Entrada.entero();
        } while (opcion < 1 || opcion > 6);
        return opcion;
    }

    public static Zona elegirZona() {
        int ancho;
        int alto;
        do {
            System.out.print("Introduce el ancho de la zona: ");
            ancho = Entrada.entero();
            System.out.print("Introduce el alto de la zona: ");
            alto = Entrada.entero();
        } while (ancho <= 0 || alto <= 0);
        return new Zona(ancho,alto);
    }

    public static void mostrarMenuOrientacion() {
        System.out.println("Menú de Orientaciones:");
        System.out.println("1. Norte");
        System.out.println("2. Sur");
        System.out.println("3. Este");
        System.out.println("4. Oeste");

    }

    public static Orientacion elegirOrientacion() {
        int opcion;
        do {
            mostrarMenuOrientacion();
            System.out.print("Elige una orientación: ");
            opcion = Entrada.entero();
        } while (opcion < 1 || opcion > 4);
        return switch (opcion) {
            case 1 -> Orientacion.NORTE;
            case 2 -> Orientacion.SUR;
            case 3 -> Orientacion.ESTE;
            case 4 -> Orientacion.OESTE;
            default -> null;
        };
    }

    public static Coordenada elegirCoordenada() {
        System.out.print("Introduce la X de la coordenada: ");
        int x = Entrada.entero();
        System.out.print("Introduce la Y de la coordenada: ");
        int y = Entrada.entero();
        return new Coordenada(x, y);
    }

    public static char elegirComando() {
        System.out.print("Elige el comando a ejecutar: ");
        return Entrada.caracter();
    }

    public static void mostrarRobot(ControladorRobot robot) {
        if (robot != null) {
            System.out.println("Estado del Robot:");
            System.out.println(robot.getRobot());
        } else {
            System.out.println("El robot es nulo.");
        }
    }

    public static void despedirse() {
        System.out.println("¡Hasta luego! Gracias por usar nuestra aplicación.");
    }
}
