
package com.diplomado.bodegas.bl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomado.bodegas.dal.ProductosDal;
import com.diplomado.bodegas.dtos.ProductosDto;
import com.diplomado.bodegas.entity.ProductosEntity;
import com.diplomado.bodegas.globaldto.ResultadoDto;

@Service
public class ProductosBl {

	@Autowired
	private ProductosDal productosDal;
	@Autowired
	private ModelMapper mapper;
	
	public ResultadoDto<List<ProductosDto>> findAll(){
		try {
			var result = this.productosDal.findAll();
			List<ProductosDto> todosLosDatos = mapper.map(result, new TypeToken<List<ProductosDto>>() {
			}.getType());			
			
			return ResultadoDto.<List<ProductosDto>>ok(todosLosDatos);
			
		} catch (Exception e) {			
			return ResultadoDto.Falla(e);
		}
		
	}
	public ResultadoDto<ProductosDto> findById(long id){
		try {
			var result = this.productosDal.findById(id);
			ProductosDto resultado =  mapper.map(result, ProductosDto.class);
			return ResultadoDto.<ProductosDto>ok(resultado);
			
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
				
	}
	
	public ResultadoDto<ProductosDto> save(ProductosDto newProductos) {
		
		try {
			var entity = mapper.map(newProductos, ProductosEntity.class);
			entity.setId(0L);
			entity = this.productosDal.save(entity);
			return ResultadoDto.<ProductosDto>ok(mapper.map(entity, ProductosDto.class));	
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
		
	}
	public ResultadoDto<ProductosDto> update(ProductosDto productos) {
		try {
			var entity = mapper.map(productos, ProductosEntity.class);		
			entity = this.productosDal.update(entity);
			return ResultadoDto.<ProductosDto>ok( mapper.map(entity, ProductosDto.class));
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
		
	}
	
	public ResultadoDto delete(long id) {
		try {
			this.productosDal.delete(id);
			return ResultadoDto.ok(null);
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
		
	}	
	
}





