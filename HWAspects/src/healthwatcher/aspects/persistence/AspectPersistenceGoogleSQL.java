package healthwatcher.aspects.persistence;


import java.io.IOException;

import healthwatcher.Constants;
import lib.exceptions.RepositoryException;
import lib.persistence.PersistenceMechanism;

import org.jboss.aop.advice.annotation.Return;
import org.jboss.aop.advice.annotation.Target;
import org.jboss.aop.advice.annotation.Thrown;

public class AspectPersistenceGoogleSQL {
	
	public void access()  {
		String GOOGLEURL=null;
		String GOOGLEPASS=null;
		try {
			GOOGLEURL = Constants.getProperties("Google.properties").getProperty("GoogleURL");
			GOOGLEPASS=Constants.getProperties("Google.properties").getProperty("GooglePASS");
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (!(Constants.getURL().equals(GOOGLEURL))){
			Constants.setURL(GOOGLEURL);
			Constants.setPass(GOOGLEPASS);
			PersistenceMechanism pm;
			try {				
			pm = PersistenceMechanism.getInstance();
			pm.setUrl(GOOGLEURL);
			pm.setPassword(GOOGLEPASS);
			pm.disconnect();
			pm.connect();
			} catch (RepositoryException e1) {
				
				e1.printStackTrace();
			}
		}
	}
	
}
