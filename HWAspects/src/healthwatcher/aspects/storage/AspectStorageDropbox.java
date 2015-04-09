package healthwatcher.aspects.storage;

import healthwatcher.Constants;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

import org.jboss.aop.joinpoint.MethodInvocation;

import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;

public class AspectStorageDropbox {
	public Object load(MethodInvocation invocation) throws Throwable{
		String file=(String)invocation.getArguments()[0];
		try {
			Properties props=Constants.getProperties("dropbox.properties");
			DbxRequestConfig config=new DbxRequestConfig("Monitoring/1.0",Locale.getDefault().toString());
			DbxClient client=new DbxClient(config, props.getProperty("token"));
			FileOutputStream outputStream = new FileOutputStream(System.getProperty("upload.location")+ "clouddropbox.jpg");
		    DbxEntry.File downloadedFile = client.getFile("/"+file, null,
		        outputStream);
		    System.out.println("Metadata: " + downloadedFile.toString());
		    outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DbxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "dropbox";
	}
}
