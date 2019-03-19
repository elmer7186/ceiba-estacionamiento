package com.ceiba.induccion.aplicacion.integracion;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.induccion.aplicacion.command.RegistrarIngresoCommand;
import com.ceiba.induccion.aplicacion.command.RegistrarSalidaCommand;
import com.ceiba.induccion.builder.VehiculoTestBuilder;
import com.ceiba.induccion.dominio.ReglasEstacionamientoCarro;
import com.ceiba.induccion.dominio.ReglasEstacionamientoMoto;
import com.ceiba.induccion.dominio.entity.Pago;
import com.ceiba.induccion.dominio.entity.Registro;
import com.ceiba.induccion.dominio.entity.TipoVehiculoEnum;
import com.ceiba.induccion.dominio.entity.Vehiculo;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class RegistrarSalidaCommandTest {

	private static final String PLACA_VEHICULO_SIN_RESTRICCION = "RLB741";
	private static final Integer CILINDRAJE_MOTO = 300;
	private static final double VALOR_PAGO = 1_000;

	@Autowired
	private RegistrarIngresoCommand registrarIngresoCommand;

	@Autowired
	private RegistrarSalidaCommand registrarSalidaCommand;

	@Test
	public void registrarSalidaMotoTest() {
		// arrage
		Vehiculo vehiculo = VehiculoTestBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION)
				.conCilindraje(CILINDRAJE_MOTO).conTipo(TipoVehiculoEnum.MOTO).build();

		// act
		Registro registro = registrarIngresoCommand.execute(vehiculo);
		Pago pago = registrarSalidaCommand.execute(registro.getId());

		// assert
		Assert.assertEquals(ReglasEstacionamientoMoto.VALOR_HORA_MOTO, pago.getValor(), 0);
	}

	@Test
	public void registrarSalidaCarroTest() {
		// arrage
		Vehiculo vehiculo = VehiculoTestBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION)
				.conTipo(TipoVehiculoEnum.CARRO).build();

		// act
		Registro registro = registrarIngresoCommand.execute(vehiculo);
		Pago pago = registrarSalidaCommand.execute(registro.getId());

		// assert
		Assert.assertEquals(ReglasEstacionamientoCarro.VALOR_HORA_CARRO, pago.getValor(), 0);
	}
	
	@Test
	public void valorCorrectoRegistrarPagoTest() {
		// arrange
		Vehiculo vehiculo = VehiculoTestBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION)
				.conTipo(TipoVehiculoEnum.CARRO).build();

		// act
		Registro registro = registrarIngresoCommand.execute(vehiculo);
		Pago pago = registrarSalidaCommand.execute(registro.getId());

		// assert
		Assert.assertEquals(VALOR_PAGO, pago.getValor(), 0);
	}

}
