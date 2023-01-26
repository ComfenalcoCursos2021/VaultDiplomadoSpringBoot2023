package com.pos.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pos.entities.UnidadMedidaEntity;
import com.pos.repository.IUnidadMedidaRepository;

@Service
public class UnidadMedidaDal {
	@Autowired
	private IUnidadMedidaRepository unidadMedidaRepository;
	
	
	public List<UnidadMedidaEntity> findAll(){
		return this.unidadMedidaRepository.findAll();
	}
	
	public List<UnidadMedidaEntity> findAllPage(int page, int size){
		return this.unidadMedidaRepository.findAll(PageRequest.of(page, size)).getContent();
	}
	
	public UnidadMedidaEntity save(UnidadMedidaEntity nuevo) {
		return this.unidadMedidaRepository.save(nuevo);
	}
	
	public void delete(long idBorrar) throws Exception {
		if(!this.unidadMedidaRepository.existsById(idBorrar)) {
			throw new Exception("No se encuentra la unidad de medida con ese id");
		}
		this.unidadMedidaRepository.deleteById(idBorrar);
	}
	
	public UnidadMedidaEntity update(UnidadMedidaEntity actualizar) throws Exception {
		
		if(!this.unidadMedidaRepository.existsById(actualizar.getId())) {
			throw new Exception("No se encuentra la unidad de medida con ese id");
		}
		//return this.unidadMedidaRepository.save(actualizar);
		return this.unidadMedidaRepository.findById(actualizar.getId())
				.map( u -> {
					u.setDescripcion(actualizar.getDescripcion());
					return this.unidadMedidaRepository.save(u);
				}).get();
		
	}
}
