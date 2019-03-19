package com.ceiba.induccion.builder;

import java.util.Date;

import com.ceiba.induccion.dominio.entity.Registro;
import com.ceiba.induccion.dominio.entity.Vehiculo;

public class RegistroTestBuilder {

	private Vehiculo vehiculo;
	private Date inicio;
	private Date fin;
	private String usuarioRegistro;
	private Date fechaRegistro;

	private RegistroTestBuilder() {
		super();
	}

	public static RegistroTestBuilder defaultValues() {
		return new RegistroTestBuilder();
	}

	public RegistroTestBuilder conVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		return this;
	}

	public RegistroTestBuilder conInicio(Date inicio) {
		this.inicio = inicio;
		return this;
	}

	public RegistroTestBuilder conFin(Date fin) {
		this.fin = fin;
		return this;
	}

	public RegistroTestBuilder conUsuarioRegistro(String usuario) {
		this.usuarioRegistro = usuario;
		return this;
	}

	public RegistroTestBuilder conFechaRegistro(Date fecha) {
		this.fechaRegistro = fecha;
		return this;
	}

	public Registro build() {
		return new Registro(0, vehiculo, inicio, fin, usuarioRegistro, fechaRegistro);
	}

}
