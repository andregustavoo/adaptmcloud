package healthwatcher.aspects.persistence;


import java.io.IOException;

import healthwatcher.Constants;
import lib.exceptions.RepositoryException;
import lib.persistence.PersistenceMechanism;

import org.jboss.aop.advice.annotation.Return;
import org.jboss.aop.advice.annotation.Target;
import org.jboss.aop.advice.annotation.Thrown;

public class AspectPersistenceRackspace {
	
	public void access()  {
		String RACKSPACEURL=null;
		String RACKSPACEPASS=null;
		try {
			RACKSPACEURL = Constants.getProperties("Rackspace.properties").getProperty("RackspaceURL");
			RACKSPACEPASS=Constants.getProperties("Rackspace.properties").getProperty("RackspacePASS");
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (!(Constants.getURL().equals(RACKSPACEURL))){
			Constants.setURL(RACKSPACEURL);
			Constants.setPass(RACKSPACEPASS);
			PersistenceMechanism pm;
			try {				
			pm = PersistenceMechanism.getInstance();
			pm.setUrl(RACKSPACEURL);
			pm.setPassword(RACKSPACEPASS);
			pm.disconnect();
			pm.connect();
			} catch (RepositoryException e1) {
				
				e1.printStackTrace();
			}
		}
	}
	
}
