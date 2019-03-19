package com.ceiba.induccion.infraestructura.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ceiba.induccion.dominio.entity.TipoVehiculoEnum;
import com.ceiba.induccion.infraestructura.entidad.RegistroEntity;

@Repository
public interface RegistroRepositoryData extends CrudRepository<RegistroEntity, Long> {

	@Query("SELECT COUNT(r) FROM registro r WHERE r.vehiculo.tipo = :tipo AND fin is null")
	int contarVehiculosEstacionados(@Param("tipo") TipoVehiculoEnum tipo);

	@Query("SELECT COUNT(r) FROM registro r WHERE r.vehiculo.placa = :placa AND fin is null")
	int contarVehiculosEstacionadosConPlaca(@Param("placa") String placa);

	List<RegistroEntity> findByFinIsNull();

}
