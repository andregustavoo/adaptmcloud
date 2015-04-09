package healthwatcher.storage;

import java.io.File;

import org.osoa.sca.annotations.Service;
@Service
public interface IStorage {
	public void storePhoto(String code,File file);
	public String load(String file);
}
