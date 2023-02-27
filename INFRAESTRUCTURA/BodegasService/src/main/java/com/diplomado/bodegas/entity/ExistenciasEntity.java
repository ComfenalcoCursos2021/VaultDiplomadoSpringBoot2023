

package com.diplomado.bodegas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="EXISTENCIAS")
@Getter @Setter//@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class ExistenciasEntity {

	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		private int cantidad;	
		
		private String existenciascol;	
		
		private int idBodega;	
		
		private int idProducto;	
	
}




