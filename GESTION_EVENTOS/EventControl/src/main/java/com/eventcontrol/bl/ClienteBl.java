package com.eventcontrol.bl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventcontrol.dal.ClienteDal;
import com.eventcontrol.dtos.ClienteDto;
import com.eventcontrol.entity.ClienteEntity;
import com.eventcontrol.globaldto.ResultadoDto;

@Service
public class ClienteBl {

	@Autowired
	private ClienteDal clienteDal;
	@Autowired
	private ModelMapper mapper;
	
	public ResultadoDto<List<ClienteDto>> findAll(){
		try {
			var result = this.clienteDal.findAll();
			var todosLosDatos = mapper.map(result, new TypeToken<List<ClienteDto>>() {
			}.getType());			
			
			return ResultadoDto.ok(todosLosDatos);
			
		} catch (Exception e) {			
			return ResultadoDto.Falla(e);
		}
		
	}
	public ResultadoDto<ClienteDto> findById(long id){
		try {
			var result = this.clienteDal.findById(id);
			var resultado =  mapper.map(result, ClienteDto.class);
			return ResultadoDto.ok(resultado);
			
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
				
	}
	
	public ResultadoDto<ClienteDto> save(ClienteDto newCliente) {
		
		try {
			var entity = mapper.map(newCliente, ClienteEntity.class);
			entity.setId(0L);
			entity = this.clienteDal.save(entity);
			return ResultadoDto.ok(mapper.map(entity, ClienteDto.class));	
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
		
	}
	public ResultadoDto<ClienteDto> update(ClienteDto cliente) {
		try {
			var entity = mapper.map(cliente, ClienteEntity.class);		
			entity = this.clienteDal.update(entity);
			return ResultadoDto.ok( mapper.map(entity, ClienteDto.class));
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
		
	}
	
	public ResultadoDto delete(long id) {
		try {
			this.clienteDal.delete(id);
			return ResultadoDto.ok(null);
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
		
	}
	
	
	
}
