package com.eventcontrol.bl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventcontrol.dal.ClienteDal;
import com.eventcontrol.dtos.ClienteDto;
import com.eventcontrol.entity.ClienteEntity;

@Service
public class ClienteBl {

	@Autowired
	private ClienteDal clienteDal;
	@Autowired
	private ModelMapper mapper;
	
	public List<ClienteDto> findAll(){
		var result = this.clienteDal.findAll();
		return mapper.map(result, new TypeToken<List<ClienteDto>>() {
		}.getType());
	}
	public ClienteDto findById(long id){
		var result = this.clienteDal.findById(id);
		return mapper.map(result, ClienteDto.class);		
	}
	
	public ClienteDto save(ClienteDto newCliente) {
		var entity = mapper.map(newCliente, ClienteEntity.class);
		entity.setId(0L);
		entity = this.clienteDal.save(entity);
		return mapper.map(entity, ClienteDto.class);
	}
	public ClienteDto update(ClienteDto cliente) {
		var entity = mapper.map(cliente, ClienteEntity.class);		
		entity = this.clienteDal.update(entity);
		return mapper.map(entity, ClienteDto.class);
	}
	
	public void delete(long id) {
		this.clienteDal.delete(id);
	}
	
	
	
}
