package com.ceiba.induccion.dominio.entity;

import com.ceiba.induccion.dominio.excepcion.RegistroException;

public final class ArgumentValidator {
	private ArgumentValidator() {
	}

	public static void validateRequired(Object value, String message) {
		if (value == null) {
			throw new RegistroException(message);
		}
	}
}
