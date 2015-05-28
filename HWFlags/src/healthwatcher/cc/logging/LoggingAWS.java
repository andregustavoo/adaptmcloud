package healthwatcher.cc.logging;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;



import lib.logging.LogMechanism;

import healthwatcher.Constants;

import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.simpledb.model.BatchPutAttributesRequest;
import com.amazonaws.services.simpledb.model.CreateDomainRequest;
import com.amazonaws.services.simpledb.model.ReplaceableAttribute;
import com.amazonaws.services.simpledb.model.ReplaceableItem;

public class LoggingAWS {
public static void storeLog(Level level,String message) {
	
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
