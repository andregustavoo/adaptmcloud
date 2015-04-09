package healthwatcher.frascati.logging;

import healthwatcher.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import com.amazonaws.services.simpledb.model.BatchPutAttributesRequest;
import com.amazonaws.services.simpledb.model.CreateDomainRequest;
import com.amazonaws.services.simpledb.model.ReplaceableAttribute;
import com.amazonaws.services.simpledb.model.ReplaceableItem;

import lib.logging.ILog;
import lib.logging.LogMechanism;

public class LoggingAWS implements ILog {

	@Override
	public void addLog(Level level, String message) {
		
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
		
	}

}
