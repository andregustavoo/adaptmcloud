package fachada.servidor;

import java.lang.reflect.Method;
import java.rmi.RemoteException;

import br.ufrn.services.server.databases.AmazonRDSServiceProxy;
import br.ufrn.services.server.databases.GoogleCloudDatabaseServiceProxy;
import br.ufrn.services.server.databases.RackspaceDatabaseServiceProxy;
import br.ufrn.services.server.log.AmazonDynamoDBServiceProxy;
import br.ufrn.services.server.storage.AmazonS3StorageProxy;
import br.ufrn.services.server.storage.DropboxStorageProxy;
import br.ufrn.services.server.storage.RackspaceStorageProxy;
import repositorio.servico.Servico;

public class FachadaServidor {
	//Casos
	private static FachadaServidor singleton;
	
	private FachadaServidor(){
	}
	
	public static FachadaServidor getInstance(){
		if(singleton == null){
			singleton = new FachadaServidor();
		}
		return singleton;
	}
	
	public Long callService(Servico servico) throws Exception{
			Class<?> c = Class.forName("fachada.servidor.FachadaServidor");
			Method metodo = c.getDeclaredMethod(servico.getNome(), new Class<?>[] {});
			Long t1 = System.nanoTime();
			metodo.invoke(this, new Object[] {});
			Long t2 = System.nanoTime();
			return (t2-t1);
		
	}
	
	public void AmazonRDS() throws RemoteException{
		AmazonRDSServiceProxy proxy=new AmazonRDSServiceProxy();
		String host="";
		String user="";
		String pwd="";
		double sum;
			sum = proxy.connectDatabaseAmazon(host, user, pwd);
			System.out.println(sum);
		
	}
	public void GoogleCloudSQL() throws RemoteException{
		GoogleCloudDatabaseServiceProxy proxy=new GoogleCloudDatabaseServiceProxy();
		String host="";
		String user="";
		String pwd="";
		double sum;
			sum = proxy.connectDatabaseGoogleCloud(host, user, pwd);
			System.out.println(sum);
		
	}
	public void RackspaceDatabase() throws RemoteException{
		RackspaceDatabaseServiceProxy proxy=new RackspaceDatabaseServiceProxy();
		String host="";
		String user="";
		String pwd="";
		double sum;
		sum = proxy.connectDatabaseRackspace(host, user, pwd);
		System.out.println(sum);
		
		
	}
	public void AmazonDynamoDB() throws RemoteException{
		AmazonDynamoDBServiceProxy proxy=new AmazonDynamoDBServiceProxy();
		String accessKey="";
		String secretKey="";
		String keyItem="log01";
		String s;
	
			s = proxy.getItem(accessKey, secretKey, keyItem);
			System.out.println(s);
	}
	public void AmazonS3() throws RemoteException{
		AmazonS3StorageProxy proxy=new AmazonS3StorageProxy();
		String acessKey="";
		String secretKey="";
		String bucket="monitorings3";
		String file="File.ods";

			boolean status=proxy.getFile(acessKey, secretKey, bucket, file);
			if(status)
				System.out.println("S3 OK");
	}
	public void Dropbox() throws RemoteException{
		DropboxStorageProxy proxy=new DropboxStorageProxy();
		String token="";
		String file="File.ods";
		

			boolean status=proxy.getFile(token, file);
			if (status)
				System.out.println("Dropbox OK");
	}
	public void RackspaceCloudFiles() throws RemoteException{
		RackspaceStorageProxy proxy=new RackspaceStorageProxy();
		String user="";
		String accessKey="";
		String region="IAD";
		String bucket="";
		String file="File.ods";
			boolean status=proxy.getFile(user, accessKey, region, bucket, file);
			if(status)
				System.out.println("RackSpace OK");
		
	}
	
	
	
}
