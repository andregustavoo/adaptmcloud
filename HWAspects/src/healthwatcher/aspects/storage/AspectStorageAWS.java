package healthwatcher.aspects.storage;

import healthwatcher.Constants;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

import org.aspectj.weaver.Dump.INode;
import org.jboss.aop.joinpoint.MethodInvocation;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class AspectStorageAWS {
	public Object store(MethodInvocation invocation) throws Throwable{
		
		String code=(String)invocation.getArguments()[0];
		File photo=(File)invocation.getArguments()[1];
		
		PutObjectRequest putRequest=new PutObjectRequest(Constants.S3BUCKET, 
				code+".jpg", photo);
		
		putRequest.setCannedAcl(CannedAccessControlList.PublicRead);
		
		System.out.println("Storage02AWS:"+System.nanoTime());
		
		Constants.getS3().putObject(putRequest);
		
			return invocation.invokeNext();
		
	}
	public Object load(MethodInvocation invocation) throws Throwable{
		
		System.out.println("Executei");
		
		String file=(String)invocation.getArguments()[0];
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
		
		return invocation.invokeNext();
	}
}
