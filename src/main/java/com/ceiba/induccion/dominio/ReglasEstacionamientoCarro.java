package com.ceiba.induccion.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.induccion.dominio.entity.Registro;

@Component("carro")
public class ReglasEstacionamientoCarro implements ReglasEstacionamientoVehiculo {

	public static final int CUPO_CARROS_PARQUEADERO = 20;
	public static final double VALOR_HORA_CARRO = 1_000;
	public static final double VALOR_DIA_CARRO = 8_000;
	private static final long HORAS_MINIMO_COBRO_CARRO = 1;
	private static final long HORAS_PARQUEADERO_DIA = 8;
	private static final long HORAS_DIA_CARRO = 24;

	@Autowired
	private CalendarioVigilante calendarioVigilante;

	@Override
	public double calcularCosto(Registro registro) {
		double costo = 0;
		long totalHoras = calendarioVigilante.horasEntreFechas(registro.getInicio(), registro.getFin());

		long diasParqueo = totalHoras / HORAS_DIA_CARRO;
		long horasParqueo = totalHoras % HORAS_DIA_CARRO;

		costo = diasParqueo * VALOR_DIA_CARRO;

		if (horasParqueo < HORAS_MINIMO_COBRO_CARRO) {
			costo = VALOR_HORA_CARRO;
		} else if (horasParqueo <= HORAS_PARQUEADERO_DIA) {
			costo += horasParqueo * VALOR_HORA_CARRO;
		} else {
			costo += VALOR_DIA_CARRO;
		}

		return costo;
	}

	@Override
	public boolean existeCupo(int numero) {
		return numero < CUPO_CARROS_PARQUEADERO;
	}

}
