package healthwatcher.aspects.persistence;

import healthwatcher.Constants;
import lib.exceptions.RepositoryException;
import lib.persistence.PersistenceMechanism;

import org.jboss.aop.joinpoint.FieldReadInvocation;
import org.jboss.aop.joinpoint.MethodInvocation;

public class AspectPersistenceHP {

	private static final String HPURL="jdbc:mysql://15.185.115.196:3306/hw";
	private static final String HPPASS="c3f3t";
	
	/*public Object access(MethodInvocation invocation) throws Throwable{
		if (invocation.getMethod().getName().equals("getURL")){
			return "jdbc:mysql://15.185.115.196:3306/hw";
		}else if(invocation.getMethod().getName().equals("getPass")){
			return "c3f3t";
		}
		else{

				return invocation.invokeNext();
		
		}
	}*/
	
	public void access()  {
		if (!(Constants.getURL().equals(HPURL))){
			
			long time1=System.nanoTime();
			
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
			long total=System.nanoTime()-time1;
			System.out.println("PersistenceReconfHP:"+total);
			
			} catch (RepositoryException e1) {
				
				e1.printStackTrace();
			}
		}
}
}
