package com.example.demo.conexiones;

public class SqlServerConexion implements IConexion{

	@Override
	public String getConexion() {
		return "CONEXION --.-.-.-.- DESDE SQL SERVER";
	}

}
