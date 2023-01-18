package com.example.demo.conexiones;

public class MySqlConexion implements IConexion {

	@Override
	public String getConexion() {
		return "CONEXION --.-.-.-.- DESDE MYSQL";
	}

}
