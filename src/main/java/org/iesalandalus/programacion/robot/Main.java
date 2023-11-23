//Adrián Visiedo Rodríguez

package org.iesalandalus.programacion.robot;

import org.iesalandalus.programacion.robot.modelo.*;
import org.iesalandalus.programacion.robot.vista.Consola;

import javax.naming.OperationNotSupportedException;

public class Main {

    private static ControladorRobot controladorRobot;

    public static void ejecutarOpcion(int opcion) throws OperationNotSupportedException {
        switch (opcion) {
            case 1 -> controlarRobotDefecto();
            case 2 -> controlarRobotZona();
            case 3 -> controlarRobotZonaOrientacion();
            case 4 -> controlarRobotZonaOrientacionCoordenada();
            case 5 -> ejecutarComando();
            default -> System.out.println("Comando erróneo introducido");
        }
    }

    public static void controlarRobotDefecto() {
        controladorRobot = new ControladorRobot(new Robot());
    }

    public static void controlarRobotZona() {
        Zona zona = Consola.elegirZona();
        controladorRobot = new ControladorRobot(new Robot(zona));
    }

    public static void controlarRobotZonaOrientacion() {
        Zona zona = Consola.elegirZona();
        Orientacion orientacion = Consola.elegirOrientacion();
        controladorRobot = new ControladorRobot(new Robot(zona, orientacion));
    }

    public static void controlarRobotZonaOrientacionCoordenada() {
        Zona zona = Consola.elegirZona();
        Consola.mostrarMenuOrientacion();
        Orientacion orientacion = Consola.elegirOrientacion();
        Coordenada coordenada = Consola.elegirCoordenada();
        controladorRobot = new ControladorRobot(new Robot(zona, orientacion, coordenada));
    }

    public static void ejecutarComando() throws OperationNotSupportedException {
        if (controladorRobot != null) {
            char comando = Consola.elegirComando();
            controladorRobot.ejecutar(comando);
        } else {
            System.out.println("No hay ningún robot para ejecutar comandos.");
        }
    }

    public static void main(String[] args) throws OperationNotSupportedException {
        int opcion;
        do {
            opcion = Consola.elegirOpcion();
            if (opcion != 6) {
                ejecutarOpcion(opcion);
                Consola.mostrarRobot(controladorRobot);
            }
        } while (opcion != 6);
        Consola.despedirse();
    }
}
