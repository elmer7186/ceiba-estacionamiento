package com.ceiba.induccion.infraestructura.repositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.induccion.dominio.entity.Vehiculo;
import com.ceiba.induccion.dominio.port.VehiculoRepository;
import com.ceiba.induccion.infraestructura.entidad.VehiculoEntity;
import com.ceiba.induccion.infraestructura.mapper.VehiculoMapper;

@Repository
public class VehiculoRepositoryAdapter implements VehiculoRepository {

	@Autowired
	private VehiculoRepositoryData vehiculoRepositoryData;

	@Autowired
	private VehiculoMapper vehiculoMapper;

	@Override
	public Vehiculo save(Vehiculo vehiculo) {
		VehiculoEntity vehiculoEntity = vehiculoRepositoryData.save(vehiculoMapper.mapToEntity(vehiculo));
		vehiculo.setId(vehiculoEntity.getId());
		return vehiculo;
	}

}
