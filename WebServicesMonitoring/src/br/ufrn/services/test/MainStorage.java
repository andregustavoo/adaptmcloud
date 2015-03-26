package br.ufrn.services.test;

import br.ufrn.services.storage.AmazonS3Storage;
import br.ufrn.services.storage.DropboxStorage;
import br.ufrn.services.storage.HPStorage;
import br.ufrn.services.storage.RackspaceStorage;

public class MainStorage {
public static void main(String args[]){
	//testS3();
	//testRackSpace();
	testDropbox();
}
public static void testS3(){
	AmazonS3Storage storageS3=new AmazonS3Storage();
	boolean status=storageS3.getFile("", "",
			"monitorings3", "File.ods");
	if (status)
		System.out.println("OK");
}
public static void testRackSpace(){
	RackspaceStorage storageRack=new RackspaceStorage();
	boolean status=storageRack.getFile("", "", 
			"IAD", "monitoringrack", "File.ods");
	if (status)
		System.out.println("OK");
}

public static void testDropbox(){
	DropboxStorage storageDropbox=new DropboxStorage();
	boolean status=storageDropbox.getFile("", "File.ods");
	if (status){
		System.out.println("OK");
	}
}
}
