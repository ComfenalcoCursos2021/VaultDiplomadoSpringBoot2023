



package com.diplomado.bodegas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diplomado.bodegas.entity.ProductosEntity;

public interface IProductosRepository extends JpaRepository<ProductosEntity, Long> {
	
}



