package com.ceiba.induccion.infraestructura.mapper;

import org.springframework.stereotype.Component;

import com.ceiba.induccion.dominio.entity.Vehiculo;
import com.ceiba.induccion.infraestructura.entidad.VehiculoEntity;

@Component
public class VehiculoMapper {

	public Vehiculo mapToDomain(VehiculoEntity vehiculoEntity) {
		return new Vehiculo(vehiculoEntity.getId(), vehiculoEntity.getPlaca(), vehiculoEntity.getTipo(),
				vehiculoEntity.getCilindraje(), vehiculoEntity.getUsuarioRegistro(), vehiculoEntity.getFechaRegistro());
	}

	public VehiculoEntity mapToEntity(Vehiculo vehiculo) {
		return new VehiculoEntity(vehiculo.getId(), vehiculo.getPlaca(), vehiculo.getTipo(), vehiculo.getCilindraje(),
				vehiculo.getUsuarioRegistro(), vehiculo.getFechaRegistro());
	}

}
