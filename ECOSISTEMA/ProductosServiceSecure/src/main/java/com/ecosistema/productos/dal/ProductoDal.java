package com.ecosistema.productos.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecosistema.productos.entity.ProductoEntity;
import com.ecosistema.productos.repositories.IProductoRepository;

@Service
public class ProductoDal {
	@Autowired
	private IProductoRepository productoRepository;

	public List<ProductoEntity> findAll() {
		return this.productoRepository.findAll();
	}

	public ProductoEntity findById(long id) {
		return this.productoRepository.findById(id).get();
	}

	public ProductoEntity save(ProductoEntity entity) {
		return this.productoRepository.save(entity);
	}

	public ProductoEntity update(ProductoEntity entity)  {		
		 
		return this.productoRepository.findById(entity.getId())
				.map( x -> {					
					x.setNombre(entity.getNombre());
					x.setPrecio(entity.getPrecio());
					return this.productoRepository.save(x);
				}).get();
	}
	
	public void delete(long id) throws Exception {
		
		if(!this.productoRepository.existsById(id)) {
			throw new Exception("El id ingresado no existe");
		}
		this.productoRepository.deleteById(id);
	}
}
