package com.ceiba.induccion.infraestructura.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.induccion.aplicacion.command.RegistrarSalidaCommand;
import com.ceiba.induccion.aplicacion.command.SelectAllVehiculosEstacionadosCommand;
import com.ceiba.induccion.dominio.entity.Pago;
import com.ceiba.induccion.dominio.entity.Registro;

@RestController
@RequestMapping("registros")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistroController {

	@Autowired
	private RegistrarSalidaCommand registrarSalidaCommand;

	@Autowired
	private SelectAllVehiculosEstacionadosCommand selectAllVehiculosEstacionadosCommand;

	@PatchMapping
	public Pago registrarSalida(long idRegistro) {
		return registrarSalidaCommand.execute(idRegistro);
	}

	@GetMapping
	public List<Registro> listar() {
		return selectAllVehiculosEstacionadosCommand.execute();
	}

}
