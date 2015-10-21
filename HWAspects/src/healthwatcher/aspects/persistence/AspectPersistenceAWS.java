package healthwatcher.aspects.persistence;


import java.io.IOException;

import healthwatcher.Constants;
import lib.exceptions.RepositoryException;
import lib.persistence.PersistenceMechanism;

import org.jboss.aop.advice.annotation.Return;
import org.jboss.aop.advice.annotation.Target;
import org.jboss.aop.advice.annotation.Thrown;

public class AspectPersistenceAWS {
	
	public void access()  {
		String AWSURL=null;
		String AWSPASS=null;
		try {
			AWSURL = Constants.getProperties("AWS.properties").getProperty("AWSURL");
			AWSPASS=Constants.getProperties("AWS.properties").getProperty("AWSDBPASS");
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (!(Constants.getURL().equals(AWSURL))){
			Constants.setURL(AWSURL);
			Constants.setPass(AWSPASS);
			PersistenceMechanism pm;
			try {				
			pm = PersistenceMechanism.getInstance();
			pm.setUrl(AWSURL);
			pm.setPassword(AWSPASS);
			pm.disconnect();
			pm.connect();
			} catch (RepositoryException e1) {
				
				e1.printStackTrace();
			}
		}
	}
	
}
