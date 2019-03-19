package com.ceiba.induccion.aplicacion.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.induccion.dominio.Operaciones;
import com.ceiba.induccion.dominio.entity.Registro;
import com.ceiba.induccion.dominio.entity.Vehiculo;

@Service
@Transactional
public class RegistrarIngresoCommand {

	@Autowired
	Operaciones operaciones;

	public Registro execute(Vehiculo vehiculo) {
		return operaciones.registrarIngreso(vehiculo);
	}

}
