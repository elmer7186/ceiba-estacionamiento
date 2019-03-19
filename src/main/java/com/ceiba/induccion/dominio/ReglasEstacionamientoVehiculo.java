package com.ceiba.induccion.dominio;

import com.ceiba.induccion.dominio.entity.Registro;

public interface ReglasEstacionamientoVehiculo {

	double calcularCosto(Registro registro);

	boolean existeCupo(int numero);

}
