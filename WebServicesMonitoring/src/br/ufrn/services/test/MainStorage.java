package br.ufrn.services.test;

import br.ufrn.services.storage.AmazonS3Storage;
import br.ufrn.services.storage.DropboxStorage;
import br.ufrn.services.storage.HPStorage;
import br.ufrn.services.storage.RackspaceStorage;

public class MainStorage {
public static void main(String args[]){
	//testS3();
	//testRackSpace();
	//testHPCloud();
	testDropbox();
}
public static void testS3(){
	AmazonS3Storage storageS3=new AmazonS3Storage();
	boolean status=storageS3.getFile("AKIAJEAXQZVGGYFZREZQ", "GNj1lftrTSsqHm8Tu6ghumhPUrLRFEayMsbgPvFh",
			"monitorings3", "File.ods");
	if (status)
		System.out.println("OK");
}
public static void testRackSpace(){
	RackspaceStorage storageRack=new RackspaceStorage();
	boolean status=storageRack.getFile("andregustavoo", "b3f42ab2d4db4c69bca51d39632efe19", 
			"IAD", "monitoringrack", "File.ods");
	if (status)
		System.out.println("OK");
}
public static void testHPCloud(){
	HPStorage storageHP=new HPStorage();
	boolean status=storageHP.getFile("andregustavoo-tenant1:WU7UC9PHMZR5HCJNX8TA", 
			"tbVCFfpoVTQjRp7YjjJwz0C5lOpI0wrOg0HYptH1", "monitoringhp", "File.ods");
	if (status){
		System.out.println("OK");
	}
}
public static void testDropbox(){
	DropboxStorage storageDropbox=new DropboxStorage();
	boolean status=storageDropbox.getFile("3tFy_uo27lAAAAAAAAAEjIzKyDOKoKv5OpfDHuJw7q_7VeUKHG71iSB-GCG4Lzw5", "File.ods");
	if (status){
		System.out.println("OK");
	}
}
}
