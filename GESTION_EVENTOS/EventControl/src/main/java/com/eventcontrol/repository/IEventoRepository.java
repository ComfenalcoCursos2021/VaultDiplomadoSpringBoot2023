package com.eventcontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventcontrol.entity.EventoEntity;
@Repository
public interface IEventoRepository extends JpaRepository <EventoEntity,Long> {

}
