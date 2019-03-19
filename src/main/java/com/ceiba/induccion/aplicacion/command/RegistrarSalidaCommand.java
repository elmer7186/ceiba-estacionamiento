package com.ceiba.induccion.aplicacion.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.induccion.dominio.Operaciones;
import com.ceiba.induccion.dominio.entity.Pago;

@Service
@Transactional
public class RegistrarSalidaCommand {

	@Autowired
	Operaciones operaciones;

	public Pago execute(long idRegistro) {
		return operaciones.registrarSalida(idRegistro);
	}
}
