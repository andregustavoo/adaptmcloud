package br.ufrn.services.storage.test;

import java.rmi.RemoteException;

import br.ufrn.services.server.storage.AmazonS3StorageProxy;
import br.ufrn.services.server.storage.DropboxStorageProxy;
import br.ufrn.services.server.storage.RackspaceStorageProxy;

public class ClientStorage {

	public static void main(String[] args) {
		executeDropBox();
		executeAmazonS3();
		executeRackspaceStorage();
	}
	public static void executeDropBox(){
		DropboxStorageProxy proxy=new DropboxStorageProxy();
		String token="";
		String file="File.ods";
		
		try {
			boolean status=proxy.getFile(token, file);
			if (status)
				System.out.println("Dropbox OK");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
	public static void executeAmazonS3(){
		AmazonS3StorageProxy proxy=new AmazonS3StorageProxy();
		String acessKey="";
		String secretKey="";
		String bucket="monitorings3";
		String file="File.ods";
		try {
			boolean status=proxy.getFile(acessKey, secretKey, bucket, file);
			if(status)
				System.out.println("S3 OK");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	public static void executeRackspaceStorage(){
		RackspaceStorageProxy proxy=new RackspaceStorageProxy();
		String user="";
		String accessKey="";
		String region="IAD";
		String bucket="monitoringrack";
		String file="File.ods";
		try {
			boolean status=proxy.getFile(user, accessKey, region, bucket, file);
			if(status)
				System.out.println("RackSpace OK");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
