package com.alkemy.disney.entity;

import java.util.*;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "personaje")
@Getter
@Setter
public class PersonajeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String imagen;
	
	private String nombre;
	
	private Long edad;
	
	private String peso;
	
	private String historia;

	
	@ManyToMany(mappedBy = "personajes", cascade = CascadeType.ALL)
	private List<PeliOSerieEntity> pelisoseries = new ArrayList<>();
	
	
	// Add and Remove pelisoseries
	
	public void addPeliOSerie(PeliOSerieEntity pelioserie) {
		
		this.pelisoseries.add(pelioserie);
	}
	
	public void removePeliOSerie(PeliOSerieEntity pelioserie) {
		this.pelisoseries.remove(pelioserie);
	}
	
	

	
	
}
