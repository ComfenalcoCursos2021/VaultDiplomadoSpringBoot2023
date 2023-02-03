package com.eventcontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventcontrol.entity.SalonEntity;
@Repository
public interface ISalonRepository extends JpaRepository <SalonEntity,Long> {

}
