/**
 * DropboxStorageService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.ufrn.services.server.storage;

public interface DropboxStorageService extends javax.xml.rpc.Service {
    public java.lang.String getDropboxStorageAddress();

    public br.ufrn.services.server.storage.DropboxStorage getDropboxStorage() throws javax.xml.rpc.ServiceException;

    public br.ufrn.services.server.storage.DropboxStorage getDropboxStorage(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
