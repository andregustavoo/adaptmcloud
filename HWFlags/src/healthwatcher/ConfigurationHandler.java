package healthwatcher;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



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

private  void loadConfiguration(){
	String xmlFile=System.getenv("configuration.location");
	DocumentBuilderFactory factory = 
		    DocumentBuilderFactory.newInstance();
		    DocumentBuilder builder;
			try {
				builder = factory.newDocumentBuilder();
				Document document = builder.parse(xmlFile);
				NodeList nodeList= document.getElementsByTagName("feature");
				for(int i=0;i<nodeList.getLength();i++){
					addFeature(Features.valueOf(
							nodeList.item(i).getAttributes().getNamedItem("name").getNodeValue()), 
							nodeList.item(i).getTextContent());
				}
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
}

public void addFeature(Features f,String value){
	features.put(f, value);
}
public String getFeature(Features f){
	loadConfiguration();
	if(features.get(f)==null)
		return "Empty";
	else
		return features.get(f);
}
}
