
package com.diplomado.bodegas.bl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomado.bodegas.dal.BodegasDal;
import com.diplomado.bodegas.dtos.BodegasDto;
import com.diplomado.bodegas.entity.BodegasEntity;
import com.diplomado.bodegas.globaldto.ResultadoDto;

@Service
public class BodegasBl {

	@Autowired
	private BodegasDal bodegasDal;
	@Autowired
	private ModelMapper mapper;
	
	public ResultadoDto<List<BodegasDto>> findAll(){
		try {
			var result = this.bodegasDal.findAll();
			List<BodegasDto> todosLosDatos = mapper.map(result, new TypeToken<List<BodegasDto>>() {
			}.getType());			
			
			return ResultadoDto.<List<BodegasDto>>ok(todosLosDatos);
			
		} catch (Exception e) {			
			return ResultadoDto.Falla(e);
		}
		
	}
	public ResultadoDto<BodegasDto> findById(long id){
		try {
			var result = this.bodegasDal.findById(id);
			BodegasDto resultado =  mapper.map(result, BodegasDto.class);
			return ResultadoDto.<BodegasDto>ok(resultado);
			
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
				
	}
	
	public ResultadoDto<BodegasDto> save(BodegasDto newBodegas) {
		
		try {
			var entity = mapper.map(newBodegas, BodegasEntity.class);
			entity.setId(0L);
			entity = this.bodegasDal.save(entity);
			return ResultadoDto.<BodegasDto>ok(mapper.map(entity, BodegasDto.class));	
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
		
	}
	public ResultadoDto<BodegasDto> update(BodegasDto bodegas) {
		try {
			var entity = mapper.map(bodegas, BodegasEntity.class);		
			entity = this.bodegasDal.update(entity);
			return ResultadoDto.<BodegasDto>ok( mapper.map(entity, BodegasDto.class));
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
		
	}
	
	public ResultadoDto delete(long id) {
		try {
			this.bodegasDal.delete(id);
			return ResultadoDto.ok(null);
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
		
	}	
	
}





