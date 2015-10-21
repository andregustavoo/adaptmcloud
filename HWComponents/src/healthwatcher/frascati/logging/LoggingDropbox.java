package healthwatcher.frascati.logging;

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

import lib.logging.ILog;
import lib.logging.LogMechanism;

public class LoggingDropbox implements ILog {

	@Override
	public void addLog(Level level, String message) {
		if (level.getName().equals("SEVERE"))
			LogMechanism.getInstance().getLogger().severe("Log ID:" + LogMechanism.getLastOccurrence() + ", Message:" + message);
		else if (level.getName().equals("WARNING"))
			LogMechanism.getInstance().getLogger().warning("Log ID:" + LogMechanism.getLastOccurrence() + ", Message:" + message);
		else if (level.getName().equals("FINE"))
			LogMechanism.getInstance().getLogger().fine("Log ID:" + LogMechanism.getLastOccurrence() + ", Message:" + message);
		else if (level.getName().equals("INFO"))
			LogMechanism.getInstance().getLogger().info("Log ID:" + LogMechanism.getLastOccurrence() + ", Message:" + message);
		FileInputStream inputStream=null;
		try {
			Properties props=Constants.getProperties("dropbox.properties");
			DbxRequestConfig config=new DbxRequestConfig("Monitoring/1.0",Locale.getDefault().toString());
			DbxClient client=new DbxClient(config, props.getProperty("token"));
			File file=new File(LogMechanism.getLogFile());
			inputStream = new FileInputStream(file);
		    DbxEntry.File uploadedFile = client.uploadFile("log",
		        DbxWriteMode.add(), file.length(), inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DbxException e) {
			e.printStackTrace();
		} 
		

	}

}
