package com.diplomado.launch;

import com.diplomado.entidades.Conexion;
import com.diplomado.entidades.Vaso;
import com.diplomado.entidades.Vehiculo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Conexion conn = Conexion.create("root", "root", "test");
		
		
		
		
		System.out.println("Inventarios " + conn);		
		System.out.println("Empleados " + conn);
		
		
		System.out.println("Inventarios " + conn);		
		System.out.println("Empleados " + conn);
		
		conn.setDbName("test2");
		
		System.out.println("Inventarios " + conn);		
		System.out.println("Empleados " + conn);
		
		/*
		Vehiculo a1 = Vehiculo.create();		
		System.out.println(a1);
		Vehiculo b1 = Vehiculo.create();		
		System.out.println(b1);
		Vehiculo c1 = Vehiculo.create();		
		System.out.println(c1);*/
		
		
		
		
		
		
		
		
		/*
		Vaso v1 = new Vaso();
		v1.setCantidad(15);
		
		System.out.println(v1);
		
		Vaso v2 = new Vaso();
		v2.setCantidad(45);
		System.out.println(v2);
		
		//v1.setMaterial("MADERA");
		
		Vaso.MATERIAL = "MADERA";
		Vaso.MATERIAL = "cualquiera";
		
		Vaso v3 = new Vaso();
		
		System.out.println(v1 +" - "+ v2);
		System.out.println(v3);*/
		
		System.out.println("Termino!!");
	}

}
