package healthwatcher.frascati.persistence;

import healthwatcher.Constants;
import lib.exceptions.RepositoryException;
import lib.persistence.PersistenceMechanism;

import org.osoa.sca.annotations.Service;
import org.ow2.frascati.tinfi.api.IntentHandler;
import org.ow2.frascati.tinfi.api.IntentJoinPoint;
@Service(IntentHandler.class)
public class PersistenceAWS implements IntentHandler {
	@Override
	public Object invoke(IntentJoinPoint invocation) throws Throwable {
		
		final String AWSURL=Constants.getProperties("AWS.properties").getProperty("AWSURL");
		final String AWSPASS=Constants.getProperties("AWS.properties").getProperty("AWSDBPASS");
		
		if (!(Constants.getURL().equals(AWSURL))){
			
			Constants.setURL(AWSURL);
			Constants.setPass(AWSPASS);
			PersistenceMechanism pm;
			try {				
			pm = PersistenceMechanism.getInstance();
			pm.setUrl(AWSURL);
			pm.setPassword(AWSPASS);
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
