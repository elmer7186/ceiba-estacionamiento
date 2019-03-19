package com.ceiba.induccion.infraestructura.wsdl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

public class TCRMServicesWebServiceSoapBindingStub extends org.apache.axis.client.Stub
		implements TCRMServicesInterface {

	private static final String URL_ACTION = "http://action.trm.services.generic.action.superfinanciera.nexura.sc.com.co/";

	private List<Class<?>> cachedSerClasses = new ArrayList<>();
	private List<QName> cachedSerQNames = new ArrayList<>();
	private List<Class<?>> cachedSerFactories = new ArrayList<>();
	private List<Class<?>> cachedDeserFactories = new ArrayList<>();

	static org.apache.axis.description.OperationDesc[] xoperations;

	static {
		xoperations = new org.apache.axis.description.OperationDesc[1];
		xinitOperationDesc1();
	}

	private static void xinitOperationDesc1() {
		org.apache.axis.description.OperationDesc oper;
		org.apache.axis.description.ParameterDesc param;
		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("queryTCRM");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("", "tcrmQueryAssociatedDate"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class,
				false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(URL_ACTION, "tcrmResponse"));
		oper.setReturnClass(TcrmResponse.class);
		oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		xoperations[0] = oper;

	}

	public TCRMServicesWebServiceSoapBindingStub() throws org.apache.axis.AxisFault {
		this(null);
	}

	public TCRMServicesWebServiceSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) {
		this(service);
		super.cachedEndpoint = endpointURL;
	}

	public TCRMServicesWebServiceSoapBindingStub(javax.xml.rpc.Service service) {
		if (service == null) {
			super.service = new org.apache.axis.client.Service();
		} else {
			super.service = service;
		}
		((org.apache.axis.client.Service) super.service).setTypeMappingVersion("1.2");
		java.lang.Class<?> cls;
		javax.xml.namespace.QName qName;
		java.lang.Class<?> beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
		java.lang.Class<?> beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
		qName = new javax.xml.namespace.QName(URL_ACTION, "tcrm");
		cachedSerQNames.add(qName);
		cls = Tcrm.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(URL_ACTION, "tcrmResponse");
		cachedSerQNames.add(qName);
		cls = TcrmResponse.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

	}

	protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
		try {
			org.apache.axis.client.Call xcall = super._createCall();
			xcall = validarXCall(xcall);
			java.util.Enumeration<?> keys = super.cachedProperties.keys();
			while (keys.hasMoreElements()) {
				java.lang.String key = (java.lang.String) keys.nextElement();
				xcall.setProperty(key, super.cachedProperties.get(key));
			}
			// All the type mapping information is registered
			// when the first call is made.
			// The type mapping information is actually registered in
			// the TypeMappingRegistry of the service, which
			// is the reason why registration is only needed for the first call.
			synchronized (this) {
				if (firstCall()) {
					// must set encoding style before registering serializers
					xcall.setEncodingStyle(null);
					for (int i = 0; i < cachedSerFactories.size(); ++i) {
						java.lang.Class<?> cls = cachedSerClasses.get(i);
						javax.xml.namespace.QName qName = cachedSerQNames.get(i);
						java.lang.Object x = cachedSerFactories.get(i);
						if (x instanceof Class) {
							java.lang.Class<?> sf = cachedSerFactories.get(i);
							java.lang.Class<?> df = cachedDeserFactories.get(i);
							xcall.registerTypeMapping(cls, qName, sf, df, false);
						}
					}
				}
			}
			return xcall;
		} catch (ServiceException xt) {
			throw new org.apache.axis.AxisFault("Failure trying to get the Call object", xt);
		}
	}

	private org.apache.axis.client.Call validarXCall(org.apache.axis.client.Call xcall) {
		if (super.maintainSessionSet) {
			xcall.setMaintainSession(super.maintainSession);
		}
		if (super.cachedUsername != null) {
			xcall.setUsername(super.cachedUsername);
		}
		if (super.cachedPassword != null) {
			xcall.setPassword(super.cachedPassword);
		}
		if (super.cachedEndpoint != null) {
			xcall.setTargetEndpointAddress(super.cachedEndpoint);
		}
		if (super.cachedTimeout != null) {
			xcall.setTimeout(super.cachedTimeout);
		}
		if (super.cachedPortName != null) {
			xcall.setPortName(super.cachedPortName);
		}
		return xcall;
	}

	public TcrmResponse queryTCRM(java.util.Calendar tcrmQueryAssociatedDate) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call xcall = createCall();
		xcall.setOperation(xoperations[0]);
		xcall.setUseSOAPAction(true);
		xcall.setSOAPActionURI("");
		xcall.setEncodingStyle(null);
		xcall.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
		xcall.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
		xcall.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		xcall.setOperationName(new javax.xml.namespace.QName(URL_ACTION, "queryTCRM"));

		setRequestHeaders(xcall);
		setAttachments(xcall);
		java.lang.Object xresp = xcall.invoke(new java.lang.Object[] { tcrmQueryAssociatedDate });

		if (xresp instanceof java.rmi.RemoteException) {
			throw (java.rmi.RemoteException) xresp;
		} else {
			extractAttachments(xcall);
			try {
				return (TcrmResponse) xresp;
			} catch (java.lang.Exception exception) {
				return (TcrmResponse) org.apache.axis.utils.JavaUtils.convert(xresp, TcrmResponse.class);
			}
		}
	}

}
