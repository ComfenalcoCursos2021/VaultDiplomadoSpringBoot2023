package com.diplomado.entidades;

import java.util.Date;

public class Vehiculo {

	private static Vehiculo INSTANCE;
	
	public static Vehiculo create() {
		if(INSTANCE == null) {
			INSTANCE = new Vehiculo();
		}
		return INSTANCE;
	}
	
	private Date fecha;
	
	private Vehiculo() {
		this.fecha = new Date();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String toString() {
		return "["+fecha.toString()+"]";
	}
}
