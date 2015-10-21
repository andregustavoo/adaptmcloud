package healthwatcher.frascati.persistence;

import healthwatcher.Constants;
import lib.exceptions.RepositoryException;
import lib.persistence.PersistenceMechanism;

import org.osoa.sca.annotations.Service;
import org.ow2.frascati.tinfi.api.IntentHandler;
import org.ow2.frascati.tinfi.api.IntentJoinPoint;
@Service(IntentHandler.class)
public class PersistenceRackspace implements IntentHandler {
	
	@Override
	public Object invoke(IntentJoinPoint invocation) throws Throwable {
		final String RACKSPACEURL=Constants.getProperties("Rackspace.properties").getProperty("RackspaceURL");
		final String RACKSPACEPASS=Constants.getProperties("Rackspace.properties").getProperty("RackspacePASS");
		if (!(Constants.getURL().equals(RACKSPACEURL))){
			Constants.setURL(RACKSPACEURL);
			Constants.setPass(RACKSPACEPASS);
			PersistenceMechanism pm;
			try {				
			pm = PersistenceMechanism.getInstance();
			pm.setUrl(RACKSPACEURL);
			pm.setPassword(RACKSPACEPASS);
			//pm.releaseCommunicationChannel();
			pm.disconnect();
			pm.connect();
			
			} catch (RepositoryException e1) {
				
				e1.printStackTrace();
			}
		}
		return invocation.proceed();
	}

}
