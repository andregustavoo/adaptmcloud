/**
 * DropboxStorageServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.ufrn.services.server.storage;

public class DropboxStorageServiceLocator extends org.apache.axis.client.Service implements br.ufrn.services.server.storage.DropboxStorageService {

    public DropboxStorageServiceLocator() {
    }


    public DropboxStorageServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DropboxStorageServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for DropboxStorage
    private java.lang.String DropboxStorage_address = "http://localhost:8080/WebServicesMonitoring/services/DropboxStorage";

    public java.lang.String getDropboxStorageAddress() {
        return DropboxStorage_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DropboxStorageWSDDServiceName = "DropboxStorage";

    public java.lang.String getDropboxStorageWSDDServiceName() {
        return DropboxStorageWSDDServiceName;
    }

    public void setDropboxStorageWSDDServiceName(java.lang.String name) {
        DropboxStorageWSDDServiceName = name;
    }

    public br.ufrn.services.server.storage.DropboxStorage getDropboxStorage() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DropboxStorage_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDropboxStorage(endpoint);
    }

    public br.ufrn.services.server.storage.DropboxStorage getDropboxStorage(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.ufrn.services.server.storage.DropboxStorageSoapBindingStub _stub = new br.ufrn.services.server.storage.DropboxStorageSoapBindingStub(portAddress, this);
            _stub.setPortName(getDropboxStorageWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDropboxStorageEndpointAddress(java.lang.String address) {
        DropboxStorage_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.ufrn.services.server.storage.DropboxStorage.class.isAssignableFrom(serviceEndpointInterface)) {
                br.ufrn.services.server.storage.DropboxStorageSoapBindingStub _stub = new br.ufrn.services.server.storage.DropboxStorageSoapBindingStub(new java.net.URL(DropboxStorage_address), this);
                _stub.setPortName(getDropboxStorageWSDDServiceName());
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
        if ("DropboxStorage".equals(inputPortName)) {
            return getDropboxStorage();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://storage.services.ufrn.br", "DropboxStorageService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://storage.services.ufrn.br", "DropboxStorage"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("DropboxStorage".equals(portName)) {
            setDropboxStorageEndpointAddress(address);
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
