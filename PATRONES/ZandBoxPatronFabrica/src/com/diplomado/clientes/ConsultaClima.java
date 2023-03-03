package com.diplomado.clientes;

import com.diplomado.clientes.impl.CaritaFeliz;
import com.diplomado.clientes.impl.Estrellita;
import com.diplomado.clientes.impl.Rayito;
import com.diplomado.clientes.interfaces.IConsultaClima;
import com.diplomado.main.Main;

public class ConsultaClima {

	
	
	public String getClima(String pais) {		
		IConsultaClima consuta = getAquienConsultar();		
		return consuta.ConsultaClima(pais);
		
	}
	
	private IConsultaClima getAquienConsultar() {
		if("ESTRELLITA".equals(Main.A_QUIEN)) {
			return new Estrellita();
		}
		if("RAYITO".equals(Main.A_QUIEN)) {
			return new Rayito();
		}
		if("CARITA".equals(Main.A_QUIEN)) {
			return new CaritaFeliz();
		}
		return null;
	}
	
}
