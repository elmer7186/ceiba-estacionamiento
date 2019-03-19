package com.ceiba.induccion.infraestructura.wsdl;

/**
 * Business TCRM response
 * 
 * @author Alex Vicente Chacon Jimenez (alex.chacon@software-colombia.com)
 *
 */
public class TcrmResponse extends Tcrm implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private java.lang.String message;

	private java.lang.Boolean success;

	public TcrmResponse() {
		// constructor vacio
	}

	/**
	 * Gets the message value for this TcrmResponse.
	 * 
	 * @return message
	 */
	public java.lang.String getMessage() {
		return message;
	}

	/**
	 * Sets the message value for this TcrmResponse.
	 * 
	 * @param message
	 */
	public void setMessage(java.lang.String message) {
		this.message = message;
	}

	/**
	 * Gets the success value for this TcrmResponse.
	 * 
	 * @return success
	 */
	public java.lang.Boolean getSuccess() {
		return success;
	}

	/**
	 * Sets the success value for this TcrmResponse.
	 * 
	 * @param success
	 */
	public void setSuccess(java.lang.Boolean success) {
		this.success = success;
	}

	private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
			TcrmResponse.class, true);

	static {
		typeDesc.setXmlType(new javax.xml.namespace.QName(
				"http://action.trm.services.generic.action.superfinanciera.nexura.sc.com.co/", "tcrmResponse"));
		org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("message");
		elemField.setXmlName(new javax.xml.namespace.QName("", "message"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("success");
		elemField.setXmlName(new javax.xml.namespace.QName("", "success"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
	}

	/**
	 * Return type metadata object
	 */
	public static org.apache.axis.description.TypeDesc getTypeDesc() {
		return typeDesc;
	}

	/**
	 * Get Custom Serializer
	 */
	public static org.apache.axis.encoding.Serializer getSerializer(java.lang.Class<?> javaType,
			javax.xml.namespace.QName xmlType) {
		return new org.apache.axis.encoding.ser.BeanSerializer(javaType, xmlType, typeDesc);
	}

	/**
	 * Get Custom Deserializer
	 */
	public static org.apache.axis.encoding.Deserializer getDeserializer(java.lang.Class<?> javaType,
			javax.xml.namespace.QName xmlType) {
		return new org.apache.axis.encoding.ser.BeanDeserializer(javaType, xmlType, typeDesc);
	}

}
