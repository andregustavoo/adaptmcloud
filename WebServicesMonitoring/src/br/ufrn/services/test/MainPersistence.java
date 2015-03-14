package br.ufrn.services.test;

import br.ufrn.services.server.databases.GoogleCloudDatabaseService;

public class MainPersistence {
public static void main(String args[]){
	testGoogleCloud();
}
public static void testGoogleCloud(){
	String host="jdbc:mysql://173.194.254.56:3306/monitor";
	String user="root";
	String pwd="c3f3tufrn";
	
	GoogleCloudDatabaseService googleDB=new GoogleCloudDatabaseService();
	System.out.println(googleDB.connectDatabaseGoogleCloud(host, user, pwd));
}
}
