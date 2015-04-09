package healthwatcher.aspects.logging;

import java.util.Properties;
import java.util.logging.Level;

import lib.logging.LogMechanism;

import org.jboss.aop.joinpoint.MethodInvocation;
import org.jclouds.ContextBuilder;
import org.jclouds.blobstore.BlobStoreContext;
import org.jclouds.openstack.keystone.v2_0.config.CredentialTypes;
import org.jclouds.openstack.keystone.v2_0.config.KeystoneProperties;

public class AspectLoggingHP {
	public Object storeLog(MethodInvocation invocation) throws Throwable{
		
		Level level=(Level)invocation.getArguments()[0];
		String message=(String)invocation.getArguments()[1];
		if (level.getName().equals("SEVERE"))
			LogMechanism.getInstance().getLogger().severe("Log ID:" + LogMechanism.getLastOccurrence() + ", Message:" + message);
		else if (level.getName().equals("WARNING"))
			LogMechanism.getInstance().getLogger().warning("Log ID:" + LogMechanism.getLastOccurrence() + ", Message:" + message);
		else if (level.getName().equals("FINE"))
			LogMechanism.getInstance().getLogger().fine("Log ID:" + LogMechanism.getLastOccurrence() + ", Message:" + message);
		else if (level.getName().equals("INFO"))
			LogMechanism.getInstance().getLogger().info("Log ID:" + LogMechanism.getLastOccurrence() + ", Message:" + message);
		
		
		
		
		return invocation.invokeNext();

	}
}
