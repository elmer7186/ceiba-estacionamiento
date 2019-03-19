package com.ceiba.induccion.dominio;

import com.ceiba.induccion.dominio.entity.Pago;
import com.ceiba.induccion.dominio.entity.Registro;
import com.ceiba.induccion.dominio.entity.Vehiculo;

public interface Operaciones {

	Registro registrarIngreso(Vehiculo vehiculo);

	Pago registrarSalida(long idRegistro);

}
