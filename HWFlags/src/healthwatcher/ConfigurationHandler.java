package healthwatcher;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationHandler {
public static final String AWSPERSISTENCE="awspersistence";
public static final String RACKSPACEPERSISTENCE="rackspacepersistence";
public static final String GOOGLEPERSISTENCE="googlepersistance";
public static final String AWSSTORAGE="awsstorage";
public static final String DROPBOXSTORAGE="dropboxstorage";
public static final String RACKSPACESTORAGE="rackspacestorage";
public static final String AWSLOGGING="awslogging";
public static final String DROPBOXLOGGING="dropboxlogging";
public static final String RACKSPACELOGGING="rackspacelogging";

public enum Features{
	PERSISTENCE,
	STORAGE,
	LOGGING
}

private static ConfigurationHandler instance;
private Map<Features, String>features;
private ConfigurationHandler(){
	features=new HashMap<ConfigurationHandler.Features, String>();
}

public static ConfigurationHandler getInstance(){
	if (instance==null)
		instance=new ConfigurationHandler();
	return instance;
}
public void addFeature(Features f,String value){
	features.put(f, value);
}
public String getFeature(Features f){
	if(features.get(f)==null)
		return "Empty";
	else
		return features.get(f);
}


}
