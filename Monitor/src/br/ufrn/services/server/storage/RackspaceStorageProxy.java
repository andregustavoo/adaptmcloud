package br.ufrn.services.server.storage;

public class RackspaceStorageProxy implements br.ufrn.services.server.storage.RackspaceStorage {
  private String _endpoint = null;
  private br.ufrn.services.server.storage.RackspaceStorage rackspaceStorage = null;
  
  public RackspaceStorageProxy() {
    _initRackspaceStorageProxy();
  }
  
  public RackspaceStorageProxy(String endpoint) {
    _endpoint = endpoint;
    _initRackspaceStorageProxy();
  }
  
  private void _initRackspaceStorageProxy() {
    try {
      rackspaceStorage = (new br.ufrn.services.server.storage.RackspaceStorageServiceLocator()).getRackspaceStorage();
      if (rackspaceStorage != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)rackspaceStorage)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)rackspaceStorage)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (rackspaceStorage != null)
      ((javax.xml.rpc.Stub)rackspaceStorage)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.ufrn.services.server.storage.RackspaceStorage getRackspaceStorage() {
    if (rackspaceStorage == null)
      _initRackspaceStorageProxy();
    return rackspaceStorage;
  }
  
  public boolean getFile(java.lang.String user, java.lang.String apiKey, java.lang.String region, java.lang.String container, java.lang.String file) throws java.rmi.RemoteException{
    if (rackspaceStorage == null)
      _initRackspaceStorageProxy();
    return rackspaceStorage.getFile(user, apiKey, region, container, file);
  }
  
  
}