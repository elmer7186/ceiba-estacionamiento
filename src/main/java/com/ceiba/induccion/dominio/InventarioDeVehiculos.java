package com.ceiba.induccion.dominio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.induccion.dominio.entity.Registro;
import com.ceiba.induccion.dominio.port.RegistroRepository;

@Service
public class InventarioDeVehiculos implements Inventario {

	@Autowired
	private RegistroRepository registroRepository;

	@Override
	public List<Registro> listarVehiculosEstacionados() {
		return registroRepository.listarVehiculosEstacionados();
	}

}
