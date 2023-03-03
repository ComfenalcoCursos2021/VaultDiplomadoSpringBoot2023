package com.diplomado.clientes.impl;

import com.diplomado.clientes.interfaces.IConsultaClima;

public class Rayito implements IConsultaClima {

	private String Key1="KEY_RAYITO1";
	private String Key2="KEY_RAYITO2";
	@Override
	public String ConsultaClima(String pais) {
		System.out.println("Consultar en base de datos el city y state");
		System.out.println("conectarnos " + Key1 +"<---->"+Key2);
		return "Clima rayiyo";
	}

}
