package com.ceiba.induccion.aplicacion.command;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.induccion.infraestructura.wsdl.TCRMServicesInterfaceProxy;
import com.ceiba.induccion.infraestructura.wsdl.TcrmResponse;

@Service
@Transactional
public class ConsultarTrmActualCommand {
	private static final String CTRM_SERVICE_URL = "https://www.superfinanciera.gov.co/SuperfinancieraWebServiceTRM/TCRMServicesWebService/TCRMServicesWebService?WSDL";

	public Float execute() throws RemoteException {
		TCRMServicesInterfaceProxy proxy = new TCRMServicesInterfaceProxy(CTRM_SERVICE_URL);
		TcrmResponse tcrmResponse = proxy.queryTCRM(null);
		return tcrmResponse.getValue();
	}
}
