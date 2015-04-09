package healthwatcher.cc.persistence;


import healthwatcher.Constants;
import lib.exceptions.RepositoryException;
import lib.persistence.PersistenceMechanism;



public class PersistenceAWS {
	
	public static final String AWSURL="jdbc:mysql://hw.c9bejyy3fccn.us-east-1.rds.amazonaws.com:3306/hw";
	public static final String AWSPASS="c3f3tc3f3t";
	
	/*public Object access(MethodInvocation invocation) throws Throwable{
		
		System.out.println("Invocado");
		if (invocation.getMethod().getName().equals("getURL")){
			return "jdbc:mysql://hw.c9bejyy3fccn.us-east-1.rds.amazonaws.com:3306/hw";
		}else if (invocation.getMethod().getName().equals("getPass")){
			return "c3f3tc3f3t";
		}else{
				System.out.println("Campo:"+invocation.getMethod().getName());
				return invocation.invokeNext();
			
		}
	}*/
	
	public static void reconfigure()  {
			if (!(Constants.getURL().equals(AWSURL))){
				
				long time1=System.nanoTime();
				
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
				
				long total=System.nanoTime()-time1;
				
				System.out.println("PersistenceReconfAWS:"+total);
				
				} catch (RepositoryException e1) {
					
					e1.printStackTrace();
				}
			}
	}
	
}
