package healthwatcher.storage;

import healthwatcher.ConfigurationHandler;
import healthwatcher.ConfigurationHandler.Features;
import healthwatcher.cc.storage.StorageAWS;
import healthwatcher.cc.storage.StorageDropbox;
import healthwatcher.cc.storage.StorageRackspace;

import java.io.File;
import java.io.IOException;


public class Storage {
	public void storePhoto(String code, File photo){
		if(ConfigurationHandler.getInstance().getFeature(Features.STORAGE).equals(ConfigurationHandler.AWSSTORAGE)){
				StorageAWS.store(code, photo);
		}else if(ConfigurationHandler.getInstance().getFeature(Features.STORAGE).equals(ConfigurationHandler.DROPBOXSTORAGE)){
			StorageDropbox.store(code, photo);
		}else if(ConfigurationHandler.getInstance().getFeature(Features.STORAGE).equals(ConfigurationHandler.RACKSPACESTORAGE)){
			StorageRackspace.store(code, photo);
		}
	}
	
	public String load(String file){
		if(ConfigurationHandler.getInstance().getFeature(Features.STORAGE).equals(ConfigurationHandler.AWSSTORAGE)){
			try {
				return StorageAWS.load(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(ConfigurationHandler.getInstance().getFeature(Features.STORAGE).equals(ConfigurationHandler.DROPBOXSTORAGE)){
			return StorageDropbox.load(file);
		}else if(ConfigurationHandler.getInstance().getFeature(Features.STORAGE).equals(ConfigurationHandler.RACKSPACESTORAGE)){
			return StorageRackspace.load(file);
		}
		return "Nulo";
	}
	
}
