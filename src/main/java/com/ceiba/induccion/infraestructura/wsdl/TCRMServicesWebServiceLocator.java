package com.ceiba.induccion.infraestructura.wsdl;

import java.net.MalformedURLException;

public class TCRMServicesWebServiceLocator extends org.apache.axis.client.Service implements TCRMServicesWebService {

	private static final long serialVersionUID = 1L;

	private static final String TCRM_SERVICE_PORT = "TCRMServicesWebServicePort";

	public TCRMServicesWebServiceLocator() {
	}

	public TCRMServicesWebServiceLocator(org.apache.axis.EngineConfiguration config) {
		super(config);
	}

	public TCRMServicesWebServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName)
			throws javax.xml.rpc.ServiceException {
		super(wsdlLoc, sName);
	}

	private java.lang.String tcrmServicesWebServicePortxaddress = "http://AlexChacon:8080/SuperfinancieraWebServiceTRM/TCRMServicesWebService/TCRMServicesWebService";

	public java.lang.String getTCRMServicesWebServicePortAddress() {
		return tcrmServicesWebServicePortxaddress;
	}

	private java.lang.String tcrmServicesWebServicePortWSDDServiceName = TCRM_SERVICE_PORT;

	public java.lang.String getTCRMServicesWebServicePortWSDDServiceName() {
		return tcrmServicesWebServicePortWSDDServiceName;
	}

	public void setTCRMServicesWebServicePortWSDDServiceName(java.lang.String name) {
		tcrmServicesWebServicePortWSDDServiceName = name;
	}

	public TCRMServicesInterface getTCRMServicesWebServicePort() throws javax.xml.rpc.ServiceException {
		java.net.URL endpoint;
		try {
			endpoint = new java.net.URL(tcrmServicesWebServicePortxaddress);
		} catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}
		return getTCRMServicesWebServicePort(endpoint);
	}

	public TCRMServicesInterface getTCRMServicesWebServicePort(java.net.URL portAddress)
			throws javax.xml.rpc.ServiceException {
		TCRMServicesWebServiceSoapBindingStub xstub = new TCRMServicesWebServiceSoapBindingStub(portAddress, this);
		xstub.setPortName(getTCRMServicesWebServicePortWSDDServiceName());
		return xstub;
	}

	public void setTCRMServicesWebServicePortEndpointAddress(java.lang.String address) {
		tcrmServicesWebServicePortxaddress = address;
	}

	/**
	 * For the given interface, get the stub implementation. If this service has no
	 * port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(@SuppressWarnings("rawtypes") Class serviceEndpointInterface)
			throws javax.xml.rpc.ServiceException {
		try {
			if (TCRMServicesInterface.class.isAssignableFrom(serviceEndpointInterface)) {
				TCRMServicesWebServiceSoapBindingStub xstub = new TCRMServicesWebServiceSoapBindingStub(
						new java.net.URL(tcrmServicesWebServicePortxaddress), this);
				xstub.setPortName(getTCRMServicesWebServicePortWSDDServiceName());
				return xstub;
			}
		} catch (MalformedURLException t) {
			throw new javax.xml.rpc.ServiceException(t);
		}
		throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  "
				+ (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
	}

	/**
	 * For the given interface, get the stub implementation. If this service has no
	 * port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(javax.xml.namespace.QName portName,
			@SuppressWarnings("rawtypes") Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
		if (portName == null) {
			return getPort(serviceEndpointInterface);
		}
		java.lang.String inputPortName = portName.getLocalPart();
		if (TCRM_SERVICE_PORT.equals(inputPortName)) {
			return getTCRMServicesWebServicePort();
		} else {
			java.rmi.Remote xstub = getPort(serviceEndpointInterface);
			((org.apache.axis.client.Stub) xstub).setPortName(portName);
			return xstub;
		}
	}

	public javax.xml.namespace.QName getServiceName() {
		return new javax.xml.namespace.QName(
				"http://action.trm.services.generic.action.superfinanciera.nexura.sc.com.co/",
				"TCRMServicesWebService");
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(java.lang.String portName, java.lang.String address)
			throws javax.xml.rpc.ServiceException {

		if (TCRM_SERVICE_PORT.equals(portName)) {
			setTCRMServicesWebServicePortEndpointAddress(address);
		} else { // Unknown Port Name
			throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
		}
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address)
			throws javax.xml.rpc.ServiceException {
		setEndpointAddress(portName.getLocalPart(), address);
	}

}
