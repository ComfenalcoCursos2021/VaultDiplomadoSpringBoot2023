
package com.diplomado.ventas.bl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomado.ventas.dal.VentasDetalleDal;
import com.diplomado.ventas.dtos.VentasDetalleDto;
import com.diplomado.ventas.entity.VentasDetalleEntity;
import com.diplomado.ventas.globaldto.ResultadoDto;

@Service
public class VentasDetalleBl {

	@Autowired
	private VentasDetalleDal ventasdetalleDal;
	@Autowired
	private ModelMapper mapper;
	
	public ResultadoDto<List<VentasDetalleDto>> findAll(){
		try {
			var result = this.ventasdetalleDal.findAll();
			List<VentasDetalleDto> todosLosDatos = mapper.map(result, new TypeToken<List<VentasDetalleDto>>() {
			}.getType());			
			
			return ResultadoDto.<List<VentasDetalleDto>>ok(todosLosDatos);
			
		} catch (Exception e) {			
			return ResultadoDto.Falla(e);
		}
		
	}
	public ResultadoDto<VentasDetalleDto> findById(long id){
		try {
			var result = this.ventasdetalleDal.findById(id);
			VentasDetalleDto resultado =  mapper.map(result, VentasDetalleDto.class);
			return ResultadoDto.<VentasDetalleDto>ok(resultado);
			
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
				
	}
	
	public ResultadoDto<VentasDetalleDto> save(VentasDetalleDto newVentasDetalle) {
		
		try {
			var entity = mapper.map(newVentasDetalle, VentasDetalleEntity.class);
			entity.setId(0L);
			entity = this.ventasdetalleDal.save(entity);
			return ResultadoDto.<VentasDetalleDto>ok(mapper.map(entity, VentasDetalleDto.class));	
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
		
	}
	public ResultadoDto<VentasDetalleDto> update(VentasDetalleDto ventasdetalle) {
		try {
			var entity = mapper.map(ventasdetalle, VentasDetalleEntity.class);		
			entity = this.ventasdetalleDal.update(entity);
			return ResultadoDto.<VentasDetalleDto>ok( mapper.map(entity, VentasDetalleDto.class));
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
		
	}
	
	public ResultadoDto delete(long id) {
		try {
			this.ventasdetalleDal.delete(id);
			return ResultadoDto.ok(null);
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
		
	}	
	
}





