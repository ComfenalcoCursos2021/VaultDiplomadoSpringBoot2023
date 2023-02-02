package com.eventcontrol.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="EVENTOS")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class EventoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String nombre;	
	private Date inicio;
	private Date fin;	
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "ASISTENTES_X_EVENTO", 
             joinColumns = { @JoinColumn(name = "id_evento") }, 
             inverseJoinColumns = { @JoinColumn(name = "id_asistente") })
    private List<AsistenteEntity> asistentes = new ArrayList<AsistenteEntity>();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_salon")
	private SalonEntity salon;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_cliente")
	private ClienteEntity cliente;
	
}
