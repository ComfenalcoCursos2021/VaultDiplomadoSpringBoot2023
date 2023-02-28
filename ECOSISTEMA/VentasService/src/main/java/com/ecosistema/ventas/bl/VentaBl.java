package com.ecosistema.ventas.bl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecosistema.ventas.dal.VentaDal;
import com.ecosistema.ventas.dto.VentaDto;
import com.ecosistema.ventas.entity.VentaEntity;
import com.ecosistema.ventas.globaldto.ResultadoDto;
import com.google.common.reflect.TypeToken;

@Service
public class VentaBl {

	@Autowired
	private VentaDal ventaDal;
	@Autowired
	private ModelMapper mapper;
	
	public ResultadoDto<List<VentaDto>> findAll(){
		try {
			var result = this.ventaDal.findAll();
			List<VentaDto> todosLosDatos = mapper.map(result, 
					new TypeToken<List<VentaDto>>() {
			}.getType());			
			
			return ResultadoDto.<List<VentaDto>>ok(todosLosDatos);
			
		} catch (Exception e) {			
			return ResultadoDto.Falla(e);
		}
		
	}
	public ResultadoDto<VentaDto> findById(long id){
		try {
			var result = this.ventaDal.findById(id);
			var resultado =  mapper.map(result, VentaDto.class);
			return ResultadoDto.<VentaDto>ok(resultado);
			
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
				
	}
	
	public ResultadoDto<VentaDto> save(VentaDto newVenta) {
		
		try {
			var entity = mapper.map(newVenta, VentaEntity.class);
			entity.setId(0L);
			entity = this.ventaDal.save(entity);
			return ResultadoDto.ok(mapper.map(entity, VentaDto.class));	
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
		
	}
	public ResultadoDto<VentaDto> update(VentaDto venta) {
		try {
			var entity = mapper.map(venta, VentaEntity.class);		
			entity = this.ventaDal.update(entity);
			return ResultadoDto.ok( mapper.map(entity, VentaDto.class));
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
		
	}
	
	public ResultadoDto<String> delete(long id) {
		try {
			this.ventaDal.delete(id);
			return ResultadoDto.ok(null);
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
		
	}
	
}
