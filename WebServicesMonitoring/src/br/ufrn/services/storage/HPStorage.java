package br.ufrn.services.storage;

import org.jclouds.ContextBuilder;
import org.jclouds.blobstore.BlobStore;
import org.jclouds.blobstore.BlobStoreContext;
import org.jclouds.blobstore.domain.Blob;

public class HPStorage {

	@SuppressWarnings("unused")
	public boolean getFile(String user,String apiKey,String container,String file){
			BlobStoreContext builder = ContextBuilder.newBuilder("hpcloud-objectstorage")
			        .credentials(user, apiKey).buildView(BlobStoreContext.class);
	
			// Access the RegionScopedBlobStore and get the Cloud Files API
			BlobStore blobStore = builder.getBlobStore();
			Blob object=blobStore.getBlob(container, file);
			System.out.println(object.getMetadata().getName());
			if(object!=null){
					return true;
			} 
			return false;
				
		}

}
