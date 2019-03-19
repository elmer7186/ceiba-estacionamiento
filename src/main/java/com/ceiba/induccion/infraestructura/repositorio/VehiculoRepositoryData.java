package com.ceiba.induccion.infraestructura.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.induccion.infraestructura.entidad.VehiculoEntity;

@Repository
public interface VehiculoRepositoryData extends CrudRepository<VehiculoEntity, Long> {

}
