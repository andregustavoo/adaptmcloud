package br.ufrn.services.storage;

import org.jclouds.ContextBuilder;
import org.jclouds.blobstore.BlobStore;
import org.jclouds.openstack.swift.v1.blobstore.RegionScopedBlobStoreContext;
import org.jclouds.openstack.swift.v1.domain.SwiftObject;
import org.jclouds.openstack.swift.v1.features.ObjectApi;
import org.jclouds.rackspace.cloudfiles.v1.CloudFilesApi;

public class RackspaceStorage {
	public boolean getFile(String user,String apiKey,String region,String container,String file){
		ContextBuilder builder = ContextBuilder.newBuilder("rackspace-cloudfiles-us")
		        .credentials(user, apiKey);

		// Access the RegionScopedBlobStore and get the Cloud Files API
		BlobStore blobStore = builder.buildView(RegionScopedBlobStoreContext.class)
		        .blobStoreInRegion(region);
		CloudFilesApi cloudFilesApi = blobStore.getContext().unwrapApi(CloudFilesApi.class);
		ObjectApi objectApi =
			    cloudFilesApi.getObjectApiForRegionAndContainer(region, container);

			SwiftObject object = objectApi.get(file);
			System.out.println(object.getName());
			if(object.getName()!=null){
				return true;
			} 
			return false;
			
	}
}
