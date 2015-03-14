package br.ufrn.services.server.storage;

public class AmazonS3StorageProxy implements br.ufrn.services.server.storage.AmazonS3Storage {
  private String _endpoint = null;
  private br.ufrn.services.server.storage.AmazonS3Storage amazonS3Storage = null;
  
  public AmazonS3StorageProxy() {
    _initAmazonS3StorageProxy();
  }
  
  public AmazonS3StorageProxy(String endpoint) {
    _endpoint = endpoint;
    _initAmazonS3StorageProxy();
  }
  
  private void _initAmazonS3StorageProxy() {
    try {
      amazonS3Storage = (new br.ufrn.services.server.storage.AmazonS3StorageServiceLocator()).getAmazonS3Storage();
      if (amazonS3Storage != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)amazonS3Storage)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)amazonS3Storage)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (amazonS3Storage != null)
      ((javax.xml.rpc.Stub)amazonS3Storage)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.ufrn.services.server.storage.AmazonS3Storage getAmazonS3Storage() {
    if (amazonS3Storage == null)
      _initAmazonS3StorageProxy();
    return amazonS3Storage;
  }
  
  public boolean getFile(java.lang.String accessKey, java.lang.String secretKey, java.lang.String bucketName, java.lang.String fileName) throws java.rmi.RemoteException{
    if (amazonS3Storage == null)
      _initAmazonS3StorageProxy();
    return amazonS3Storage.getFile(accessKey, secretKey, bucketName, fileName);
  }
  
  
}