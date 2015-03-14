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
		String host="jdbc:mysql://monitoring.c9bejyy3fccn.us-east-1.rds.amazonaws.com:3306/monitor";
		String user="root";
		String pwd="c3f3tufrn";
		double sum;
			sum = proxy.connectDatabaseAmazon(host, user, pwd);
			System.out.println(sum);
		
	}
	public void GoogleCloudSQL() throws RemoteException{
		GoogleCloudDatabaseServiceProxy proxy=new GoogleCloudDatabaseServiceProxy();
		String host="jdbc:mysql://173.194.254.56:3306/monitor";
		String user="root";
		String pwd="c3f3tufrn";
		double sum;
			sum = proxy.connectDatabaseGoogleCloud(host, user, pwd);
			System.out.println(sum);
		
	}
	public void RackspaceDatabase() throws RemoteException{
		RackspaceDatabaseServiceProxy proxy=new RackspaceDatabaseServiceProxy();
		String host="jdbc:mysql://104.130.42.209:3306/monitor";
		String user="admin";
		String pwd="c3f3tufrn";
		double sum;
		sum = proxy.connectDatabaseRackspace(host, user, pwd);
		System.out.println(sum);
		
		
	}
	public void AmazonDynamoDB() throws RemoteException{
		AmazonDynamoDBServiceProxy proxy=new AmazonDynamoDBServiceProxy();
		String accessKey="AKIAJEAXQZVGGYFZREZQ";
		String secretKey="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";
		String keyItem="log01";
		String s;
	
			s = proxy.getItem(accessKey, secretKey, keyItem);
			System.out.println(s);
	}
	public void AmazonS3() throws RemoteException{
		AmazonS3StorageProxy proxy=new AmazonS3StorageProxy();
		String acessKey="AKIAJEAXQZVGGYFZREZQ";
		String secretKey="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";
		String bucket="monitorings3";
		String file="File.ods";

			boolean status=proxy.getFile(acessKey, secretKey, bucket, file);
			if(status)
				System.out.println("S3 OK");
	}
	public void Dropbox() throws RemoteException{
		DropboxStorageProxy proxy=new DropboxStorageProxy();
		String token="3tFy_uo27lAAAAAAAAAEjIzKyDOKoKv5OpfDHuJw7q_7VeUKHG71iSB-GCG4Lzw5";
		String file="File.ods";
		

			boolean status=proxy.getFile(token, file);
			if (status)
				System.out.println("Dropbox OK");
	}
	public void RackspaceCloudFiles() throws RemoteException{
		RackspaceStorageProxy proxy=new RackspaceStorageProxy();
		String user="andregustavoo";
		String accessKey="b3f42ab2d4db4c69bca51d39632efe19";
		String region="IAD";
		String bucket="monitoringrack";
		String file="File.ods";
			boolean status=proxy.getFile(user, accessKey, region, bucket, file);
			if(status)
				System.out.println("RackSpace OK");
		
	}
	
	
	
}
