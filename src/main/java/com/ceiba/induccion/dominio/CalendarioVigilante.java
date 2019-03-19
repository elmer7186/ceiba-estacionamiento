package com.ceiba.induccion.dominio;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class CalendarioVigilante {

	public DayOfWeek dayWeekFromDate(Date fecha) {
		LocalDateTime fechaLocal = toLocalDateTime(fecha);
		return fechaLocal.getDayOfWeek();
	}
	
	public long horasEntreFechas(Date fechaInicio, Date fechaFin) {
		LocalDateTime fechaInicioLocal = toLocalDateTime(fechaInicio);
		LocalDateTime fechaFinLocal = toLocalDateTime(fechaFin);
		return ChronoUnit.HOURS.between(fechaInicioLocal, fechaFinLocal);
	}
	
	public LocalDateTime toLocalDateTime(Date fecha) {
		return fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	public Date toDate(LocalDateTime fecha) {
		return Date.from(fecha.atZone(ZoneId.systemDefault()).toInstant());
	}

}
