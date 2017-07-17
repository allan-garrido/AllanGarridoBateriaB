package com.umg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alumno on 13/07/2017.
 */
public class Tienda {
    private String nombrecomercial;
    private String direccion;
    private int cantempleados;
    private String fechacreacion;
    private String especialidad;

    private List<Empleado> empleados;
    private List<Automovil> automoviles;

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void addEmpleado(Empleado tmpE) { empleados.add(tmpE);}

    public List<Automovil> getAutomoviles() {
        return automoviles;
    }

    public void setAutomoviles(List<Automovil> automoviles) {
        this.automoviles = automoviles;
    }

    public void addAutomovil(Automovil tmpA) { automoviles.add(tmpA); }

    public String getNombrecomercial() {
        return nombrecomercial;
    }

    public void setNombrecomercial(String nombrecomercial) {
        this.nombrecomercial = nombrecomercial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCantempleados() {
        return cantempleados;
    }

    public void setCantempleados(int cantempleados) {
        this.cantempleados = cantempleados;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Tienda(String nombrecomercial, String direccion, int cantempleados, String fechacreacion, String especialidad) {

        this.nombrecomercial = nombrecomercial;
        this.direccion = direccion;
        this.cantempleados = cantempleados;
        this.fechacreacion = fechacreacion;
        this.especialidad = especialidad;

        empleados = new ArrayList<>();
        automoviles = new ArrayList<>();
    }

    public Tienda() {
        empleados = new ArrayList<>();
        automoviles = new ArrayList<>();
    }

    public float edadpromedioempleados(String delcargo) {
        int cant=0;
        int sumaedades=0;

        for (Empleado etmp: empleados
             ) {
            if (etmp.getCargo().equalsIgnoreCase(delcargo)) {
                sumaedades+=etmp.getEdad();
                cant++;
            }
        }

        return  sumaedades/cant;
    }

    public List<Automovil> precioautomovil(String demarca) {
        List<Automovil> resultado = new ArrayList<>();

        for (Automovil atmp:automoviles
             ) {
            if(atmp.getMarca().equalsIgnoreCase(demarca)) {
                resultado.add(atmp);
            }
        }

        return resultado;
    }
}
