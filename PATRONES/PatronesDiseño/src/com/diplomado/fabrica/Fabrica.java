package com.diplomado.fabrica;

import com.diplomado.entidades.MySqlConexion;
import com.diplomado.entidades.SqlServerConexion;

public class Fabrica {

	public static IConexion getConn(String motor) {
		if(motor.toUpperCase().equals("MYSQL")) {
			return new MySqlConexion();
		}		
		return new SqlServerConexion();
	}
}
