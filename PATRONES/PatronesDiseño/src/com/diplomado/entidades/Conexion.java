package com.diplomado.entidades;

public class Conexion {

	private static Conexion INSTANCE;
	private String user;
	private String password;
	private String dbName;
	
	public static Conexion create(String user, String password, String dbName) {
		
		if(INSTANCE == null) {
			INSTANCE = new Conexion();
		}	
		INSTANCE.setDbName(dbName);
		INSTANCE.setPassword(password);
		INSTANCE.setUser(user);
		return INSTANCE;
	}
	
	private Conexion() {
		
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	@Override
	public String toString() {
		return "Conexion [user=" + user + ", password=" + password + ", dbName=" + dbName + "]";
	}
	
	
}
