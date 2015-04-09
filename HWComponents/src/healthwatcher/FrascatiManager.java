package healthwatcher;

import org.objectweb.fractal.api.Component;
import org.ow2.frascati.FraSCAti;
import org.ow2.frascati.util.FrascatiException;

public class FrascatiManager {
	private static FraSCAti frascati;
	private static String currentReconf;
	private static String oldConf;
	private static boolean isReconfigured=false;
	public static FraSCAti getInstance(){
		if(frascati==null){
			try {
				frascati=FraSCAti.newFraSCAti();
			} catch (FrascatiException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return frascati;
	}
	
	public static <T> T getService(String serviceName, Class<T> clazz){
		
		try {
			if(isReconfigured){
				getInstance().getCompositeManager().removeComposite(oldConf);
				isReconfigured=false;
			}
			Component composite=getInstance().getCompositeManager().getComposite(currentReconf);
			
			return getInstance().getService(composite, serviceName, clazz);
		} catch (FrascatiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public static void setCurrentReconfig(String reconf){
		if(currentReconf==null)
			isReconfigured=false;
		else
			isReconfigured=true;
		oldConf=currentReconf;
		currentReconf=reconf;
	}
}
