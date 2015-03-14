/**
 * RackspaceDatabaseServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.ufrn.services.server.databases;

public interface RackspaceDatabaseServiceService extends javax.xml.rpc.Service {
    public java.lang.String getRackspaceDatabaseServiceAddress();

    public br.ufrn.services.server.databases.RackspaceDatabaseService getRackspaceDatabaseService() throws javax.xml.rpc.ServiceException;

    public br.ufrn.services.server.databases.RackspaceDatabaseService getRackspaceDatabaseService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
