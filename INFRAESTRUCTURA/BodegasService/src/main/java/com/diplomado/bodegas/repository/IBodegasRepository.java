



package com.diplomado.bodegas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diplomado.bodegas.entity.BodegasEntity;

public interface IBodegasRepository extends JpaRepository<BodegasEntity, Long> {
	
}



