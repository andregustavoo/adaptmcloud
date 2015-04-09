package healthwatcher.frascati.persistence;

import healthwatcher.Constants;
import lib.exceptions.RepositoryException;
import lib.persistence.PersistenceMechanism;

import org.osoa.sca.annotations.Service;
import org.ow2.frascati.tinfi.api.IntentHandler;
import org.ow2.frascati.tinfi.api.IntentJoinPoint;
@Service(IntentHandler.class)
public class PersistenceHP implements IntentHandler {
	private static final String HPURL="jdbc:mysql://15.185.115.196:3306/hw";
	private static final String HPPASS="c3f3t";
	@Override
	public Object invoke(IntentJoinPoint invocation) throws Throwable {
if (!(Constants.getURL().equals(HPURL))){
			
			
			Constants.setURL(HPURL);
			Constants.setPass(HPPASS);
			PersistenceMechanism pm;
			try {				
			pm = PersistenceMechanism.getInstance();
			pm.setUrl(HPURL);
			pm.setPassword(HPPASS);
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
