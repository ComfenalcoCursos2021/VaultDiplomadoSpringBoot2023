
package com.diplomado.ventas.bl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import com.diplomado.ventas.client.ProductosService;
import com.diplomado.ventas.dal.VentasDetalleDal;
import com.diplomado.ventas.dtos.VentasDetalleDto;
import com.diplomado.ventas.entity.VentasDetalleEntity;
import com.diplomado.ventas.globaldto.ResultadoDto;
import com.diplomado.ventas.model.ProductoModel;

@Service
public class VentasDetalleBl {

	@Autowired
	private VentasDetalleDal ventasdetalleDal;
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ProductosService productosService;
	
	
		
	public ResultadoDto<List<VentasDetalleDto>> findAll(){
		try {
			var result = this.ventasdetalleDal.findAll();
			List<VentasDetalleDto> todosLosDatos = mapper.map(result, new TypeToken<List<VentasDetalleDto>>() {
			}.getType());			
			todosLosDatos = todosLosDatos.stream().map(x ->  {				
				ProductoModel producto = this.productosService.getProductoById(x.getProductosId());				
				x.setProducto(producto);
				return x;
				}).collect(Collectors.toList());
			return ResultadoDto.<List<VentasDetalleDto>>ok(todosLosDatos);
			
		} catch (Exception e) {			
			return ResultadoDto.Falla(e);
		}
		
	}
	
	
	public ResultadoDto<List<VentasDetalleDto>> findByVentasId(long id){
		try {
			var result = this.ventasdetalleDal.findByVentasId(id);
			List<VentasDetalleDto> todosLosDatos = mapper.map(result, new TypeToken<List<VentasDetalleDto>>() {
			}.getType());			
			todosLosDatos = todosLosDatos.stream().map(x ->  {
				
				ProductoModel producto = this.productosService.getProductoById(x.getProductosId());
				
				x.setProducto(producto);
				return x;
				}).collect(Collectors.toList());
			return ResultadoDto.<List<VentasDetalleDto>>ok(todosLosDatos);
			
		} catch (Exception e) {			
			return ResultadoDto.Falla(e);
		}		
	}
	
	
	
	public ResultadoDto<VentasDetalleDto> findById(long id){
		try {
			var result = this.ventasdetalleDal.findById(id);
			VentasDetalleDto resultado =  mapper.map(result, VentasDetalleDto.class);
			resultado.setProducto(this.productosService.getProductoById(resultado.getProductosId()));
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





