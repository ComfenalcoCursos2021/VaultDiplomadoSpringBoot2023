
package com.diplomado.ventas.bl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomado.ventas.dal.ClientesDal;
import com.diplomado.ventas.dtos.ClientesDto;
import com.diplomado.ventas.entity.ClientesEntity;
import com.diplomado.ventas.globaldto.ResultadoDto;

@Service
public class ClientesBl {

	@Autowired
	private ClientesDal clientesDal;
	@Autowired
	private ModelMapper mapper;
	
	public ResultadoDto<List<ClientesDto>> findAll(){
		try {
			var result = this.clientesDal.findAll();
			List<ClientesDto> todosLosDatos = mapper.map(result, new TypeToken<List<ClientesDto>>() {
			}.getType());			
			
			return ResultadoDto.<List<ClientesDto>>ok(todosLosDatos);
			
		} catch (Exception e) {			
			return ResultadoDto.Falla(e);
		}
		
	}
	public ResultadoDto<ClientesDto> findById(long id){
		try {
			var result = this.clientesDal.findById(id);
			ClientesDto resultado =  mapper.map(result, ClientesDto.class);
			return ResultadoDto.<ClientesDto>ok(resultado);
			
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
				
	}
	
	public ResultadoDto<ClientesDto> save(ClientesDto newClientes) {
		
		try {
			var entity = mapper.map(newClientes, ClientesEntity.class);
			entity.setId(0L);
			entity = this.clientesDal.save(entity);
			return ResultadoDto.<ClientesDto>ok(mapper.map(entity, ClientesDto.class));	
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
		
	}
	public ResultadoDto<ClientesDto> update(ClientesDto clientes) {
		try {
			var entity = mapper.map(clientes, ClientesEntity.class);		
			entity = this.clientesDal.update(entity);
			return ResultadoDto.<ClientesDto>ok( mapper.map(entity, ClientesDto.class));
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
		
	}
	
	public ResultadoDto delete(long id) {
		try {
			this.clientesDal.delete(id);
			return ResultadoDto.ok(null);
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
		
	}	
	
}





