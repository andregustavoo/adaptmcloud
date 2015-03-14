package br.ufrn.services.server.databases;

public class AmazonRDSServiceProxy implements br.ufrn.services.server.databases.AmazonRDSService {
  private String _endpoint = null;
  private br.ufrn.services.server.databases.AmazonRDSService amazonRDSService = null;
  
  public AmazonRDSServiceProxy() {
    _initAmazonRDSServiceProxy();
  }
  
  public AmazonRDSServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initAmazonRDSServiceProxy();
  }
  
  private void _initAmazonRDSServiceProxy() {
    try {
      amazonRDSService = (new br.ufrn.services.server.databases.AmazonRDSServiceServiceLocator()).getAmazonRDSService();
      if (amazonRDSService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)amazonRDSService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)amazonRDSService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (amazonRDSService != null)
      ((javax.xml.rpc.Stub)amazonRDSService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.ufrn.services.server.databases.AmazonRDSService getAmazonRDSService() {
    if (amazonRDSService == null)
      _initAmazonRDSServiceProxy();
    return amazonRDSService;
  }
  
  public double connectDatabaseAmazon(java.lang.String host, java.lang.String user, java.lang.String pwd) throws java.rmi.RemoteException{
    if (amazonRDSService == null)
      _initAmazonRDSServiceProxy();
    return amazonRDSService.connectDatabaseAmazon(host, user, pwd);
  }
  
  
}