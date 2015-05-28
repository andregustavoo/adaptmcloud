package healthwatcher.cc.persistence;

import healthwatcher.Constants;

import java.io.IOException;
import java.util.Properties;

import lib.exceptions.RepositoryException;
import lib.persistence.PersistenceMechanism;

public class PersistenceGoogleSQL {
	public static void reconfigure()  {
		try {
			Properties props=Constants.getProperties("google.properties");
			String Url=props.getProperty("JDBCURL");
			String Pass=props.getProperty("JDBCPWD");
			if (!(Constants.getURL().equals(Url))){
				Constants.setURL(Url);
				Constants.setPass(Pass);
				PersistenceMechanism pm;
				try {				
				pm = PersistenceMechanism.getInstance();
				pm.setUrl(Url);
				pm.setPassword(Pass);
				//pm.releaseCommunicationChannel();
				pm.disconnect();
				pm.connect();
				
				
				} catch (RepositoryException e1) {
					
					e1.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
}
}
