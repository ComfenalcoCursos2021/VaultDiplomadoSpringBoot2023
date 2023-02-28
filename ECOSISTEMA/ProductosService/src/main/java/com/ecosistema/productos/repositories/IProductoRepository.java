package com.ecosistema.productos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecosistema.productos.entity.ProductoEntity;

@Repository
public interface IProductoRepository extends JpaRepository <ProductoEntity,Long> {

}
