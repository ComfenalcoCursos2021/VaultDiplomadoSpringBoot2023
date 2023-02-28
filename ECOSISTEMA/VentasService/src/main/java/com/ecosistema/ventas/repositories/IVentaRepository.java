package com.ecosistema.ventas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecosistema.ventas.entity.VentaEntity;

@Repository
public interface IVentaRepository  extends JpaRepository <VentaEntity,Long>{

}
