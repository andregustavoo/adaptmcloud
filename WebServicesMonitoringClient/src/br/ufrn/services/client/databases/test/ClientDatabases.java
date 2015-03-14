package br.ufrn.services.client.databases.test;

import java.rmi.RemoteException;

import br.ufrn.services.server.databases.AmazonRDSServiceProxy;
import br.ufrn.services.server.databases.GoogleCloudDatabaseServiceProxy;
import br.ufrn.services.server.databases.RackspaceDatabaseServiceProxy;

public class ClientDatabases {
public static void main(String args[]){
	//executeRackSpace();
	//executeGoogleDatabases();
	executeAmazonDatabases();
}
public static void executeRackSpace(){
	RackspaceDatabaseServiceProxy proxy=new RackspaceDatabaseServiceProxy();
	String host="jdbc:mysql://104.130.42.209:3306/monitor";
	String user="admin";
	String pwd="c3f3tufrn";
	double sum;
	try {
		sum = proxy.connectDatabaseRackspace(host, user, pwd);
		System.out.println(sum);
	} catch (RemoteException e) {
		
		e.printStackTrace();
	}
}
public static void executeGoogleDatabases(){
	GoogleCloudDatabaseServiceProxy proxy=new GoogleCloudDatabaseServiceProxy();
	String host="jdbc:mysql://173.194.254.56:3306/monitor";
	String user="root";
	String pwd="c3f3tufrn";
	double sum;
	try {
		sum = proxy.connectDatabaseGoogleCloud(host, user, pwd);
		System.out.println(sum);
	} catch (RemoteException e) {
		
		e.printStackTrace();
	}
}
public static void executeAmazonDatabases(){
	AmazonRDSServiceProxy proxy=new AmazonRDSServiceProxy();
	String host="jdbc:mysql://monitoring.c9bejyy3fccn.us-east-1.rds.amazonaws.com:3306/monitor";
	String user="root";
	String pwd="c3f3tufrn";
	double sum;
	try {
		sum = proxy.connectDatabaseAmazon(host, user, pwd);
		System.out.println(sum);
	} catch (RemoteException e) {
		
		e.printStackTrace();
	}
}
}
