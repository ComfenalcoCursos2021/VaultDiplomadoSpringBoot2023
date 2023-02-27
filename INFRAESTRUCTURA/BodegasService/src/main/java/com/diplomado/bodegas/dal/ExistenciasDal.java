


package com.diplomado.bodegas.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomado.bodegas.entity.ExistenciasEntity;
import com.diplomado.bodegas.repository.IExistenciasRepository;

@Service
public class ExistenciasDal {
	@Autowired
	private IExistenciasRepository existenciasRepository;

	public List<ExistenciasEntity> findAll() {
		return this.existenciasRepository.findAll();
	}

	public ExistenciasEntity findById(long id) {
		return this.existenciasRepository.findById(id).get();
	}

	public ExistenciasEntity save(ExistenciasEntity entity) {
		return this.existenciasRepository.save(entity);
	}

	public ExistenciasEntity update(ExistenciasEntity entity)  {
		/*if(!this.existenciasRepository.existsById(entity.getId())) {
			throw new Exception("No se encuentra");
		}*/
		
		return this.existenciasRepository.findById(entity.getId())
				.map( x -> {
					x.setCantidad(entity.getCantidad());
					x.setExistenciascol(entity.getExistenciascol());
					x.setIdBodega(entity.getIdBodega());
					x.setIdProducto(entity.getIdProducto());
										
					return this.existenciasRepository.save(x);
				}).get();
	}
	
	public void delete(long id) throws Exception {
		
		if(!this.existenciasRepository.existsById(id)) {
			throw new Exception("El id ingresado no existe");
		}
		this.existenciasRepository.deleteById(id);
	}
}




