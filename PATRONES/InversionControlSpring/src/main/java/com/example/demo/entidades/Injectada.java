package com.example.demo.entidades;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class Injectada {

	private Date fecha;
	public Injectada() {
		fecha = new Date();
	}
	public String getDate() {
		return "V1.2 -> " + (fecha).toString();
	}
}
