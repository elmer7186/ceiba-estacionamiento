package com.ceiba.induccion.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.induccion.dominio.entity.Registro;

@Component("moto")
public class ReglasEstacionamientoMoto implements ReglasEstacionamientoVehiculo {

	public static final int CUPO_MOTOS_PARQUEADERO = 10;
	public static final double VALOR_HORA_MOTO = 500;
	public static final double VALOR_DIA_MOTO = 4_000;
	private static final double VALOR_ADICIONAL_CILINDRAJE = 2_000;
	private static final long HORAS_MINIMO_COBRO = 1;
	private static final long HORAS_PARQUEADERO_DIA = 8;
	private static final long HORAS_DIA_MOTO = 24;
	private static final long CILINDRAJE_COBRO_ADICIONAL = 500;

	@Autowired
	private CalendarioVigilante calendarioVigilante;

	@Override
	public double calcularCosto(Registro registro) {
		double costo = 0;
		long totalHoras = calendarioVigilante.horasEntreFechas(registro.getInicio(), registro.getFin());

		long diasParqueo = totalHoras / HORAS_DIA_MOTO;
		long horasParqueo = totalHoras % HORAS_DIA_MOTO;

		costo = diasParqueo * VALOR_DIA_MOTO;

		if (horasParqueo < HORAS_MINIMO_COBRO) {
			costo = VALOR_HORA_MOTO;
		} else if (horasParqueo <= HORAS_PARQUEADERO_DIA) {
			costo += horasParqueo * VALOR_HORA_MOTO;
		} else {
			costo += VALOR_DIA_MOTO;
		}

		if (registro.getVehiculo().getCilindraje() > CILINDRAJE_COBRO_ADICIONAL) {
			costo += VALOR_ADICIONAL_CILINDRAJE;
		}

		return costo;
	}

	@Override
	public boolean existeCupo(int numero) {
		return numero < CUPO_MOTOS_PARQUEADERO;
	}

}
