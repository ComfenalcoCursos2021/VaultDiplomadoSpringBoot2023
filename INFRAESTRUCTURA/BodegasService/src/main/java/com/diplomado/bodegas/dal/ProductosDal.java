


package com.diplomado.bodegas.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomado.bodegas.entity.ProductosEntity;
import com.diplomado.bodegas.repository.IProductosRepository;

@Service
public class ProductosDal {
	@Autowired
	private IProductosRepository productosRepository;

	public List<ProductosEntity> findAll() {
		return this.productosRepository.findAll();
	}

	public ProductosEntity findById(long id) {
		return this.productosRepository.findById(id).get();
	}

	public ProductosEntity save(ProductosEntity entity) {
		return this.productosRepository.save(entity);
	}

	public ProductosEntity update(ProductosEntity entity)  {
		/*if(!this.productosRepository.existsById(entity.getId())) {
			throw new Exception("No se encuentra");
		}*/
		
		return this.productosRepository.findById(entity.getId())
				.map( x -> {
					x.setNombre(entity.getNombre());
					x.setPrecioCosto(entity.getPrecioCosto());
					x.setPrecioVenta(entity.getPrecioVenta());
										
					return this.productosRepository.save(x);
				}).get();
	}
	
	public void delete(long id) throws Exception {
		
		if(!this.productosRepository.existsById(id)) {
			throw new Exception("El id ingresado no existe");
		}
		this.productosRepository.deleteById(id);
	}
}




