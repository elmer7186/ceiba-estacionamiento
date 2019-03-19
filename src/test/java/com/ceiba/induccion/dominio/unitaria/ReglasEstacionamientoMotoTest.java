package com.ceiba.induccion.dominio.unitaria;

import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.induccion.builder.RegistroTestBuilder;
import com.ceiba.induccion.builder.VehiculoTestBuilder;
import com.ceiba.induccion.dominio.CalendarioVigilante;
import com.ceiba.induccion.dominio.ReglasEstacionamientoMoto;
import com.ceiba.induccion.dominio.entity.Registro;
import com.ceiba.induccion.dominio.entity.TipoVehiculoEnum;
import com.ceiba.induccion.dominio.entity.Vehiculo;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ReglasEstacionamientoMotoTest {

	@InjectMocks
	private ReglasEstacionamientoMoto reglasEstacionamientoMoto;

	@Spy
	private CalendarioVigilante calendarioVigilante;

	private static final String PLACA_MOTO = "LGH156";
	private static final int CILINDRAJE_MOTO_ALTO = 650;
	private static final int CILINDRAJE_MOTO_BAJO = 200;
	private static final String FECHA_INICIO_VEHICULO_1 = "20/02/2019 16:00";
	private static final String FECHA_FIN_VEHICULO_1 = "21/02/2019 02:00";
	private static final String FECHA_INICIO_VEHICULO_2 = "14/03/2019 07:00";
	private static final String FECHA_FIN_VEHICULO_2 = "14/03/2019 16:00";
	private static final String FECHA_INICIO_VEHICULO_3 = "15/01/2019 10:00";
	private static final String FECHA_FIN_VEHICULO_3 = "15/01/2019 10:30";
	private static final double COSTO_VEHICULO_1 = 6_000;
	private static final double COSTO_VEHICULO_2 = 4_000;
	private static final double COSTO_VEHICULO_3 = 500;
	private static final int MOTOS_EN_PARQUEADERO_PARCIAL = 7;

	private SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(ReglasEstacionamientoMotoTest.class);
	}

	@Test
	public void costoEstacionamiento10HorasCilindrajeAltoTest() {
		// arrange
		Vehiculo vehiculo = VehiculoTestBuilder.defaultValues().conTipo(TipoVehiculoEnum.CARRO).conPlaca(PLACA_MOTO)
				.conCilindraje(CILINDRAJE_MOTO_ALTO).build();
		Date fechaInicio = null;
		Date fechaFin = null;
		try {
			fechaInicio = formatoFechaHora.parse(FECHA_INICIO_VEHICULO_1);
			fechaFin = formatoFechaHora.parse(FECHA_FIN_VEHICULO_1);
		} catch (ParseException e) {
			fail();
		}
		Registro registro = RegistroTestBuilder.defaultValues().conVehiculo(vehiculo).conInicio(fechaInicio)
				.conFin(fechaFin).build();

		// act
		double costo = reglasEstacionamientoMoto.calcularCosto(registro);

		// assert
		Assert.assertEquals(COSTO_VEHICULO_1, costo, 0);
	}

	@Test
	public void costoEstacionamiento9HorasCilindrajeBajoTest() {
		// arrange
		Vehiculo vehiculo = VehiculoTestBuilder.defaultValues().conTipo(TipoVehiculoEnum.CARRO).conPlaca(PLACA_MOTO)
				.conCilindraje(CILINDRAJE_MOTO_BAJO).build();
		Date fechaInicio = null;
		Date fechaFin = null;
		try {
			fechaInicio = formatoFechaHora.parse(FECHA_INICIO_VEHICULO_2);
			fechaFin = formatoFechaHora.parse(FECHA_FIN_VEHICULO_2);
		} catch (ParseException e) {
			fail();
		}
		Registro registro = RegistroTestBuilder.defaultValues().conVehiculo(vehiculo).conInicio(fechaInicio)
				.conFin(fechaFin).build();

		// act
		double costo = reglasEstacionamientoMoto.calcularCosto(registro);

		// assert
		Assert.assertEquals(COSTO_VEHICULO_2, costo, 0);
	}

	@Test
	public void costoEstacionamiento30MinutosCilindrajeBajoTest() {
		// arrange
		Vehiculo vehiculo = VehiculoTestBuilder.defaultValues().conTipo(TipoVehiculoEnum.CARRO).conPlaca(PLACA_MOTO)
				.conCilindraje(CILINDRAJE_MOTO_BAJO).build();
		Date fechaInicio = null;
		Date fechaFin = null;
		try {
			fechaInicio = formatoFechaHora.parse(FECHA_INICIO_VEHICULO_3);
			fechaFin = formatoFechaHora.parse(FECHA_FIN_VEHICULO_3);
		} catch (ParseException e) {
			fail();
		}
		Registro registro = RegistroTestBuilder.defaultValues().conVehiculo(vehiculo).conInicio(fechaInicio)
				.conFin(fechaFin).build();

		// act
		double costo = reglasEstacionamientoMoto.calcularCosto(registro);

		// assert
		Assert.assertEquals(COSTO_VEHICULO_3, costo, 0);
	}

	@Test
	public void siExisteCupoTest() {
		// arrange

		// act
		boolean resultado = reglasEstacionamientoMoto.existeCupo(MOTOS_EN_PARQUEADERO_PARCIAL);

		// assert
		Assert.assertTrue(resultado);
	}

	@Test
	public void noExisteCupoTest() {
		// arrange

		// act
		boolean resultado = reglasEstacionamientoMoto.existeCupo(ReglasEstacionamientoMoto.CUPO_MOTOS_PARQUEADERO);

		// assert
		Assert.assertFalse(resultado);
	}

}
