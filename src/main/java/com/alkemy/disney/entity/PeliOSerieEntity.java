package com.alkemy.disney.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pelioserie")
@Getter
@Setter


public class PeliOSerieEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	
	private String imagen;
	
	private String titulo;
	
	@Column(name = "fec_creacion")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate fechacreacion;
	 
	private Long calificacion;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "genero_id", insertable = false, updatable = false)
	private GeneroEntity genero;
	
	@Column(name = "genero_id", nullable = false)
	private Long generoid;
	
	@ManyToMany(
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			}
			)
	@JoinTable(
			name = "personaje_pelioserie",
			joinColumns = @JoinColumn(name = "pelioserie_id"),
			inverseJoinColumns = @JoinColumn(name = "personaje_id"))
	
	private Set<PersonajeEntity> personajes = new HashSet<>();
	
	
	

	
	
	
	
}
