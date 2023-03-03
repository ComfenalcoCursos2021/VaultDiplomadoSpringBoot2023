package com.diplomado.main;

import com.diplomado.clientes.ConsultaClima;

public class Main {
	public final static String A_QUIEN = "RAYITO";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConsultaClima clima = new ConsultaClima();
		System.out.println(clima.getClima("Colombia"));
	}

}
