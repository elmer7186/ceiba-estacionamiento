package com.ceiba.induccion.aplicacion.integracion;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.induccion.aplicacion.command.RegistrarIngresoCommand;
import com.ceiba.induccion.aplicacion.command.SelectAllVehiculosEstacionadosCommand;
import com.ceiba.induccion.builder.VehiculoTestBuilder;
import com.ceiba.induccion.dominio.entity.Registro;
import com.ceiba.induccion.dominio.entity.TipoVehiculoEnum;
import com.ceiba.induccion.dominio.entity.Vehiculo;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SellectAllVehiculosEstacionadosCommandTest {

	private static final String PLACA_VEHICULO_SIN_RESTRICCION_1 = "FFH134";
	private static final String PLACA_VEHICULO_SIN_RESTRICCION_2 = "FFH146";
	private static final String PLACA_VEHICULO_SIN_RESTRICCION_3 = "RLB741";
	private static final Integer CILINDRAJE_MOTO = 300;
	private static final int NUMERO_VEHICULOS_ESTACIONADOS = 3;

	@Autowired
	private RegistrarIngresoCommand registrarIngresoCommand;

	@Autowired
	private SelectAllVehiculosEstacionadosCommand selectAllVehiculosEstacionadosCommand;

	@Test
	public void numeroCorrectolistarEstacionadosTest() {
		// arrange
		Vehiculo vehiculo1 = VehiculoTestBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION_1)
				.conTipo(TipoVehiculoEnum.CARRO).build();
		Vehiculo vehiculo2 = VehiculoTestBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION_2)
				.conTipo(TipoVehiculoEnum.CARRO).build();
		Vehiculo vehiculo3 = VehiculoTestBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION_3)
				.conCilindraje(CILINDRAJE_MOTO).conTipo(TipoVehiculoEnum.MOTO).build();

		// act
		registrarIngresoCommand.execute(vehiculo1);
		registrarIngresoCommand.execute(vehiculo2);
		registrarIngresoCommand.execute(vehiculo3);

		List<Registro> listado = selectAllVehiculosEstacionadosCommand.execute();

		// assert
		Assert.assertEquals(NUMERO_VEHICULOS_ESTACIONADOS, listado.size());
	}

	@Test
	public void listarEstacionadosFechaFinNulaTest() {
		// arrange
		Vehiculo vehiculo1 = VehiculoTestBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION_1)
				.conTipo(TipoVehiculoEnum.CARRO).build();
		Vehiculo vehiculo2 = VehiculoTestBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION_2)
				.conTipo(TipoVehiculoEnum.CARRO).build();
		Vehiculo vehiculo3 = VehiculoTestBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION_3)
				.conCilindraje(CILINDRAJE_MOTO).conTipo(TipoVehiculoEnum.MOTO).build();

		// act
		registrarIngresoCommand.execute(vehiculo1);
		registrarIngresoCommand.execute(vehiculo2);
		registrarIngresoCommand.execute(vehiculo3);

		List<Registro> listado = selectAllVehiculosEstacionadosCommand.execute();

		listado.forEach(registro -> {
			if (registro.getFin() != null) {
				fail();
			}
		});

		// assert
		assert (true);
	}

}
