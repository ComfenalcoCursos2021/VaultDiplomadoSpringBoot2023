package com.diplomado.launch;

import com.diplomado.entidades.Arma;
import com.diplomado.inversion.YoControlo;

public class Main {

	public static void main(String[] args) {
		
		Arma arma = new Arma();
		
		new YoControlo().controlando(arma);
		
		System.out.println("Termino");

	}

}
