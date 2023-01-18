package com.example.demo.propiedades;

import org.springframework.boot.context.properties.ConfigurationProperties;



@ConfigurationProperties(prefix="conexion")
public class ConexionProperties {

	private String user;
	private String password;
	private String dbName;
	private String motor;	
	
	
	public ConexionProperties(String user, String password, String dbName, String motor) {		
		this.user = user;
		this.password = password;
		this.dbName = dbName;
		this.motor = motor;
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
	public String getMotor() {
		return motor;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}
	
	
	
	
}
