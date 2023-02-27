


package com.diplomado.ventas.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomado.ventas.entity.VentasDetalleEntity;
import com.diplomado.ventas.repository.IVentasDetalleRepository;

@Service
public class VentasDetalleDal {
	@Autowired
	private IVentasDetalleRepository ventasdetalleRepository;

	public List<VentasDetalleEntity> findAll() {
		return this.ventasdetalleRepository.findAll();
	}

	public VentasDetalleEntity findById(long id) {
		return this.ventasdetalleRepository.findById(id).get();
	}
	public List<VentasDetalleEntity> findByVentasId(long id) {
		return this.ventasdetalleRepository.findByVentasId(id);
	}
	public VentasDetalleEntity save(VentasDetalleEntity entity) {
		return this.ventasdetalleRepository.save(entity);
	}

	public VentasDetalleEntity update(VentasDetalleEntity entity)  {
		/*if(!this.ventasdetalleRepository.existsById(entity.getId())) {
			throw new Exception("No se encuentra");
		}*/
		
		return this.ventasdetalleRepository.findById(entity.getId())
				.map( x -> {
					x.setProductosId(entity.getProductosId());
					x.setVentasId(entity.getVentasId());
										
					return this.ventasdetalleRepository.save(x);
				}).get();
	}
	
	public void delete(long id) throws Exception {
		
		if(!this.ventasdetalleRepository.existsById(id)) {
			throw new Exception("El id ingresado no existe");
		}
		this.ventasdetalleRepository.deleteById(id);
	}
}




