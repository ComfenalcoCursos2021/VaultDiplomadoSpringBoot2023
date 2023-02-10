package com.eventcontrol.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eventcontrol.dtos.AsistentesMinDto;
import com.eventcontrol.entity.AsistenteEntity;
@Repository
public interface IAsistenteRepository extends JpaRepository <AsistenteEntity,Long> {

	
	@Query("SELECT new com.eventcontrol.dtos.AsistentesMinDto(a.nombre) "
			+ " FROM AsistenteEntity a "
			+ " WHERE a.id = :id")
	Optional<AsistentesMinDto> findAsistentesMinById(@Param("id") long id);
	
	@Query("SELECT new com.eventcontrol.dtos.AsistentesMinDto(a.nombre) "
			+ " FROM AsistenteEntity a ")
	List<AsistentesMinDto> findAllAsistentesMin();
}
