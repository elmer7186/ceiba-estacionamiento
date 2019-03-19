package com.ceiba.induccion.dominio.unitaria;

import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.induccion.builder.RegistroTestBuilder;
import com.ceiba.induccion.builder.VehiculoTestBuilder;
import com.ceiba.induccion.dominio.CalendarioVigilante;
import com.ceiba.induccion.dominio.OperacionesDelVigilante;
import com.ceiba.induccion.dominio.ReglasEstacionamiento;
import com.ceiba.induccion.dominio.ReglasEstacionamientoCarro;
import com.ceiba.induccion.dominio.ReglasEstacionamientoMoto;
import com.ceiba.induccion.dominio.UsuarioSesionHttp;
import com.ceiba.induccion.dominio.entity.Registro;
import com.ceiba.induccion.dominio.entity.TipoVehiculoEnum;
import com.ceiba.induccion.dominio.entity.Vehiculo;
import com.ceiba.induccion.dominio.excepcion.RegistroException;
import com.ceiba.induccion.dominio.port.RegistroRepository;
import com.ceiba.induccion.dominio.port.VehiculoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ServiciosDelVigilanteTest {

	private static final String PLACA_VEHICULO_CON_RESTRICCION = "ALG139";
	private static final String PLACA_VEHICULO_SIN_RESTRICCION = "NNL677";
	private static final Integer CILINDRAJE_MOTO = 550;
	private static final int CARROS_EN_PARQUEADERO = 5;
	private static final int MOTOS_EN_PARQUEADERO = 3;

	@Mock
	private CalendarioVigilante calendarioVigilante;

	@Mock
	private ReglasEstacionamiento reglasEstacionamiento;

	@Mock
	private RegistroRepository registroRepository;

	@Mock
	private VehiculoRepository vehiculoRepository;

	@Spy
	private UsuarioSesionHttp usuarioSesion;

	@InjectMocks
	private OperacionesDelVigilante operacionesDelVigilante;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(ServiciosDelVigilanteTest.class);
	}

	@Test
	public void registrarMotoConCupoTest() {
		// arrange
		Vehiculo vehiculo = VehiculoTestBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION)
				.conCilindraje(CILINDRAJE_MOTO).conTipo(TipoVehiculoEnum.MOTO).build();

		when(registroRepository.contarVehiculosEstacionados(TipoVehiculoEnum.MOTO)).thenReturn(MOTOS_EN_PARQUEADERO);

		when(reglasEstacionamiento.validarSiExisteCupo(TipoVehiculoEnum.MOTO, MOTOS_EN_PARQUEADERO))
				.thenReturn(Boolean.TRUE);

		when(vehiculoRepository.save(any())).thenReturn(vehiculo);

		Registro registro = RegistroTestBuilder.defaultValues().conVehiculo(vehiculo).build();
		when(registroRepository.save(any())).thenReturn(registro);

		// act
		Registro registroAlmacenado = operacionesDelVigilante.registrarIngreso(vehiculo);

		// assert
		Assert.assertEquals(PLACA_VEHICULO_SIN_RESTRICCION, registroAlmacenado.getVehiculo().getPlaca());
		Assert.assertEquals(CILINDRAJE_MOTO, registroAlmacenado.getVehiculo().getCilindraje());
		Assert.assertEquals(TipoVehiculoEnum.MOTO, registroAlmacenado.getVehiculo().getTipo());
	}

	@Test
	public void registrarCarroConCupoTest() {
		// arrange
		Vehiculo vehiculo = VehiculoTestBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION)
				.conTipo(TipoVehiculoEnum.CARRO).build();

		when(registroRepository.contarVehiculosEstacionados(TipoVehiculoEnum.CARRO)).thenReturn(CARROS_EN_PARQUEADERO);

		when(reglasEstacionamiento.validarSiExisteCupo(TipoVehiculoEnum.CARRO, CARROS_EN_PARQUEADERO))
				.thenReturn(Boolean.TRUE);

		when(vehiculoRepository.save(any())).thenReturn(vehiculo);

		Registro registro = RegistroTestBuilder.defaultValues().conVehiculo(vehiculo).build();
		when(registroRepository.save(any())).thenReturn(registro);

		// act
		Registro registroAlmacenado = operacionesDelVigilante.registrarIngreso(vehiculo);

		// assert
		Assert.assertEquals(PLACA_VEHICULO_SIN_RESTRICCION, registroAlmacenado.getVehiculo().getPlaca());
		Assert.assertEquals(TipoVehiculoEnum.CARRO, registroAlmacenado.getVehiculo().getTipo());
	}

	@Test
	public void noPermitirRegistrarMotoSinCupoTest() {
		// arrange
		Vehiculo vehiculo = VehiculoTestBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION)
				.conCilindraje(CILINDRAJE_MOTO).conTipo(TipoVehiculoEnum.MOTO).build();

		when(registroRepository.contarVehiculosEstacionados(TipoVehiculoEnum.CARRO))
				.thenReturn(ReglasEstacionamientoMoto.CUPO_MOTOS_PARQUEADERO);

		when(reglasEstacionamiento.validarSiExisteCupo(TipoVehiculoEnum.MOTO,
				ReglasEstacionamientoMoto.CUPO_MOTOS_PARQUEADERO)).thenReturn(Boolean.FALSE);

		// act
		try {
			operacionesDelVigilante.registrarIngreso(vehiculo);
			fail();
		} catch (RegistroException e) {
			Assert.assertEquals(OperacionesDelVigilante.MENSAJE_ERROR_NO_HAY_CUPO, e.getMessage());
		}
	}

	@Test
	public void noPermitirRegistrarCarroSinCupoTest() {
		// arrange
		Vehiculo vehiculo = VehiculoTestBuilder.defaultValues().conPlaca(PLACA_VEHICULO_SIN_RESTRICCION)
				.conTipo(TipoVehiculoEnum.CARRO).build();

		when(registroRepository.contarVehiculosEstacionados(TipoVehiculoEnum.CARRO))
				.thenReturn(ReglasEstacionamientoCarro.CUPO_CARROS_PARQUEADERO);

		when(reglasEstacionamiento.validarSiExisteCupo(TipoVehiculoEnum.CARRO,
				ReglasEstacionamientoCarro.CUPO_CARROS_PARQUEADERO)).thenReturn(Boolean.FALSE);

		// act
		try {
			operacionesDelVigilante.registrarIngreso(vehiculo);
			fail();
		} catch (RegistroException e) {
			Assert.assertEquals(OperacionesDelVigilante.MENSAJE_ERROR_NO_HAY_CUPO, e.getMessage());
		}

	}

	@Test
	public void noPermitirRegistrarVehiculoConRestriccionTest() {
		// arrange
		Vehiculo vehiculo = VehiculoTestBuilder.defaultValues().conPlaca(PLACA_VEHICULO_CON_RESTRICCION)
				.conCilindraje(CILINDRAJE_MOTO).conTipo(TipoVehiculoEnum.MOTO).build();

		when(reglasEstacionamiento.validarSiExisteRestriccion(any())).thenReturn(Boolean.TRUE);

		// act
		try {
			operacionesDelVigilante.registrarIngreso(vehiculo);
			fail();
		} catch (RegistroException e) {
			Assert.assertEquals(OperacionesDelVigilante.MENSAJE_ERROR_NO_INGRESO_FIN_SEMANA, e.getMessage());
		}

	}

}
