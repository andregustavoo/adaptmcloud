package br.ufrn.services.test;

import br.ufrn.services.server.log.AmazonDynamoDBService;

public class MainLog {
	public static void main(String args[]){
		executeAmazonDynamo();
	}
	public static void executeAmazonDynamo(){
		AmazonDynamoDBService db=new AmazonDynamoDBService();
		String accessKey="AKIAJEAXQZVGGYFZREZQ";
		String secretKey="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";
		String keyItem="log01";
		String s=db.getItem(accessKey, secretKey, keyItem);
		System.out.println(s);
	}
}
