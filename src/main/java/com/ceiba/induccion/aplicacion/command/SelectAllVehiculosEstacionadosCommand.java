package com.ceiba.induccion.aplicacion.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.induccion.dominio.Inventario;
import com.ceiba.induccion.dominio.entity.Registro;

@Service
@Transactional
public class SelectAllVehiculosEstacionadosCommand {

	@Autowired
	Inventario inventario;

	public List<Registro> execute() {
		return inventario.listarVehiculosEstacionados();
	}

}
