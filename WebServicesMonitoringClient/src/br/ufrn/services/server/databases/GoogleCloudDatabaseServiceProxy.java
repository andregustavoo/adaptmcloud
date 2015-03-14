package br.ufrn.services.server.databases;

public class GoogleCloudDatabaseServiceProxy implements br.ufrn.services.server.databases.GoogleCloudDatabaseService {
  private String _endpoint = null;
  private br.ufrn.services.server.databases.GoogleCloudDatabaseService googleCloudDatabaseService = null;
  
  public GoogleCloudDatabaseServiceProxy() {
    _initGoogleCloudDatabaseServiceProxy();
  }
  
  public GoogleCloudDatabaseServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initGoogleCloudDatabaseServiceProxy();
  }
  
  private void _initGoogleCloudDatabaseServiceProxy() {
    try {
      googleCloudDatabaseService = (new br.ufrn.services.server.databases.GoogleCloudDatabaseServiceServiceLocator()).getGoogleCloudDatabaseService();
      if (googleCloudDatabaseService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)googleCloudDatabaseService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)googleCloudDatabaseService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (googleCloudDatabaseService != null)
      ((javax.xml.rpc.Stub)googleCloudDatabaseService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.ufrn.services.server.databases.GoogleCloudDatabaseService getGoogleCloudDatabaseService() {
    if (googleCloudDatabaseService == null)
      _initGoogleCloudDatabaseServiceProxy();
    return googleCloudDatabaseService;
  }
  
  public double connectDatabaseGoogleCloud(java.lang.String host, java.lang.String user, java.lang.String pwd) throws java.rmi.RemoteException{
    if (googleCloudDatabaseService == null)
      _initGoogleCloudDatabaseServiceProxy();
    return googleCloudDatabaseService.connectDatabaseGoogleCloud(host, user, pwd);
  }
  
  
}