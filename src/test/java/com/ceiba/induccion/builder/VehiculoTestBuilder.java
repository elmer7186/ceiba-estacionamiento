package com.ceiba.induccion.builder;

import java.util.Date;

import com.ceiba.induccion.dominio.entity.TipoVehiculoEnum;
import com.ceiba.induccion.dominio.entity.Vehiculo;

public class VehiculoTestBuilder {

	private String placa;
	private TipoVehiculoEnum tipo;
	private Integer cilindraje;
	private String usuarioRegistro;
	private Date fechaRegistro;

	private VehiculoTestBuilder() {
		super();
	}

	public static VehiculoTestBuilder defaultValues() {
		return new VehiculoTestBuilder();
	}

	public VehiculoTestBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}

	public VehiculoTestBuilder conTipo(TipoVehiculoEnum tipo) {
		this.tipo = tipo;
		return this;
	}

	public VehiculoTestBuilder conCilindraje(Integer cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}

	public VehiculoTestBuilder setUsuarioRegistro(String usuario) {
		this.usuarioRegistro = usuario;
		return this;
	}

	public VehiculoTestBuilder setFechaRegistro(Date fecha) {
		this.fechaRegistro = fecha;
		return this;
	}

	public Vehiculo build() {
		return new Vehiculo(0, this.placa, this.tipo, this.cilindraje, this.usuarioRegistro, this.fechaRegistro);
	}

}
