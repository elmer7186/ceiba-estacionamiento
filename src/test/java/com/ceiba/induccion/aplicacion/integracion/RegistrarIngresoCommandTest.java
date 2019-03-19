package com.ceiba.induccion.aplicacion.integracion;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.induccion.aplicacion.command.RegistrarIngresoCommand;
import com.ceiba.induccion.builder.VehiculoTestBuilder;
import com.ceiba.induccion.dominio.OperacionesDelVigilante;
import com.ceiba.induccion.dominio.entity.Registro;
import com.ceiba.induccion.dominio.entity.TipoVehiculoEnum;
import com.ceiba.induccion.dominio.entity.Vehiculo;
import com.ceiba.induccion.dominio.excepcion.RegistroException;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class RegistrarIngresoCommandTest {

	@Autowired
	private RegistrarIngresoCommand registrarIngresoCommand;

	private static final String PLACA_VEHICULO_SIN_RESTRICCION = "FFH134";
	private static final Integer CILINDRAJE_MOTO = 300;

	@Test
	public void registrarIngresoCarroSinRestriccionTest() {
		// arrange
		Vehiculo vehiculo = VehiculoTestBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION)
				.conTipo(TipoVehiculoEnum.CARRO).build();
		// act
		Registro registro = registrarIngresoCommand.execute(vehiculo);

		// assert
		Assert.assertEquals(PLACA_VEHICULO_SIN_RESTRICCION, registro.getVehiculo().getPlaca());
		Assert.assertEquals(TipoVehiculoEnum.CARRO, registro.getVehiculo().getTipo());
	}

	@Test
	public void registrarIngresoMotoSinRestriccionTest() {
		// arrange
		Vehiculo vehiculo = VehiculoTestBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION)
				.conCilindraje(CILINDRAJE_MOTO).conTipo(TipoVehiculoEnum.MOTO).build();

		// act
		Registro registro = registrarIngresoCommand.execute(vehiculo);

		// assert
		Assert.assertEquals(PLACA_VEHICULO_SIN_RESTRICCION, registro.getVehiculo().getPlaca());
		Assert.assertEquals(TipoVehiculoEnum.MOTO, registro.getVehiculo().getTipo());
	}

	@Test
	public void noPermitirRegistrarVehiculoConPlacaYaEstacionadoTest() {
		// arrange
		Vehiculo vehiculo = VehiculoTestBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION)
				.conCilindraje(CILINDRAJE_MOTO).conTipo(TipoVehiculoEnum.MOTO).build();

		// act
		try {
			registrarIngresoCommand.execute(vehiculo);
			registrarIngresoCommand.execute(vehiculo);
		} catch (RegistroException e) {
			Assert.assertEquals(OperacionesDelVigilante.MENSAJE_ERROR_VEHICULO_ESTACIONADO, e.getMessage());
			return;
		}

		// assert
		fail();
	}

}
