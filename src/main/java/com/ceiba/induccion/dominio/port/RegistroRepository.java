package com.ceiba.induccion.dominio.port;

import java.util.List;

import com.ceiba.induccion.dominio.entity.Registro;
import com.ceiba.induccion.dominio.entity.TipoVehiculoEnum;

public interface RegistroRepository {

	Registro save(Registro registro);

	Registro findById(long id);

	int contarVehiculosEstacionados(TipoVehiculoEnum tipoVehiculo);

	boolean existeVehiculoEnEstacionamiento(String placa);

	List<Registro> listarVehiculosEstacionados();

}
