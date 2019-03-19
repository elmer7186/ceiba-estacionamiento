package com.ceiba.induccion.dominio;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.induccion.dominio.entity.Pago;
import com.ceiba.induccion.dominio.entity.Registro;
import com.ceiba.induccion.dominio.entity.Vehiculo;
import com.ceiba.induccion.dominio.excepcion.RegistroException;
import com.ceiba.induccion.dominio.port.PagoRepository;
import com.ceiba.induccion.dominio.port.RegistroRepository;
import com.ceiba.induccion.dominio.port.VehiculoRepository;

@Transactional
@Service
public class OperacionesDelVigilante implements Operaciones {

	public static final String MENSAJE_ERROR_NO_INGRESO_FIN_SEMANA = "El vehiculo no puede ingresar en semana";
	public static final String MENSAJE_ERROR_NO_HAY_CUPO = "El estacionamiento no cuenta con cupos para el vehiculo";
	public static final String MENSAJE_ERROR_VEHICULO_ESTACIONADO = "El vehiculo ya se encuentra estacionado";

	@Autowired
	private ReglasEstacionamiento reglasEstacionamiento;

	@Autowired
	private RegistroRepository registroRepository;

	@Autowired
	private VehiculoRepository vehiculoRepository;

	@Autowired
	private PagoRepository pagoRepository;

	@Autowired
	private UsuarioSesion usuarioSesion;

	@Override
	public Registro registrarIngreso(Vehiculo vehiculo) {
		if (reglasEstacionamiento.validarSiExisteRestriccion(vehiculo.getPlaca())) {
			throw new RegistroException(MENSAJE_ERROR_NO_INGRESO_FIN_SEMANA);
		}

		int numeroVehiculos = registroRepository.contarVehiculosEstacionados(vehiculo.getTipo());
		if (!reglasEstacionamiento.validarSiExisteCupo(vehiculo.getTipo(), numeroVehiculos)) {
			throw new RegistroException(MENSAJE_ERROR_NO_HAY_CUPO);
		}

		if (registroRepository.existeVehiculoEnEstacionamiento(vehiculo.getPlaca())) {
			throw new RegistroException(MENSAJE_ERROR_VEHICULO_ESTACIONADO);
		}

		String usuarioRegistro = usuarioSesion.usuarioEnSesion();
		vehiculo.setFechaRegistro(new Date());
		vehiculo.setUsuarioRegistro(usuarioRegistro);
		vehiculo = vehiculoRepository.save(vehiculo);

		Registro registro = new Registro(vehiculo, usuarioRegistro);
		registro = registroRepository.save(registro);
		return registro;
	}

	@Override
	public Pago registrarSalida(long idRegistro) {
		Registro registro = registroRepository.findById(idRegistro);
		registro.setFin(new Date());
		registroRepository.save(registro);
		String usuarioRegistro = usuarioSesion.usuarioEnSesion();
		Double costoCalculado = reglasEstacionamiento.ejecutarCalculo(registro);
		Pago pago = new Pago(costoCalculado, registro, usuarioRegistro);
		return pagoRepository.save(pago);
	}
}
