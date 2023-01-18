package com.diplomado.entidades;

import com.diplomado.fabrica.IConexion;

public class SqlServerConexion implements IConexion{

	public String getConexion() {
		return "Conn::SqlServer";
	}
}
