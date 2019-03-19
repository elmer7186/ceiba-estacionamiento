package com.ceiba.induccion.dominio;

import org.springframework.stereotype.Service;

@Service
public class UsuarioSesionHttp implements UsuarioSesion {

	private static final String USUARIO_SESION = "usuario_prueba";

	@Override
	public String usuarioEnSesion() {
		return USUARIO_SESION;
	}

}
