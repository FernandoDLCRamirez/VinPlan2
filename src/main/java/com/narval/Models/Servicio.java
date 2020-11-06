package com.narval.Models;

import java.math.BigInteger;
import java.security.Timestamp;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name = "servicio", schema="wineplan")
public class Servicio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToMany(mappedBy="servicio")
    private Set<ReservacionEspecifica> reservacionespecifica;

	@Column(name="nombre", length=30, nullable=false, unique=true)
	private String nombre;
	
	@Column(name="costo", length=50, nullable=false, unique=false)
	private Double costo;
	
	@Column(name="descripcion", length=500, nullable=false, unique=false)
	private String descripcion;
	
	@Column(name="fechaInicio", nullable=false, unique=false)
	private Date fechaIncicio;
	
	@Column(name="fechaFinal", nullable=false, unique=false)
	private Date fechaFinal;

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Vinicola_idVinicola", referencedColumnName = "id")
	private Vinicola vinicola;

	@Column(name="last_update", nullable=false, unique = false)
	private Date last_update;

	@Column(name="maximoAforo", nullable=false, unique=false)
	private int maximoAforo;
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getCosto() {
		return this.costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaIncicio() {
		return this.fechaIncicio;
	}

	public void setFechaIncicio(Date fechaIncicio) {
		this.fechaIncicio = fechaIncicio;
	}

	public Date getFechaFinal() {
		return this.fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Vinicola getVinicola() {
		return this.vinicola;
	}

	public void setVinicola(Vinicola vinicola) {
		this.vinicola = vinicola;
	}

	public Date getLast_update() {
		return this.last_update;
	}

	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}

	public int getMaximoAforo() {
		return this.maximoAforo;
	}

	public void setMaximoAforo(int maximoAforo) {
		this.maximoAforo = maximoAforo;
	}

}
