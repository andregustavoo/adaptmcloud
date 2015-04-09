package healthwatcher.aspects.storage;

import java.io.File;
import java.util.Properties;

import org.jboss.aop.joinpoint.MethodInvocation;
import org.jclouds.ContextBuilder;
import org.jclouds.blobstore.BlobStoreContext;
import org.jclouds.openstack.keystone.v2_0.config.CredentialTypes;
import org.jclouds.openstack.keystone.v2_0.config.KeystoneProperties;

public class AspectStorageHP {
	public Object store(MethodInvocation invocation) throws Throwable{
		
	
		
		String code=(String)invocation.getArguments()[0];
		File photo=(File)invocation.getArguments()[1];
		Properties props=new Properties();
		props.setProperty(KeystoneProperties.CREDENTIAL_TYPE, CredentialTypes.API_ACCESS_KEY_CREDENTIALS);
		
		BlobStoreContext context=ContextBuilder.newBuilder("hpcloud-objectstorage").
				credentials("", "").overrides(props).build(BlobStoreContext.class);
		
		System.out.println("Storage02HP:"+System.nanoTime());
		
		//BlobStoreContext context = new BlobStoreContextFactory().createContext("hpcloud-objectstorage", "WU7UC9PHMZR5HCJNX8TA", "tbVCFfpoVTQjRp7YjjJwz0C5lOpI0wrOg0HYptH1");
		
		//InputStreamMap input= context.createInputStreamMap("hw");
		
		
		
		//input.putFile(code+".jpg", photo);
		
		context.close();
		
		return null;
		
	}
}
