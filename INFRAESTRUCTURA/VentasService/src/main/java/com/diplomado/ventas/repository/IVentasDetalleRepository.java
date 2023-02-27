



package com.diplomado.ventas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diplomado.ventas.entity.VentasDetalleEntity;

public interface IVentasDetalleRepository extends JpaRepository<VentasDetalleEntity, Long> {
	public List<VentasDetalleEntity> findByVentasId(long idVenta);
}



