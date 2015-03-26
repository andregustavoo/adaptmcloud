package br.ufrn.services.test;

import br.ufrn.services.server.databases.GoogleCloudDatabaseService;

public class MainPersistence {
public static void main(String args[]){
	testGoogleCloud();
}
public static void testGoogleCloud(){
	String host="";
	String user="";
	String pwd="";
	
	GoogleCloudDatabaseService googleDB=new GoogleCloudDatabaseService();
	System.out.println(googleDB.connectDatabaseGoogleCloud(host, user, pwd));
}
}
