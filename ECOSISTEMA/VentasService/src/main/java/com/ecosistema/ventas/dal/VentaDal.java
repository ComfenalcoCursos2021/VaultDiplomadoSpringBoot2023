package com.ecosistema.ventas.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecosistema.ventas.entity.VentaEntity;
import com.ecosistema.ventas.repositories.IVentaRepository;

@Service
public class VentaDal {
	@Autowired
	private IVentaRepository ventaRepository;

	public List<VentaEntity> findAll() {
		return this.ventaRepository.findAll();
	}

	public VentaEntity findById(long id) {
		return this.ventaRepository.findById(id).get();
	}

	public VentaEntity save(VentaEntity entity) {
		return this.ventaRepository.save(entity);
	}

	public VentaEntity update(VentaEntity entity)  {		
		 
		return this.ventaRepository.findById(entity.getId())
				.map( x -> {					
					x.setIdProducto(entity.getIdProducto());
					x.setNombreCliente(entity.getNombreCliente());
					x.setPrecioVenta(entity.getPrecioVenta());
					return this.ventaRepository.save(x);
				}).get();
	}
	
	public void delete(long id) throws Exception {
		
		if(!this.ventaRepository.existsById(id)) {
			throw new Exception("El id ingresado no existe");
		}
		this.ventaRepository.deleteById(id);
	}
}
