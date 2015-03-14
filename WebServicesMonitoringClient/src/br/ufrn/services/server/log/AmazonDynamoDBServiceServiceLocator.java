/**
 * AmazonDynamoDBServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.ufrn.services.server.log;

public class AmazonDynamoDBServiceServiceLocator extends org.apache.axis.client.Service implements br.ufrn.services.server.log.AmazonDynamoDBServiceService {

    public AmazonDynamoDBServiceServiceLocator() {
    }


    public AmazonDynamoDBServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AmazonDynamoDBServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AmazonDynamoDBService
    private java.lang.String AmazonDynamoDBService_address = "http://localhost:8080/WebServicesMonitoring/services/AmazonDynamoDBService";

    public java.lang.String getAmazonDynamoDBServiceAddress() {
        return AmazonDynamoDBService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AmazonDynamoDBServiceWSDDServiceName = "AmazonDynamoDBService";

    public java.lang.String getAmazonDynamoDBServiceWSDDServiceName() {
        return AmazonDynamoDBServiceWSDDServiceName;
    }

    public void setAmazonDynamoDBServiceWSDDServiceName(java.lang.String name) {
        AmazonDynamoDBServiceWSDDServiceName = name;
    }

    public br.ufrn.services.server.log.AmazonDynamoDBService getAmazonDynamoDBService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AmazonDynamoDBService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAmazonDynamoDBService(endpoint);
    }

    public br.ufrn.services.server.log.AmazonDynamoDBService getAmazonDynamoDBService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.ufrn.services.server.log.AmazonDynamoDBServiceSoapBindingStub _stub = new br.ufrn.services.server.log.AmazonDynamoDBServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getAmazonDynamoDBServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAmazonDynamoDBServiceEndpointAddress(java.lang.String address) {
        AmazonDynamoDBService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.ufrn.services.server.log.AmazonDynamoDBService.class.isAssignableFrom(serviceEndpointInterface)) {
                br.ufrn.services.server.log.AmazonDynamoDBServiceSoapBindingStub _stub = new br.ufrn.services.server.log.AmazonDynamoDBServiceSoapBindingStub(new java.net.URL(AmazonDynamoDBService_address), this);
                _stub.setPortName(getAmazonDynamoDBServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("AmazonDynamoDBService".equals(inputPortName)) {
            return getAmazonDynamoDBService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://log.server.services.ufrn.br", "AmazonDynamoDBServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://log.server.services.ufrn.br", "AmazonDynamoDBService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AmazonDynamoDBService".equals(portName)) {
            setAmazonDynamoDBServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
