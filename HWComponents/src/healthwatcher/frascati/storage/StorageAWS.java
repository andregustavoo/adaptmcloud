package healthwatcher.frascati.storage;

import java.io.File;

import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

import healthwatcher.Constants;
import healthwatcher.storage.IStorage;

public class StorageAWS implements IStorage {

	@Override
	public void storePhoto(String code, File file) {
		
		PutObjectRequest putRequest=new PutObjectRequest(Constants.S3BUCKET, 
				code+".jpg", file);
		
		putRequest.setCannedAcl(CannedAccessControlList.PublicRead);
		
		
		Constants.getS3().putObject(putRequest);
		

	}

	@Override
	public String load(String file) {
		// TODO Auto-generated method stub
		return null;
	}

}
