package br.ufrn.services.server.log.test;

import java.rmi.RemoteException;

import br.ufrn.services.server.log.AmazonDynamoDBServiceProxy;

public class MainLog {

	public static void main(String[] args) {
		executeAmazonDynamoDB();
	}
	
	public static void executeAmazonDynamoDB(){
		AmazonDynamoDBServiceProxy proxy=new AmazonDynamoDBServiceProxy();
		String accessKey="AKIAJEAXQZVGGYFZREZQ";
		String secretKey="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";
		String keyItem="log01";
		String s;
		try {
			s = proxy.getItem(accessKey, secretKey, keyItem);
			System.out.println(s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
