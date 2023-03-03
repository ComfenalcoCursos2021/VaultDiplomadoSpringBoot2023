package com.diplomado.clientes.impl;

import com.diplomado.clientes.interfaces.IConsultaClima;

public class Estrellita implements IConsultaClima{

	private String key="key estrellita"; 
	@Override
	public String ConsultaClima(String pais) {
		System.out.println("Conectando estrellita " + key);
		return "clima estrellita";
	}

}
