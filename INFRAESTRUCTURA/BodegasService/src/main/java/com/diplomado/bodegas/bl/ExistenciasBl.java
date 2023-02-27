
package com.diplomado.bodegas.bl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomado.bodegas.dal.ExistenciasDal;
import com.diplomado.bodegas.dtos.ExistenciasDto;
import com.diplomado.bodegas.entity.ExistenciasEntity;
import com.diplomado.bodegas.globaldto.ResultadoDto;

@Service
public class ExistenciasBl {

	@Autowired
	private ExistenciasDal existenciasDal;
	@Autowired
	private ModelMapper mapper;
	
	public ResultadoDto<List<ExistenciasDto>> findAll(){
		try {
			var result = this.existenciasDal.findAll();
			List<ExistenciasDto> todosLosDatos = mapper.map(result, new TypeToken<List<ExistenciasDto>>() {
			}.getType());			
			
			return ResultadoDto.<List<ExistenciasDto>>ok(todosLosDatos);
			
		} catch (Exception e) {			
			return ResultadoDto.Falla(e);
		}
		
	}
	public ResultadoDto<ExistenciasDto> findById(long id){
		try {
			var result = this.existenciasDal.findById(id);
			ExistenciasDto resultado =  mapper.map(result, ExistenciasDto.class);
			return ResultadoDto.<ExistenciasDto>ok(resultado);
			
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
				
	}
	
	public ResultadoDto<ExistenciasDto> save(ExistenciasDto newExistencias) {
		
		try {
			var entity = mapper.map(newExistencias, ExistenciasEntity.class);
			entity.setId(0L);
			entity = this.existenciasDal.save(entity);
			return ResultadoDto.<ExistenciasDto>ok(mapper.map(entity, ExistenciasDto.class));	
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
		
	}
	public ResultadoDto<ExistenciasDto> update(ExistenciasDto existencias) {
		try {
			var entity = mapper.map(existencias, ExistenciasEntity.class);		
			entity = this.existenciasDal.update(entity);
			return ResultadoDto.<ExistenciasDto>ok( mapper.map(entity, ExistenciasDto.class));
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
		
	}
	
	public ResultadoDto delete(long id) {
		try {
			this.existenciasDal.delete(id);
			return ResultadoDto.ok(null);
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
		
	}	
	
}





