package com.ceiba.induccion.infraestructura.controlador;

import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.induccion.aplicacion.command.ConsultarTrmActualCommand;

@RestController
@RequestMapping("trm")
@CrossOrigin(origins = "http://localhost:4200")
public class TRMController {

	@Autowired
	private ConsultarTrmActualCommand consultarTrmActualCommand;

	@GetMapping
	public Float obtenerActual() throws RemoteException {
		return consultarTrmActualCommand.execute();
	}
}
