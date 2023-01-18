package com.example.demo.entidades;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class OtraInyectada {

	private Injectada i;
	
	public OtraInyectada(Injectada a) {
		this.i = a;
	}
	public String getDate() {
		return "V2.0 -> " + (new Date()).toString();
	}
}
