package com.umg;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("* * *  VENTA DE AUTOMOVILES  * * *");

        //creando tienda

        Tienda tienda = new Tienda();
        tienda.setNombrecomercial("Cofiño");
        tienda.setDireccion("Zona 5");
        tienda.setCantempleados(20);
        tienda.setFechacreacion("22/01/1980");
        tienda.setEspecialidad("sedanes");
        System.out.println(tienda.getNombrecomercial()+"\n"+
                tienda.getDireccion()+"\n"+
                tienda.getCantempleados()+"\n"+
                tienda.getFechacreacion()+"\n"+
                tienda.getEspecialidad()+"\n"
        );

        Empleado empleado1 = new Empleado();
        empleado1.setCargo("Director");
        empleado1.setEdad(40);
        empleado1.setExperiencia(15);
        empleado1.setNombre("Juan");
        tienda.addEmpleado(empleado1);

        Empleado empleado2 = new Empleado();
        empleado2.setCargo("Vendedor");
        empleado2.setEdad(25);
        empleado2.setExperiencia(5);
        empleado2.setNombre("Pedro");
        tienda.addEmpleado(empleado2);

        Empleado empleado3 = new Empleado();
        empleado3.setCargo("Secretaria");
        empleado3.setEdad(30);
        empleado3.setExperiencia(10);
        empleado3.setNombre("Angelica");
        tienda.addEmpleado(empleado3);

        Empleado empleado4 = new Empleado();
        empleado4.setCargo("Vendedor");
        empleado4.setEdad(40);
        empleado4.setExperiencia(20);
        empleado4.setNombre("Luis");
        tienda.addEmpleado(empleado4);

        Empleado empleado5 = new Empleado();
        empleado5.setCargo("Director");
        empleado5.setEdad(50);
        empleado5.setExperiencia(20);
        empleado5.setNombre("Luis");
        tienda.addEmpleado(empleado5);

        for (Empleado tmpE:tienda.getEmpleados()
             ) {
            System.out.println(tmpE.getNombre()+" "+
                                tmpE.getEdad()+" "+
                                tmpE.getCargo()+" "+
                                tmpE.getExperiencia());
        }
        System.out.println("\n");

        System.out.println("Promedio edad directores: "+tienda.edadpromedioempleados("director")+"\n");
        
        Automovil automovil1 = new Automovil();
        automovil1.setMarca("Toyota");
        automovil1.setAniofabricacion(2000);
        automovil1.setModelo("Corolla");
        automovil1.setPrecio(35000);
        tienda.addAutomovil(automovil1);
        
        Automovil automovil2 = new Automovil();
        automovil2.setMarca("Toyota");
        automovil2.setAniofabricacion(2005);
        automovil2.setModelo("yaris");
        automovil2.setPrecio(40000);
        tienda.addAutomovil(automovil2);
        
        Automovil automovil3 = new Automovil();
        automovil3.setMarca("Toyota");
        automovil3.setAniofabricacion(3037);
        automovil3.setModelo("Tundra");
        automovil3.setPrecio(350000);
        tienda.addAutomovil(automovil3);
        
        Automovil automovil4 = new Automovil();
        automovil4.setMarca("Mazda");
        automovil4.setAniofabricacion(2005);
        automovil4.setModelo("323");
        automovil4.setPrecio(45000);
        tienda.addAutomovil(automovil4);
        
        Automovil automovil5 = new Automovil();
        automovil5.setMarca("Mazda");
        automovil5.setAniofabricacion(2057);
        automovil5.setModelo("6");
        automovil5.setPrecio(580000);
        tienda.addAutomovil(automovil5);

        for (Automovil tmpA:tienda.getAutomoviles()
             ) {
            System.out.println(tmpA.getMarca()+" "+
                                tmpA.getModelo()+" "+
                                tmpA.getAniofabricacion()+" "+
                                tmpA.getPrecio());
        }
        System.out.println("\n");

        System.out.println("precio de todos los autos toyota");

        List<Automovil> toyotas = new ArrayList<>();

        toyotas = tienda.precioautomovil("toyota");

        for (Automovil tmpA:toyotas
             ) {
            System.out.println(tmpA.getModelo()+" "+tmpA.getAniofabricacion()+" "+tmpA.getPrecio());
        }
    }
}
