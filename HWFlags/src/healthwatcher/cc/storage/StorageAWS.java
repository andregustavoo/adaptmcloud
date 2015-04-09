package healthwatcher.cc.storage;

import healthwatcher.Constants;

import java.io.File;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class StorageAWS {
	public static void store(String code,File photo) {
		
		PutObjectRequest putRequest=new PutObjectRequest(Constants.S3BUCKET, 
				code+".jpg", photo);
		
		putRequest.setCannedAcl(CannedAccessControlList.PublicRead);
		
		System.out.println("Storage02AWS:"+System.nanoTime());
		
		Constants.getS3().putObject(putRequest);
		
	}
	
	public static String load(String file) throws IOException{
		String bucketName="monitorings3";
		Properties props=Constants.getProperties("AwsCredentials.properties");
		System.out.println(props.getProperty("accessKey"));
		BasicAWSCredentials credentials=new BasicAWSCredentials(props.getProperty("accessKey"), props.getProperty("secretKey"));
		AmazonS3 s3=new AmazonS3Client(credentials);
		S3Object object =s3.getObject(bucketName, file);
		//Escrever arquivo no disco'
		Path dest=FileSystems.getDefault().getPath("files", "clouds3.jpg");
		try {
			Files.copy(object.getObjectContent(), dest,StandardCopyOption.REPLACE_EXISTING);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "AmazonS3";
		
	}
}
