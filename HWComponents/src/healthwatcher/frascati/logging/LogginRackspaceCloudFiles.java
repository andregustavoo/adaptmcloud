package healthwatcher.frascati.logging;

import healthwatcher.Constants;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;

import org.jclouds.ContextBuilder;
import org.jclouds.blobstore.BlobStore;
import org.jclouds.io.payloads.ByteSourcePayload;
import org.jclouds.openstack.swift.v1.blobstore.RegionScopedBlobStoreContext;
import org.jclouds.openstack.swift.v1.features.ObjectApi;
import org.jclouds.rackspace.cloudfiles.v1.CloudFilesApi;

import com.google.common.io.ByteSource;

import lib.logging.ILog;
import lib.logging.LogMechanism;

public class LogginRackspaceCloudFiles implements ILog {

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
		Properties props;
		try {
			props = Constants.getProperties("rackspace.properties");
			ContextBuilder builder = ContextBuilder.newBuilder("rackspace-cloudfiles-us")
			        .credentials(props.getProperty("username"), props.getProperty("apikey"));
			BlobStore blobStore = builder.buildView(RegionScopedBlobStoreContext.class)
			        .blobStoreInRegion(props.getProperty("region"));
			CloudFilesApi cloudFilesApi = blobStore.getContext().unwrapApi(CloudFilesApi.class);
			ObjectApi objectApi =
				    cloudFilesApi.getObjectApiForRegionAndContainer(props.getProperty("region"), props.getProperty("bucket"));
			File file=new File(LogMechanism.getLogFile());
			ByteSource payload=ByteSource.wrap(com.google.common.io.Files.toByteArray(file));
			ByteSourcePayload bsp=new ByteSourcePayload(payload);
				objectApi.put("log",bsp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
