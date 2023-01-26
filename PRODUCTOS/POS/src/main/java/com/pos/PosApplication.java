package com.pos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;

import com.pos.entities.CategoriaEntity;
import com.pos.entities.ProductoEntity;
import com.pos.entities.UnidadMedidaEntity;
import com.pos.repository.ICategoriaRepository;
import com.pos.repository.IProductoRepository;
import com.pos.repository.IUnidadMedidaRepository;

@SpringBootApplication
public class PosApplication implements CommandLineRunner {

	@Autowired
	private IProductoRepository productoRepository;
	@Autowired
	private ICategoriaRepository categoriaRepository;
	@Autowired
	private IUnidadMedidaRepository unidadMedidaRepository;

	public static void main(String[] args) {
		SpringApplication.run(PosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// InitDB();
		//testPaginacion();
		System.out.println("TERMINO EL LINE RUNNER");
	}

	private void testPaginacion() {
		var consulta = unidadMedidaRepository.findAll(PageRequest.of(0, 3));
		consulta.stream().forEach(i -> System.out.println("-> " + i));
		System.out.println("--------------------------------");
		consulta = unidadMedidaRepository.findAll(PageRequest.of(1, 3));
		consulta.stream().forEach(i -> System.out.println("-> " + i));
	}

	private void InitDB() {
		var categoria = CategoriaEntity.builder().id(1L).descripcion("Categoria 1").build();
		var unidad = UnidadMedidaEntity.builder().id(1L).descripcion("Kilogramo").build();
		var producto = ProductoEntity.builder().id(1L).categoria(categoria).unidadMedida(unidad)
				.descripcion("Arroz bla bla bla").precio(5000d).impuesto(0.19f).nombre("Arroz").build();

		this.categoriaRepository.save(categoria);
		this.unidadMedidaRepository.save(unidad);
		this.productoRepository.save(producto);

		var productoConsultado = this.productoRepository.findById(1L).get();

		System.out.println(productoConsultado);
	}

}
