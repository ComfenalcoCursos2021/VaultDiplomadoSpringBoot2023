package com.diplomado.entidades;

import com.diplomado.anotaciones.CantidadEjecuciones;

public class Arma {

	@CantidadEjecuciones(cantidadVeces = 1)
	public void disparar() {
		System.out.println("pum!!");
	}
	
}
