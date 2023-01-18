package com.diplomado.inversion;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import com.diplomado.anotaciones.CantidadEjecuciones;
import com.diplomado.entidades.Arma;

public class YoControlo {

	private List<String> METODOS_NO_LLAMAR = 
			Arrays.asList(
					"notifyAll",
					"notify",
					"getClass",
					"hashCode",
					"toString",
					"equals",
					"wait");
	
	public void controlando(Arma arma) {
		final String className = arma.getClass().getName();
		
		try {
			
			final Method[] methods = Class.forName(className).getMethods();
			
			for (Method method : methods) {
				if(!METODOS_NO_LLAMAR.contains(method.getName())) {
					this.ejecutarMetodo(method, arma);
				}
			}
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void ejecutarMetodo(Method metodo, Arma arma) {		
		try {
			System.out.println("[Metodo -> " + metodo.getName() + "]");
			final CantidadEjecuciones cant = metodo.getAnnotation(CantidadEjecuciones.class);
			if(cant == null) {
				metodo.invoke(arma, (Object[]) null);				
			} else {
				for (int i = 0; i < cant.cantidadVeces(); i++) {
					metodo.invoke(arma, (Object[]) null);
				}
			}
			
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
