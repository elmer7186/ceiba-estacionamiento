package com.ceiba.induccion.infraestructura.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.induccion.infraestructura.entidad.PagoEntity;

@Repository
public interface PagoRepositoryData extends CrudRepository<PagoEntity, Long> {

}
