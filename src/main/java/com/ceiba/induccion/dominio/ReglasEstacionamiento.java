package com.ceiba.induccion.dominio;

import java.time.DayOfWeek;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.induccion.dominio.entity.Registro;
import com.ceiba.induccion.dominio.entity.TipoVehiculoEnum;

@Component
public class ReglasEstacionamiento {

	public static final char LETRA_RESTRICCION_ACCESO = 'A';

	@Resource(name = "carro")
	private ReglasEstacionamientoVehiculo carro;

	@Resource(name = "moto")
	private ReglasEstacionamientoVehiculo moto;

	@Autowired
	private CalendarioVigilante calendarioVigilante;

	public boolean validarSiExisteCupo(TipoVehiculoEnum tipo, int numeroVehiculos) {
		boolean existeCupo;
		if (tipo == TipoVehiculoEnum.CARRO) {
			existeCupo = carro.existeCupo(numeroVehiculos);
		} else {
			existeCupo = moto.existeCupo(numeroVehiculos);
		}
		return existeCupo;
	}

	public Double ejecutarCalculo(Registro registro) {
		Double costo = null;
		if (registro != null) {
			if (registro.getVehiculo().getTipo() == TipoVehiculoEnum.CARRO) {
				costo = carro.calcularCosto(registro);
			} else {
				costo = moto.calcularCosto(registro);
			}
		}
		return costo;
	}

	public Boolean validarSiExisteRestriccion(String placa) {
		DayOfWeek diaHoy = calendarioVigilante.dayWeekFromDate(new Date());
		return placa.charAt(0) == ReglasEstacionamiento.LETRA_RESTRICCION_ACCESO
				&& !(diaHoy == DayOfWeek.SUNDAY || diaHoy == DayOfWeek.MONDAY);
	}

}
