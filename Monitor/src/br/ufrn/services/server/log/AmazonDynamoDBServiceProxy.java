package br.ufrn.services.server.log;

public class AmazonDynamoDBServiceProxy implements br.ufrn.services.server.log.AmazonDynamoDBService {
  private String _endpoint = null;
  private br.ufrn.services.server.log.AmazonDynamoDBService amazonDynamoDBService = null;
  
  public AmazonDynamoDBServiceProxy() {
    _initAmazonDynamoDBServiceProxy();
  }
  
  public AmazonDynamoDBServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initAmazonDynamoDBServiceProxy();
  }
  
  private void _initAmazonDynamoDBServiceProxy() {
    try {
      amazonDynamoDBService = (new br.ufrn.services.server.log.AmazonDynamoDBServiceServiceLocator()).getAmazonDynamoDBService();
      if (amazonDynamoDBService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)amazonDynamoDBService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)amazonDynamoDBService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (amazonDynamoDBService != null)
      ((javax.xml.rpc.Stub)amazonDynamoDBService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.ufrn.services.server.log.AmazonDynamoDBService getAmazonDynamoDBService() {
    if (amazonDynamoDBService == null)
      _initAmazonDynamoDBServiceProxy();
    return amazonDynamoDBService;
  }
  
  public java.lang.String getItem(java.lang.String accessKey, java.lang.String secretKey, java.lang.String keyItem) throws java.rmi.RemoteException{
    if (amazonDynamoDBService == null)
      _initAmazonDynamoDBServiceProxy();
    return amazonDynamoDBService.getItem(accessKey, secretKey, keyItem);
  }
  
  
}