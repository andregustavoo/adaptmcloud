package healthwatcher.frascati.persistence;

import healthwatcher.Constants;
import lib.exceptions.RepositoryException;
import lib.persistence.PersistenceMechanism;

import org.osoa.sca.annotations.Service;
import org.ow2.frascati.tinfi.api.IntentHandler;
import org.ow2.frascati.tinfi.api.IntentJoinPoint;
@Service(IntentHandler.class)
public class PersistenceGoogleSQL implements IntentHandler {
	
	@Override
	public Object invoke(IntentJoinPoint invocation) throws Throwable {
		
		final String GOOGLESQLURL=Constants.getProperties("Google.properties").getProperty("GoogleURL");
		final String GOOGLESQLPASS=Constants.getProperties("Google.properties").getProperty("GooglePASS");
		
if (!(Constants.getURL().equals(GOOGLESQLURL))){
			
			
			Constants.setURL(GOOGLESQLURL);
			Constants.setPass(GOOGLESQLPASS);
			PersistenceMechanism pm;
			try {				
			pm = PersistenceMechanism.getInstance();
			pm.setUrl(GOOGLESQLURL);
			pm.setPassword(GOOGLESQLPASS);
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
