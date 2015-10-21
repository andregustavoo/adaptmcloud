package healthwatcher;

import jcop.lang.Layer;

public class JCOPHandler {
	private String multiCloudConfiguration;
	public static Layer getActiveLayer(String feature){
		try {
			Layer layerActive=(Layer)Class.forName(getLayerClass(feature)).newInstance();
			return layerActive;
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static String getLayerClass(String feature){
		return "layer";
	}
	public void setMultiCloudConfiguration(String configuration){
		this.multiCloudConfiguration=configuration;
	}
}
