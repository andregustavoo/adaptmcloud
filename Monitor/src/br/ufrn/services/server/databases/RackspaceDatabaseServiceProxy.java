package br.ufrn.services.server.databases;

public class RackspaceDatabaseServiceProxy implements br.ufrn.services.server.databases.RackspaceDatabaseService {
  private String _endpoint = null;
  private br.ufrn.services.server.databases.RackspaceDatabaseService rackspaceDatabaseService = null;
  
  public RackspaceDatabaseServiceProxy() {
    _initRackspaceDatabaseServiceProxy();
  }
  
  public RackspaceDatabaseServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initRackspaceDatabaseServiceProxy();
  }
  
  private void _initRackspaceDatabaseServiceProxy() {
    try {
      rackspaceDatabaseService = (new br.ufrn.services.server.databases.RackspaceDatabaseServiceServiceLocator()).getRackspaceDatabaseService();
      if (rackspaceDatabaseService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)rackspaceDatabaseService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)rackspaceDatabaseService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (rackspaceDatabaseService != null)
      ((javax.xml.rpc.Stub)rackspaceDatabaseService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.ufrn.services.server.databases.RackspaceDatabaseService getRackspaceDatabaseService() {
    if (rackspaceDatabaseService == null)
      _initRackspaceDatabaseServiceProxy();
    return rackspaceDatabaseService;
  }
  
  public double connectDatabaseRackspace(java.lang.String host, java.lang.String user, java.lang.String pwd) throws java.rmi.RemoteException{
    if (rackspaceDatabaseService == null)
      _initRackspaceDatabaseServiceProxy();
    return rackspaceDatabaseService.connectDatabaseRackspace(host, user, pwd);
  }
  
  
}