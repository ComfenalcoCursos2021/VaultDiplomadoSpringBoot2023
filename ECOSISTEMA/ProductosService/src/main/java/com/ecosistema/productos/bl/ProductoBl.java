package com.ecosistema.productos.bl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecosistema.productos.dal.ProductoDal;
import com.ecosistema.productos.dto.ProductoDto;
import com.ecosistema.productos.entity.ProductoEntity;
import com.ecosistema.productos.globaldto.ResultadoDto;
import com.google.common.reflect.TypeToken;

@Service
public class ProductoBl {

	@Autowired
	private ProductoDal productoDal;
	@Autowired
	private ModelMapper mapper;
	
	public ResultadoDto<List<ProductoDto>> findAll(){
		try {
			var result = this.productoDal.findAll();
			List<ProductoDto> todosLosDatos = mapper.map(result, 
					new TypeToken<List<ProductoDto>>() {
			}.getType());			
			
			return ResultadoDto.<List<ProductoDto>>ok(todosLosDatos);
			
		} catch (Exception e) {			
			return ResultadoDto.Falla(e);
		}
		
	}
	public ResultadoDto<ProductoDto> findById(long id){
		try {
			var result = this.productoDal.findById(id);
			var resultado =  mapper.map(result, ProductoDto.class);
			return ResultadoDto.<ProductoDto>ok(resultado);
			
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
				
	}
	
	public ResultadoDto<ProductoDto> save(ProductoDto newProducto) {
		
		try {
			var entity = mapper.map(newProducto, ProductoEntity.class);
			entity.setId(0L);
			entity = this.productoDal.save(entity);
			return ResultadoDto.ok(mapper.map(entity, ProductoDto.class));	
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
		
	}
	public ResultadoDto<ProductoDto> update(ProductoDto producto) {
		try {
			var entity = mapper.map(producto, ProductoEntity.class);		
			entity = this.productoDal.update(entity);
			return ResultadoDto.ok( mapper.map(entity, ProductoDto.class));
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
		
	}
	
	public ResultadoDto<String> delete(long id) {
		try {
			this.productoDal.delete(id);
			return ResultadoDto.ok(null);
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
		
	}
	
}
