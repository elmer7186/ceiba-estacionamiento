package com.ceiba.induccion.infraestructura.wsdl;

/**
 * TCRM business class
 * 
 * @author Alex Vicente Chacon Jimenez (alex.chacon@software-colombia.com)
 */
public class Tcrm implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private static final String XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";

	private java.lang.Boolean displayToUser;

	private java.lang.Long id;

	private java.lang.String unit;

	private java.util.Calendar validityFrom;

	private java.util.Calendar validityTo;

	private java.lang.Float value;

	public Tcrm() {
		// constructor vacio
	}

	/**
	 * Gets the displayToUser value for this Tcrm.
	 * 
	 * @return displayToUser
	 */
	public java.lang.Boolean getDisplayToUser() {
		return displayToUser;
	}

	/**
	 * Sets the displayToUser value for this Tcrm.
	 * 
	 * @param displayToUser
	 */
	public void setDisplayToUser(java.lang.Boolean displayToUser) {
		this.displayToUser = displayToUser;
	}

	/**
	 * Gets the id value for this Tcrm.
	 * 
	 * @return id
	 */
	public java.lang.Long getId() {
		return id;
	}

	/**
	 * Sets the id value for this Tcrm.
	 * 
	 * @param id
	 */
	public void setId(java.lang.Long id) {
		this.id = id;
	}

	/**
	 * Gets the unit value for this Tcrm.
	 * 
	 * @return unit
	 */
	public java.lang.String getUnit() {
		return unit;
	}

	/**
	 * Sets the unit value for this Tcrm.
	 * 
	 * @param unit
	 */
	public void setUnit(java.lang.String unit) {
		this.unit = unit;
	}

	/**
	 * Gets the validityFrom value for this Tcrm.
	 * 
	 * @return validityFrom
	 */
	public java.util.Calendar getValidityFrom() {
		return validityFrom;
	}

	/**
	 * Sets the validityFrom value for this Tcrm.
	 * 
	 * @param validityFrom
	 */
	public void setValidityFrom(java.util.Calendar validityFrom) {
		this.validityFrom = validityFrom;
	}

	/**
	 * Gets the validityTo value for this Tcrm.
	 * 
	 * @return validityTo
	 */
	public java.util.Calendar getValidityTo() {
		return validityTo;
	}

	/**
	 * Sets the validityTo value for this Tcrm.
	 * 
	 * @param validityTo
	 */
	public void setValidityTo(java.util.Calendar validityTo) {
		this.validityTo = validityTo;
	}

	/**
	 * Gets the value value for this Tcrm.
	 * 
	 * @return value
	 */
	public java.lang.Float getValue() {
		return value;
	}

	/**
	 * Sets the value value for this Tcrm.
	 * 
	 * @param value
	 */
	public void setValue(java.lang.Float value) {
		this.value = value;
	}

	private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(Tcrm.class,
			true);

	static {
		typeDesc.setXmlType(new javax.xml.namespace.QName(
				"http://action.trm.services.generic.action.superfinanciera.nexura.sc.com.co/", "tcrm"));
		org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("displayToUser");
		elemField.setXmlName(new javax.xml.namespace.QName("", "displayToUser"));
		elemField.setXmlType(new javax.xml.namespace.QName(XML_SCHEMA, "boolean"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("id");
		elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
		elemField.setXmlType(new javax.xml.namespace.QName(XML_SCHEMA, "long"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("unit");
		elemField.setXmlName(new javax.xml.namespace.QName("", "unit"));
		elemField.setXmlType(new javax.xml.namespace.QName(XML_SCHEMA, "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("validityFrom");
		elemField.setXmlName(new javax.xml.namespace.QName("", "validityFrom"));
		elemField.setXmlType(new javax.xml.namespace.QName(XML_SCHEMA, "dateTime"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("validityTo");
		elemField.setXmlName(new javax.xml.namespace.QName("", "validityTo"));
		elemField.setXmlType(new javax.xml.namespace.QName(XML_SCHEMA, "dateTime"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("value");
		elemField.setXmlName(new javax.xml.namespace.QName("", "value"));
		elemField.setXmlType(new javax.xml.namespace.QName(XML_SCHEMA, "float"));
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
	public static org.apache.axis.encoding.Serializer getSerializer(java.lang.Class<?> xjavaType,
			javax.xml.namespace.QName xxmlType) {
		return new org.apache.axis.encoding.ser.BeanSerializer(xjavaType, xxmlType, typeDesc);
	}

	/**
	 * Get Custom Deserializer
	 */
	public static org.apache.axis.encoding.Deserializer getDeserializer(java.lang.Class<?> javaType,
			javax.xml.namespace.QName xmlType) {
		return new org.apache.axis.encoding.ser.BeanDeserializer(javaType, xmlType, typeDesc);
	}

}
