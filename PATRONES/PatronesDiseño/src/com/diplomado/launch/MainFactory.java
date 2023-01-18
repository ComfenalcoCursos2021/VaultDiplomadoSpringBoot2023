package com.diplomado.launch;

import com.diplomado.entidades.SqlServerConexion;
import com.diplomado.fabrica.Fabrica;
import com.diplomado.fabrica.IConexion;

public class MainFactory {

	//public static String MOTOR = "MySql";
	public static String MOTOR = "SqlServer";
	public static void main(String[] args) {

		IConexion conexion = Fabrica.getConn(MOTOR);

		// Inventarios
		System.out.println(conexion.getConexion());

		// Nomina
		conexion = Fabrica.getConn(MOTOR);
		System.out.println(conexion.getConexion());

		// Mercadeo
		conexion = Fabrica.getConn(MOTOR);
		System.out.println(conexion.getConexion());

		System.out.println("termino");
	}
}
