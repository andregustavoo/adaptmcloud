package healthwatcher.cc.persistence;


import java.io.IOException;
import java.util.Properties;

import healthwatcher.Constants;
import lib.exceptions.RepositoryException;
import lib.persistence.PersistenceMechanism;



public class PersistenceAWS {
	
	//public static final String Url="jdbc:mysql://hw.c9bejyy3fccn.us-east-1.rds.amazonaws.com:3306/hw";
	//public static final String Pass="c3f3tc3f3t";
	
	
	public static void reconfigure()  {
			try {
				Properties props=Constants.getProperties("aws.properties");
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
