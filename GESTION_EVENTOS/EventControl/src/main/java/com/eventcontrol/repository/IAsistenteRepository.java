package com.eventcontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventcontrol.entity.AsistenteEntity;
@Repository
public interface IAsistenteRepository extends JpaRepository <AsistenteEntity,Long> {

}
