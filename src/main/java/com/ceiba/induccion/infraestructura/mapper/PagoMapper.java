package com.ceiba.induccion.infraestructura.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.induccion.dominio.entity.Pago;
import com.ceiba.induccion.infraestructura.entidad.PagoEntity;

@Component
public class PagoMapper {

	@Autowired
	private RegistroMapper registroMapper;

	public PagoEntity mapToEntity(Pago pago) {
		return new PagoEntity(pago.getId(), pago.getValor(), registroMapper.mapToEntity(pago.getRegistro()),
				pago.getUsuarioRegistro(), pago.getFechaRegistro());
	}

}
