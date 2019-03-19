package com.ceiba.induccion.infraestructura.wsdl;

public interface TCRMServicesWebService extends javax.xml.rpc.Service {
	public java.lang.String getTCRMServicesWebServicePortAddress();

	public TCRMServicesInterface getTCRMServicesWebServicePort() throws javax.xml.rpc.ServiceException;

	public TCRMServicesInterface getTCRMServicesWebServicePort(java.net.URL portAddress)
			throws javax.xml.rpc.ServiceException;
}
