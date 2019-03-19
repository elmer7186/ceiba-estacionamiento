package com.ceiba.induccion.infraestructura.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.induccion.aplicacion.command.RegistrarIngresoCommand;
import com.ceiba.induccion.aplicacion.dto.VehiculoDto;
import com.ceiba.induccion.dominio.entity.Registro;
import com.ceiba.induccion.dominio.entity.TipoVehiculoEnum;
import com.ceiba.induccion.dominio.entity.Vehiculo;

@RestController
@RequestMapping("vehiculos")
@CrossOrigin(origins = "http://localhost:4200")
public class VehiculoController {

	@Autowired
	private RegistrarIngresoCommand registrarIngresoCommand;

	@PostMapping
	public Registro registrarIngreso(@RequestBody VehiculoDto vehiculoDto) {
		return registrarIngresoCommand.execute(new Vehiculo(vehiculoDto.getId(), vehiculoDto.getPlaca(),
				TipoVehiculoEnum.valueOf(vehiculoDto.getTipo()), vehiculoDto.getCilindraje(), null, null));
	}

}
