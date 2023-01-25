package com.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pos.entities.UnidadMedidaEntity;
@Repository
public interface IUnidadMedidaRepository extends JpaRepository <UnidadMedidaEntity,Long> {

}
