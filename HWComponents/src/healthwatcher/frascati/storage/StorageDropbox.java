package healthwatcher.frascati.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWriteMode;

import healthwatcher.Constants;
import healthwatcher.storage.IStorage;

public class StorageDropbox implements IStorage {

	@Override
	public void storePhoto(String code, File file) {
		FileInputStream inputStream=null;
		try {
			Properties props=Constants.getProperties("dropbox.properties");
			DbxRequestConfig config=new DbxRequestConfig("Monitoring/1.0",Locale.getDefault().toString());
			DbxClient client=new DbxClient(config, props.getProperty("token"));
			inputStream = new FileInputStream(file);
		    DbxEntry.File uploadedFile = client.uploadFile(code,
		        DbxWriteMode.add(), file.length(), inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DbxException e) {
			e.printStackTrace();
		} 
	}

	@Override
	public String load(String file) {
		try {
			Properties props=Constants.getProperties("dropbox.properties");
			DbxRequestConfig config=new DbxRequestConfig("Monitoring/1.0",Locale.getDefault().toString());
			DbxClient client=new DbxClient(config, props.getProperty("token"));
			FileOutputStream outputStream = new FileOutputStream(System.getProperty("upload.location")+ file);
		    DbxEntry.File downloadedFile = client.getFile("/"+file, null,
		        outputStream);
		    System.out.println("Metadata: " + downloadedFile.toString());
		    outputStream.close();
		    return System.getProperty("upload.location")+ file;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DbxException e) {
			e.printStackTrace();
		}
		return null;
	}

}
