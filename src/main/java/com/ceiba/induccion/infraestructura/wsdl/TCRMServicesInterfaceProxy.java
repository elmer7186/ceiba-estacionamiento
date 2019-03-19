package com.ceiba.induccion.infraestructura.wsdl;

import java.util.logging.Logger;

public class TCRMServicesInterfaceProxy implements TCRMServicesInterface {

	private static final Logger LOGGER = Logger.getLogger(TCRMServicesInterfaceProxy.class.getName());
	private static final String XML_ADDRESS = "javax.xml.rpc.service.endpoint.address";
	private String xendpoint = null;
	private TCRMServicesInterface tcrmServicesInterface = null;

	public TCRMServicesInterfaceProxy() {
		xinitTCRMServicesInterfaceProxy();
	}

	public TCRMServicesInterfaceProxy(String endpoint) {
		xendpoint = endpoint;
		xinitTCRMServicesInterfaceProxy();
	}

	private void xinitTCRMServicesInterfaceProxy() {
		try {
			tcrmServicesInterface = (new TCRMServicesWebServiceLocator()).getTCRMServicesWebServicePort();
			if (tcrmServicesInterface != null) {
				if (xendpoint != null)
					((javax.xml.rpc.Stub) tcrmServicesInterface)._setProperty(XML_ADDRESS, xendpoint);
				else
					xendpoint = (String) ((javax.xml.rpc.Stub) tcrmServicesInterface)._getProperty(XML_ADDRESS);
			}

		} catch (javax.xml.rpc.ServiceException serviceException) {
			LOGGER.log(LOGGER.getLevel(), "Error TRM", serviceException);
		}
	}

	public String getEndpoint() {
		return xendpoint;
	}

	public void setEndpoint(String endpoint) {
		xendpoint = endpoint;
		if (tcrmServicesInterface != null)
			((javax.xml.rpc.Stub) tcrmServicesInterface)._setProperty(XML_ADDRESS, xendpoint);

	}

	public TCRMServicesInterface getTCRMServicesInterface() {
		if (tcrmServicesInterface == null)
			xinitTCRMServicesInterfaceProxy();
		return tcrmServicesInterface;
	}

	public TcrmResponse queryTCRM(java.util.Calendar tcrmQueryAssociatedDate) throws java.rmi.RemoteException {
		if (tcrmServicesInterface == null)
			xinitTCRMServicesInterfaceProxy();
		return tcrmServicesInterface.queryTCRM(tcrmQueryAssociatedDate);
	}

}