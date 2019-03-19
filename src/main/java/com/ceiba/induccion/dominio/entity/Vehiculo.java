package com.ceiba.induccion.dominio.entity;

import java.util.Date;

public class Vehiculo {

	private static final String MENSAJE_ERROR_PLACA_REQUERIDO = "La placa es requerida";
	private static final String MENSAJE_ERROR_TIPO_VEHICULO_REQUERIDO = "El tipo de vehiculo es requerido";

	private long id;
	private String placa;
	private TipoVehiculoEnum tipo;
	private Integer cilindraje;
	private String usuarioRegistro;
	private Date fechaRegistro;

	public Vehiculo() {
		super();
	}

	public Vehiculo(long id, String placa, TipoVehiculoEnum tipo, Integer cilindraje, String usuarioRegistro,
			Date fechaRegistro) {
		ArgumentValidator.validateRequired(placa, MENSAJE_ERROR_PLACA_REQUERIDO);
		ArgumentValidator.validateRequired(tipo, MENSAJE_ERROR_TIPO_VEHICULO_REQUERIDO);
		this.id = id;
		this.placa = placa;
		this.tipo = tipo;
		this.cilindraje = cilindraje;
		this.usuarioRegistro = usuarioRegistro;
		this.fechaRegistro = fechaRegistro;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public TipoVehiculoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoVehiculoEnum tipo) {
		this.tipo = tipo;
	}

	public Integer getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(Integer cilindraje) {
		this.cilindraje = cilindraje;
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
