/**
 * RackspaceStorageServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.ufrn.services.server.storage;

public class RackspaceStorageServiceLocator extends org.apache.axis.client.Service implements br.ufrn.services.server.storage.RackspaceStorageService {

    public RackspaceStorageServiceLocator() {
    }


    public RackspaceStorageServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public RackspaceStorageServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for RackspaceStorage
    private java.lang.String RackspaceStorage_address = "http://localhost:8080/WebServicesMonitoring/services/RackspaceStorage";

    public java.lang.String getRackspaceStorageAddress() {
        return RackspaceStorage_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String RackspaceStorageWSDDServiceName = "RackspaceStorage";

    public java.lang.String getRackspaceStorageWSDDServiceName() {
        return RackspaceStorageWSDDServiceName;
    }

    public void setRackspaceStorageWSDDServiceName(java.lang.String name) {
        RackspaceStorageWSDDServiceName = name;
    }

    public br.ufrn.services.server.storage.RackspaceStorage getRackspaceStorage() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(RackspaceStorage_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getRackspaceStorage(endpoint);
    }

    public br.ufrn.services.server.storage.RackspaceStorage getRackspaceStorage(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.ufrn.services.server.storage.RackspaceStorageSoapBindingStub _stub = new br.ufrn.services.server.storage.RackspaceStorageSoapBindingStub(portAddress, this);
            _stub.setPortName(getRackspaceStorageWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setRackspaceStorageEndpointAddress(java.lang.String address) {
        RackspaceStorage_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.ufrn.services.server.storage.RackspaceStorage.class.isAssignableFrom(serviceEndpointInterface)) {
                br.ufrn.services.server.storage.RackspaceStorageSoapBindingStub _stub = new br.ufrn.services.server.storage.RackspaceStorageSoapBindingStub(new java.net.URL(RackspaceStorage_address), this);
                _stub.setPortName(getRackspaceStorageWSDDServiceName());
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
        if ("RackspaceStorage".equals(inputPortName)) {
            return getRackspaceStorage();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://storage.services.ufrn.br", "RackspaceStorageService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://storage.services.ufrn.br", "RackspaceStorage"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("RackspaceStorage".equals(portName)) {
            setRackspaceStorageEndpointAddress(address);
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
