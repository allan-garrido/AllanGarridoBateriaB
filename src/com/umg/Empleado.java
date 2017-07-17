package com.umg;

/**
 * Created by alumno on 13/07/2017.
 */
public class Empleado {
    private String nombre;
    private int edad;
    private int experiencia;
    private String cargo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Empleado(String nombre, int edad, int experiencia, String cargo) {

        this.nombre = nombre;
        this.edad = edad;
        this.experiencia = experiencia;
        this.cargo = cargo;
    }

    public Empleado() {

    }
}
