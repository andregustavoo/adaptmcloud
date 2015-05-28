package healthwatcher.cc.logging;


import healthwatcher.Constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;

import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWriteMode;

import lib.logging.LogMechanism;


public class LoggingDropbox {
	public static void storeLog(Level level,String message) {
		
		File file=UtilsStorage.createFile(LogMechanism.getLastOccurrence(), level, message);
		
		FileInputStream fis;
		try {
			Properties props=Constants.getProperties("dropbox.properties");
			DbxRequestConfig config=new DbxRequestConfig("Monitoring/1.0",Locale.getDefault().toString());
			DbxClient client=new DbxClient(config, props.getProperty("token"));
			fis=new FileInputStream(file);
			DbxEntry uploadedFile=client.uploadFile(file.getName(), DbxWriteMode.add(), file.length(), fis);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DbxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
