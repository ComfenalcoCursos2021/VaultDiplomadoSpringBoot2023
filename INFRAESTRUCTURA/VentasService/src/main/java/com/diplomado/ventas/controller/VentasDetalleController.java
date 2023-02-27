



package com.diplomado.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diplomado.ventas.bl.VentasDetalleBl;
import com.diplomado.ventas.client.ProductosClient;
import com.diplomado.ventas.dtos.VentasDetalleDto;
import com.diplomado.ventas.globaldto.ResultadoDto;
import com.diplomado.ventas.model.ProductoModel;

@RestController
@RequestMapping("/ventasdetalle")
public class VentasDetalleController {

	@Autowired
	private VentasDetalleBl ventasdetalleBl;
	
	
	
	@GetMapping
	public ResultadoDto<List<VentasDetalleDto>> findAll(){
		return this.ventasdetalleBl.findAll();
	}
	@GetMapping("/byVenta/{idventa}")
	public ResultadoDto<List<VentasDetalleDto>> findByVentasId(@PathVariable long idventa){
		return this.ventasdetalleBl.findByVentasId(idventa);
	}
	@GetMapping("/{id}")
	public ResultadoDto<VentasDetalleDto> findById(@PathVariable long id){		
		return this.ventasdetalleBl.findById(id);
	}
	
	@PostMapping
	public ResultadoDto<VentasDetalleDto> save(@RequestBody VentasDetalleDto ventasdetalle){
		return this.ventasdetalleBl.save(ventasdetalle);
	}
	@PutMapping
	public ResultadoDto<VentasDetalleDto> update(@RequestBody VentasDetalleDto ventasdetalle){
		return this.ventasdetalleBl.update(ventasdetalle);
	}
	
	@DeleteMapping("/{id}")
	public ResultadoDto delete(@PathVariable long id){
		return this.ventasdetalleBl.delete(id);
		
	}
}




