package com.ceiba.induccion.aplicacion.integracion;

import static org.junit.Assert.fail;

import java.rmi.RemoteException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.induccion.aplicacion.command.ConsultarTrmActualCommand;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ConsultarTrmActualCommandTest {

	@Autowired
	private ConsultarTrmActualCommand consultarTrmActualCommand;

	@Test
	public void obtenerTrmActualTest() {
		// arrage

		// act
		Float trmActual = null;
		try {
			trmActual = consultarTrmActualCommand.execute();
		} catch (RemoteException e) {
			fail();
		}

		// assert
		Assert.assertNotNull(trmActual);
	}

}
