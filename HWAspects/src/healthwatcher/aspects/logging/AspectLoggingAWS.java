package healthwatcher.aspects.logging;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.jboss.aop.joinpoint.MethodInvocation;

import lib.logging.LogMechanism;

import healthwatcher.Constants;

import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.simpledb.model.BatchPutAttributesRequest;
import com.amazonaws.services.simpledb.model.CreateDomainRequest;
import com.amazonaws.services.simpledb.model.ReplaceableAttribute;
import com.amazonaws.services.simpledb.model.ReplaceableItem;

public class AspectLoggingAWS {
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
	
	Constants.getSDB().createDomain(new CreateDomainRequest(Constants.DOMAINSDB));
	List<ReplaceableItem> erros=new ArrayList<ReplaceableItem>();
	erros.add(new ReplaceableItem("LOG:").withAttributes(
			new ReplaceableAttribute("log", 
					""+LogMechanism.getInstance().getLastOccurrence(), true),
					new ReplaceableAttribute("Level", level.getName(), true),
					new ReplaceableAttribute("Message", message, true)));
	Constants.getSDB().batchPutAttributes(new BatchPutAttributesRequest(Constants.DOMAINSDB, erros));
	return invocation.invokeNext();
}
}
