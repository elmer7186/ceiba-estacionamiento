package com.ceiba.induccion.infraestructura.repositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.induccion.dominio.entity.Pago;
import com.ceiba.induccion.dominio.port.PagoRepository;
import com.ceiba.induccion.infraestructura.entidad.PagoEntity;
import com.ceiba.induccion.infraestructura.mapper.PagoMapper;

@Repository
public class PagoRepositoryAdapter implements PagoRepository {

	@Autowired
	private PagoRepositoryData pagoRepositoryData;

	@Autowired
	private PagoMapper pagoMapper;

	@Override
	public Pago save(Pago pago) {
		PagoEntity pagoEntity = pagoRepositoryData.save(pagoMapper.mapToEntity(pago));
		pago.setId(pagoEntity.getId());
		return pago;
	}

}
