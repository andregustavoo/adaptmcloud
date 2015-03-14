/**
 * AmazonS3StorageServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.ufrn.services.server.storage;

public class AmazonS3StorageServiceLocator extends org.apache.axis.client.Service implements br.ufrn.services.server.storage.AmazonS3StorageService {

    public AmazonS3StorageServiceLocator() {
    }


    public AmazonS3StorageServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AmazonS3StorageServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AmazonS3Storage
    private java.lang.String AmazonS3Storage_address = "http://localhost:8080/WebServicesMonitoring/services/AmazonS3Storage";

    public java.lang.String getAmazonS3StorageAddress() {
        return AmazonS3Storage_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AmazonS3StorageWSDDServiceName = "AmazonS3Storage";

    public java.lang.String getAmazonS3StorageWSDDServiceName() {
        return AmazonS3StorageWSDDServiceName;
    }

    public void setAmazonS3StorageWSDDServiceName(java.lang.String name) {
        AmazonS3StorageWSDDServiceName = name;
    }

    public br.ufrn.services.server.storage.AmazonS3Storage getAmazonS3Storage() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AmazonS3Storage_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAmazonS3Storage(endpoint);
    }

    public br.ufrn.services.server.storage.AmazonS3Storage getAmazonS3Storage(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.ufrn.services.server.storage.AmazonS3StorageSoapBindingStub _stub = new br.ufrn.services.server.storage.AmazonS3StorageSoapBindingStub(portAddress, this);
            _stub.setPortName(getAmazonS3StorageWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAmazonS3StorageEndpointAddress(java.lang.String address) {
        AmazonS3Storage_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.ufrn.services.server.storage.AmazonS3Storage.class.isAssignableFrom(serviceEndpointInterface)) {
                br.ufrn.services.server.storage.AmazonS3StorageSoapBindingStub _stub = new br.ufrn.services.server.storage.AmazonS3StorageSoapBindingStub(new java.net.URL(AmazonS3Storage_address), this);
                _stub.setPortName(getAmazonS3StorageWSDDServiceName());
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
        if ("AmazonS3Storage".equals(inputPortName)) {
            return getAmazonS3Storage();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://storage.services.ufrn.br", "AmazonS3StorageService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://storage.services.ufrn.br", "AmazonS3Storage"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AmazonS3Storage".equals(portName)) {
            setAmazonS3StorageEndpointAddress(address);
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
