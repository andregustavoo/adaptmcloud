package br.ufrn.services.storage;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class AmazonS3Storage {
	public boolean getFile(String accessKey,String secretKey,String bucketName,String fileName){
		BasicAWSCredentials credentials=new BasicAWSCredentials(accessKey, secretKey);
		AmazonS3 s3=new AmazonS3Client(credentials);
		GetObjectRequest getObjectRequest=new GetObjectRequest(bucketName, fileName);
		S3Object file= s3.getObject(getObjectRequest);
		if (file!=null)
			return true;
		else
			return false;
	}
}
