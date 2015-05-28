package healthwatcher.cc.logging;

import healthwatcher.Constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;

import org.jclouds.ContextBuilder;
import org.jclouds.blobstore.BlobStore;
import org.jclouds.io.Payload;
import org.jclouds.io.Payloads;
import org.jclouds.openstack.swift.v1.blobstore.RegionScopedBlobStoreContext;
import org.jclouds.openstack.swift.v1.features.ObjectApi;
import org.jclouds.rackspace.cloudfiles.v1.CloudFilesApi;

import lib.logging.LogMechanism;

import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWriteMode;
import com.google.common.io.ByteSource;

public class LoggingRackspace {
public static void storeLog(Level level,String message) {
		
		File file=UtilsStorage.createFile(LogMechanism.getLastOccurrence(), level, message);
		
		Properties props;
		try {
			props = Constants.getProperties("rackspace.properties");
			ContextBuilder builder = ContextBuilder.newBuilder("rackspace-cloudfiles-us")
			        .credentials(props.getProperty("username"), props.getProperty("apikey"));

			// Access the RegionScopedBlobStore and get the Cloud Files API
			BlobStore blobStore = builder.buildView(RegionScopedBlobStoreContext.class)
			        .blobStoreInRegion(props.getProperty("region"));
			CloudFilesApi cloudFilesApi = blobStore.getContext().unwrapApi(CloudFilesApi.class);
			ObjectApi objectApi =
				    cloudFilesApi.getObjectApiForRegionAndContainer(props.getProperty("region"), props.getProperty("bucket"));
			
				ByteSource source=ByteSource.wrap(com.google.common.io.Files.toByteArray(file));
				Payload payload=Payloads.newByteSourcePayload(source);
				objectApi.put(file.getName(), payload);
				
				cloudFilesApi.close();
				
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		

	}
}
