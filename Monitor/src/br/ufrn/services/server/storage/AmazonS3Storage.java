/**
 * AmazonS3Storage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.ufrn.services.server.storage;

public interface AmazonS3Storage extends java.rmi.Remote {
    public boolean getFile(java.lang.String accessKey, java.lang.String secretKey, java.lang.String bucketName, java.lang.String fileName) throws java.rmi.RemoteException;
}
