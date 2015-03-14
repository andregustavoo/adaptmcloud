package br.ufrn.services.storage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;

public class DropboxStorage {
	public boolean getFile(String accessToken,String file){
		DbxRequestConfig config=new DbxRequestConfig("Monitoring/1.0",Locale.getDefault().toString());
		DbxClient client=new DbxClient(config, accessToken);
		FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream(file);
		    DbxEntry.File downloadedFile = client.getFile("/"+file, null,
		        outputStream);
		    System.out.println("Metadata: " + downloadedFile.toString());
		    outputStream.close();
		    return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DbxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
