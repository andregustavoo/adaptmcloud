package healthwatcher.aspects.storage;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

import healthwatcher.Constants;

import org.jboss.aop.joinpoint.MethodInvocation;
import org.jclouds.ContextBuilder;
import org.jclouds.blobstore.BlobStore;
import org.jclouds.openstack.swift.v1.blobstore.RegionScopedBlobStoreContext;
import org.jclouds.openstack.swift.v1.domain.SwiftObject;
import org.jclouds.openstack.swift.v1.features.ObjectApi;
import org.jclouds.rackspace.cloudfiles.v1.CloudFilesApi;

public class AspectStorageRackspace {

	public Object load(MethodInvocation invocation) throws Throwable{
			String file=(String)invocation.getArguments()[0];
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

					SwiftObject object = objectApi.get(file);
					InputStream is=object.getPayload().openStream();
					Path dest=FileSystems.getDefault().getPath(System.getProperty("upload.location"), "cloudrack.jpg");
					Files.copy(is, dest,StandardCopyOption.REPLACE_EXISTING);
					return "rackspace";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
			
			
		}
	
}
