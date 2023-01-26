package com.pos.bl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.dal.UnidadMedidaDal;
import com.pos.dtos.UnidadMedidaDto;
import com.pos.entities.UnidadMedidaEntity;

@Service
public class UnidadMedidaBl {

	@Autowired
	private UnidadMedidaDal unidadMedidaDal;
	@Autowired
	private ModelMapper mapper;

	public List<UnidadMedidaDto> findAll() {
		var lista = this.unidadMedidaDal.findAll();
		return mapper.map(lista, new TypeToken<List<UnidadMedidaEntity>>() {
		}.getType());
	}

	public List<UnidadMedidaDto> findAll(int page, int size) {
		var lista = this.unidadMedidaDal.findAllPage(page, size);
		return mapper.map(lista, new TypeToken<List<UnidadMedidaEntity>>() {
		}.getType());
	}

	public UnidadMedidaDto save(UnidadMedidaDto nuevo) {
		nuevo.setId(0L);
		return mapper.map(this.unidadMedidaDal.save(mapper.map(nuevo, UnidadMedidaEntity.class)),
				UnidadMedidaDto.class);
	}
	
	public UnidadMedidaDto update(UnidadMedidaDto nuevo) throws Exception {
		return mapper.map(this.unidadMedidaDal.update(mapper.map(nuevo, UnidadMedidaEntity.class)),
				UnidadMedidaDto.class);
	}
	
	public boolean delete(long id) {		
		try {
			this.unidadMedidaDal.delete(id);
		} catch (Exception e) {
			return false;
		}		
		return true;
	}
}
