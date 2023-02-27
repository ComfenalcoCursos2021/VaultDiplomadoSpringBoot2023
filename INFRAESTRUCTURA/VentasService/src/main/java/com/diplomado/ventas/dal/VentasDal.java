


package com.diplomado.ventas.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomado.ventas.entity.VentasEntity;
import com.diplomado.ventas.repository.IVentasRepository;

@Service
public class VentasDal {
	@Autowired
	private IVentasRepository ventasRepository;

	public List<VentasEntity> findAll() {
		return this.ventasRepository.findAll();
	}

	public VentasEntity findById(long id) {
		return this.ventasRepository.findById(id).get();
	}

	public VentasEntity save(VentasEntity entity) {
		return this.ventasRepository.save(entity);
	}

	public VentasEntity update(VentasEntity entity)  {
		/*if(!this.ventasRepository.existsById(entity.getId())) {
			throw new Exception("No se encuentra");
		}*/
		
		return this.ventasRepository.findById(entity.getId())
				.map( x -> {
					x.setClientesId(entity.getClientesId());
					x.setNumero(entity.getNumero());
										
					return this.ventasRepository.save(x);
				}).get();
	}
	
	public void delete(long id) throws Exception {
		
		if(!this.ventasRepository.existsById(id)) {
			throw new Exception("El id ingresado no existe");
		}
		this.ventasRepository.deleteById(id);
	}
}




