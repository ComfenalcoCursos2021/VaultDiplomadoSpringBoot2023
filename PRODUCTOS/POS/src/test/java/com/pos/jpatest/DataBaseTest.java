package com.pos.jpatest;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.pos.entities.CategoriaEntity;
import com.pos.entities.ProductoEntity;
import com.pos.entities.UnidadMedidaEntity;
import com.pos.repository.ICategoriaRepository;
import com.pos.repository.IProductoRepository;
import com.pos.repository.IUnidadMedidaRepository;


@DataJpaTest
public class DataBaseTest {

	@Autowired
	private IUnidadMedidaRepository unidadRepo;
	@Autowired
	private ICategoriaRepository categoriaRepo;
	@Autowired 
	private IProductoRepository productoRepo;
	
	@Test
	public void whenFindUnidadMedidad_thenResultListUnidadMedida() {
		
		List<UnidadMedidaEntity> consultaBase = unidadRepo.findAll();		
		var  unidadGuardada = unidadRepo.save(UnidadMedidaEntity.builder().descripcion("Litro").build());		
		List<UnidadMedidaEntity> consulta = unidadRepo.findAll();		        
        Assertions.assertThat(unidadGuardada).isNotNull();
		Assertions.assertThat(consulta.size()).isEqualTo(consultaBase.size() + 1);		
	}
	@Test
	public void whenFindCategoria_thenResultListCategoria() {
		
		List<CategoriaEntity> consultaBase = categoriaRepo.findAll();		
		var  unidadGuardada = categoriaRepo.save(CategoriaEntity.builder().descripcion("Despensa").build());		
		List<CategoriaEntity> consulta = categoriaRepo.findAll();		        
        Assertions.assertThat(unidadGuardada).isNotNull();
		Assertions.assertThat(consulta.size()).isEqualTo(consultaBase.size() + 1);		
	}
	
	@Test
	public void whenFindProducto_thenResultListProducto() {
		
		List<ProductoEntity> consultaBase = productoRepo.findAll();		
		var  guardado = productoRepo.save(
				ProductoEntity.builder()				
				.categoria(CategoriaEntity.builder().id(1L).build())
				.unidadMedida(UnidadMedidaEntity.builder().id(1L).build())
				.descripcion("Arroz bla bla bla")
				.precio(5000d)
				.impuesto(0.19f)
				.nombre("Arroz")				
				.build());		
		List<ProductoEntity> consulta = productoRepo.findAll();		        
        Assertions.assertThat(guardado).isNotNull();
		Assertions.assertThat(consulta.size()).isEqualTo(consultaBase.size() + 1);		
	}
	
	@Test
	public void deleteAllData() {
		List<ProductoEntity> consultaBase = productoRepo.findAll();
		productoRepo.delete(ProductoEntity.builder().id(1L).build());
		categoriaRepo.delete(CategoriaEntity.builder().id(1L).build());
		unidadRepo.delete(UnidadMedidaEntity.builder().id(1L).build());
		List<ProductoEntity> consulta = productoRepo.findAll();	
		Assertions.assertThat(consulta.size()).isEqualTo(consultaBase.size() - 1);
	}
}
