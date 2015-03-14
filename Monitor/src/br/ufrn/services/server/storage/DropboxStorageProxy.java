package br.ufrn.services.server.storage;

public class DropboxStorageProxy implements br.ufrn.services.server.storage.DropboxStorage {
  private String _endpoint = null;
  private br.ufrn.services.server.storage.DropboxStorage dropboxStorage = null;
  
  public DropboxStorageProxy() {
    _initDropboxStorageProxy();
  }
  
  public DropboxStorageProxy(String endpoint) {
    _endpoint = endpoint;
    _initDropboxStorageProxy();
  }
  
  private void _initDropboxStorageProxy() {
    try {
      dropboxStorage = (new br.ufrn.services.server.storage.DropboxStorageServiceLocator()).getDropboxStorage();
      if (dropboxStorage != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)dropboxStorage)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)dropboxStorage)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (dropboxStorage != null)
      ((javax.xml.rpc.Stub)dropboxStorage)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.ufrn.services.server.storage.DropboxStorage getDropboxStorage() {
    if (dropboxStorage == null)
      _initDropboxStorageProxy();
    return dropboxStorage;
  }
  
  public boolean getFile(java.lang.String accessToken, java.lang.String file) throws java.rmi.RemoteException{
    if (dropboxStorage == null)
      _initDropboxStorageProxy();
    return dropboxStorage.getFile(accessToken, file);
  }
  
  
}