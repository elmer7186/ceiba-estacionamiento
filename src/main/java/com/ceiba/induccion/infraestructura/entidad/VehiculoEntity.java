package com.ceiba.induccion.infraestructura.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ceiba.induccion.dominio.entity.TipoVehiculoEnum;

@Entity(name = "vehiculo")
public class VehiculoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@Column(nullable = false)
	private String placa;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoVehiculoEnum tipo;

	@Column
	private Integer cilindraje;

	@Column
	private String usuarioRegistro;

	@Column
	private Date fechaRegistro;

	public VehiculoEntity() {
		super();
	}

	public VehiculoEntity(long id, String placa, TipoVehiculoEnum tipo, Integer cilindraje, String usuario, Date fecha) {
		super();
		this.id = id;
		this.placa = placa;
		this.tipo = tipo;
		this.cilindraje = cilindraje;
		this.usuarioRegistro = usuario;
		this.fechaRegistro = fecha;
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
