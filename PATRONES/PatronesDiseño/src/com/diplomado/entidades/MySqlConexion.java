package com.diplomado.entidades;

import com.diplomado.fabrica.IConexion;

public class MySqlConexion implements IConexion {

	public String getConexion() {
		return "Conn::MySql";
	}
}
