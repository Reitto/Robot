//Adrián Visiedo Rodríguez

package org.iesalandalus.programacion.robot.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class ControladorRobot {
    Robot robot;

    public ControladorRobot(Robot robot) {
        Objects.requireNonNull(robot, "El robot no puede ser nulo.");
        try {
            this.robot = new Robot(robot.zona, robot.orientacion, robot.coordenada);
        } catch (NullPointerException e) {
            try {
                this.robot = new Robot(robot.zona, robot.orientacion);
            } catch (NullPointerException i) {
                this.robot = new Robot();
            }
        }
    }

    public Robot getRobot() {
        return new Robot(robot.getZona(), robot.getOrientacion(), robot.getCoordenada());
    }

    public void ejecutar(char comando) throws OperationNotSupportedException {
        switch (comando) {
            case 'A', 'a' -> robot.avanzar();
            case 'D', 'd' -> robot.girarALaDerecha();
            case 'I', 'i' -> robot.girarALaIzquierda();
            default -> throw new OperationNotSupportedException("Comando desconocido.");
        }

    }
}
