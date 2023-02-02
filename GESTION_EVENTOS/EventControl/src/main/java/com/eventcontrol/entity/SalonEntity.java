package com.eventcontrol.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="SALONES")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class SalonEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String nombre;
	private int capacidad;
	private String ubicacion;
	private String descripcion;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "salon")
	private List<EventoEntity> eventos;
	
	
}
