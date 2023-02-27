



package com.diplomado.ventas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diplomado.ventas.entity.ClientesEntity;

public interface IClientesRepository extends JpaRepository<ClientesEntity, Long> {
	
}



