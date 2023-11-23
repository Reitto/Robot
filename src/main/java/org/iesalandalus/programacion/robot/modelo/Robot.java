//Adrián Visiedo Rodríguez

package org.iesalandalus.programacion.robot.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Robot {
    Zona zona;
    Orientacion orientacion;
    Coordenada coordenada;

    public Robot() {
        setZona(new Zona());
        setOrientacion(Orientacion.NORTE);
        setCoordenada(zona.getCentro());
    }

    public Robot(Zona zona) {
        this();
        setZona(zona);
        setCoordenada(zona.getCentro());
    }

    public Robot(Zona zona, Orientacion orientacion) {
        setZona(zona);
        setOrientacion(orientacion);
        setCoordenada(zona.getCentro());
    }

    public Robot(Zona zona, Orientacion orientacion, Coordenada coordenada) {
        setZona(zona);
        setOrientacion(orientacion);
        setCoordenada(coordenada);
    }

    public Robot(Robot robot) {
        Objects.requireNonNull(robot, "El robot no puede ser nulo.");
        setZona(robot.zona);
        setOrientacion(robot.orientacion);
        setCoordenada(robot.coordenada);
    }

    public Zona getZona() {
        return zona;
    }

    private void setZona(Zona zona) {
        Objects.requireNonNull(zona, "La zona no puede ser nula.");
        this.zona = zona;
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    private void setOrientacion(Orientacion orientacion) {
        Objects.requireNonNull(orientacion, "La orientación no puede ser nula.");
        this.orientacion = orientacion;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    private void setCoordenada(Coordenada coordenada) {
        Objects.requireNonNull(coordenada, "La coordenada no puede ser nula.");
        if (!zona.pertenece(coordenada)) {
            throw new IllegalArgumentException("La coordenada no pertenece a la zona.");
        }
        this.coordenada = coordenada;
    }

    public void avanzar() throws OperationNotSupportedException {
        try {
            switch (orientacion) {
                case NORTE -> setCoordenada(new Coordenada(coordenada.x(), coordenada.y() + 1));
                case SUR -> setCoordenada(new Coordenada(coordenada.x(), coordenada.y() - 1));
                case ESTE -> setCoordenada(new Coordenada(coordenada.x() + 1, coordenada.y()));
                case OESTE -> setCoordenada(new Coordenada(coordenada.x() - 1, coordenada.y()));
                case NORESTE -> setCoordenada(new Coordenada(coordenada.x() + 1, coordenada.y() + 1));
                case NOROESTE -> setCoordenada(new Coordenada(coordenada.x() - 1, coordenada.y() + 1));
                case SURESTE -> setCoordenada(new Coordenada(coordenada.x() + 1, coordenada.y() - 1));
                case SUROESTE -> setCoordenada(new Coordenada(coordenada.x() - 1, coordenada.y() - 1));
            }
        } catch (IllegalArgumentException e) {
            throw new OperationNotSupportedException("No se puede avanzar, ya que se sale de la zona.");
        }
    }

    public void girarALaDerecha() {
        switch (orientacion) {
            case NORTE -> orientacion = Orientacion.NORESTE;
            case SUR -> orientacion = Orientacion.SUROESTE;
            case ESTE -> orientacion = Orientacion.SURESTE;
            case OESTE -> orientacion = Orientacion.NOROESTE;
            case SURESTE -> orientacion = Orientacion.SUR;
            case SUROESTE -> orientacion = Orientacion.OESTE;
            case NORESTE -> orientacion = Orientacion.ESTE;
            case NOROESTE -> orientacion = Orientacion.NORTE;
        }
    }

    public void girarALaIzquierda() {
        switch (orientacion) {
            case NORTE -> orientacion = Orientacion.NOROESTE;
            case SUR -> orientacion = Orientacion.SURESTE;
            case ESTE -> orientacion = Orientacion.NORESTE;
            case OESTE -> orientacion = Orientacion.SUROESTE;
            case SURESTE -> orientacion = Orientacion.ESTE;
            case SUROESTE -> orientacion = Orientacion.SUR;
            case NORESTE -> orientacion = Orientacion.NORTE;
            case NOROESTE -> orientacion = Orientacion.OESTE;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Robot robot)) return false;
        return Objects.equals(getZona(), robot.getZona()) && getOrientacion() == robot.getOrientacion() && Objects.equals(getCoordenada(), robot.getCoordenada());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getZona(), getOrientacion(), getCoordenada());
    }

    @Override
    public String toString() {
        return "Robot{" +
                "zona=" + zona +
                ", orientacion=" + orientacion +
                ", coordenada=" + coordenada +
                '}';
    }
}
