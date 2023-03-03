package com.diplomado.clientes.impl;

import com.diplomado.clientes.interfaces.IConsultaClima;

public class CaritaFeliz implements IConsultaClima{

	private String Key="KEY CARITA FELIZ";
	@Override
	public String ConsultaClima(String pais) {
		System.out.println("consultar city state");
		System.out.println("Conectando carita feliz "+ Key);
		return "CLIMA CARITA FELIZ";
	}

}
