package com.umg;

/**
 * Created by alumno on 13/07/2017.
 */
public class Automovil {
    private String marca; //TOYOTA MAZDA
    private int aniofabricacion;
    private String modelo;  // YARIS COROLLA
    private float precio;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAniofabricacion() {
        return aniofabricacion;
    }

    public void setAniofabricacion(int aniofabricacion) {
        this.aniofabricacion = aniofabricacion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Automovil(String marca, int aniofabricacion, String modelo, float precio) {

        this.marca = marca;
        this.aniofabricacion = aniofabricacion;
        this.modelo = modelo;
        this.precio = precio;
    }

    public Automovil() {

    }
}
