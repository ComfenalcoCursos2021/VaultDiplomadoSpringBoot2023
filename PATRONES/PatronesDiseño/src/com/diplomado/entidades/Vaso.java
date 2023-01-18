package com.diplomado.entidades;

public class Vaso {
	private int cantidad;
	public static String MATERIAL = "plastico";

	public Vaso() {		
	}	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}		
	@Override
	public String toString() {
		return "Vaso [cantidad=" + cantidad + ", material=" + MATERIAL + "]";
	}	
}
