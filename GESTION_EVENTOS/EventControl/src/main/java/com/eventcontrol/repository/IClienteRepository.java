package com.eventcontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventcontrol.entity.ClienteEntity;
@Repository
public interface IClienteRepository extends JpaRepository <ClienteEntity,Long> {

}
