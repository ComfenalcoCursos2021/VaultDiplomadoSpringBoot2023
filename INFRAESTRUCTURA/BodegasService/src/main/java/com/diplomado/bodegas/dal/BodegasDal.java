


package com.diplomado.bodegas.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomado.bodegas.entity.BodegasEntity;
import com.diplomado.bodegas.repository.IBodegasRepository;

@Service
public class BodegasDal {
	@Autowired
	private IBodegasRepository bodegasRepository;

	public List<BodegasEntity> findAll() {
		return this.bodegasRepository.findAll();
	}

	public BodegasEntity findById(long id) {
		return this.bodegasRepository.findById(id).get();
	}

	public BodegasEntity save(BodegasEntity entity) {
		return this.bodegasRepository.save(entity);
	}

	public BodegasEntity update(BodegasEntity entity)  {
		/*if(!this.bodegasRepository.existsById(entity.getId())) {
			throw new Exception("No se encuentra");
		}*/
		
		return this.bodegasRepository.findById(entity.getId())
				.map( x -> {
					x.setCapacidad(entity.getCapacidad());
					x.setCodigo(entity.getCodigo());
					x.setNombre(entity.getNombre());
										
					return this.bodegasRepository.save(x);
				}).get();
	}
	
	public void delete(long id) throws Exception {
		
		if(!this.bodegasRepository.existsById(id)) {
			throw new Exception("El id ingresado no existe");
		}
		this.bodegasRepository.deleteById(id);
	}
}




