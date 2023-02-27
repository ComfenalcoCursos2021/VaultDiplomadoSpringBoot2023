
package com.diplomado.ventas.bl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomado.ventas.dal.VentasDal;
import com.diplomado.ventas.dtos.VentasDto;
import com.diplomado.ventas.entity.VentasEntity;
import com.diplomado.ventas.globaldto.ResultadoDto;

@Service
public class VentasBl {

	@Autowired
	private VentasDal ventasDal;
	@Autowired
	private ModelMapper mapper;
	
	public ResultadoDto<List<VentasDto>> findAll(){
		try {
			var result = this.ventasDal.findAll();
			List<VentasDto> todosLosDatos = mapper.map(result, new TypeToken<List<VentasDto>>() {
			}.getType());			
			
			return ResultadoDto.<List<VentasDto>>ok(todosLosDatos);
			
		} catch (Exception e) {			
			return ResultadoDto.Falla(e);
		}
		
	}
	public ResultadoDto<VentasDto> findById(long id){
		try {
			var result = this.ventasDal.findById(id);
			VentasDto resultado =  mapper.map(result, VentasDto.class);
			return ResultadoDto.<VentasDto>ok(resultado);
			
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
				
	}
	
	public ResultadoDto<VentasDto> save(VentasDto newVentas) {
		
		try {
			var entity = mapper.map(newVentas, VentasEntity.class);
			entity.setId(0L);
			entity = this.ventasDal.save(entity);
			return ResultadoDto.<VentasDto>ok(mapper.map(entity, VentasDto.class));	
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
		
	}
	public ResultadoDto<VentasDto> update(VentasDto ventas) {
		try {
			var entity = mapper.map(ventas, VentasEntity.class);		
			entity = this.ventasDal.update(entity);
			return ResultadoDto.<VentasDto>ok( mapper.map(entity, VentasDto.class));
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
		
	}
	
	public ResultadoDto delete(long id) {
		try {
			this.ventasDal.delete(id);
			return ResultadoDto.ok(null);
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
		
	}	
	
}





