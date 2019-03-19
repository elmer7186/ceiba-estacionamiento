package com.ceiba.induccion.dominio.entity;

import java.util.Date;

public class Registro {

	private long id;
	private Vehiculo vehiculo;
	private Date inicio;
	private Date fin;
	private String usuarioRegistro;
	private Date fechaRegistro;

	public Registro() {
		// constructor vacio
	}

	public Registro(long id, Vehiculo vehiculo, Date inicio, Date fin, String usuarioRegistro, Date fechaRegistro) {
		super();
		this.id = id;
		this.vehiculo = vehiculo;
		this.inicio = inicio;
		this.fin = fin;
		this.usuarioRegistro = usuarioRegistro;
		this.fechaRegistro = fechaRegistro;
	}

	public Registro(Vehiculo vehiculo, String usuarioRegistro) {
		this.vehiculo = vehiculo;
		this.usuarioRegistro = usuarioRegistro;
		this.inicio = new Date();
		this.fechaRegistro = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
