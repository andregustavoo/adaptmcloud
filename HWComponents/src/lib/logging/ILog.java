package lib.logging;

import java.util.logging.Level;

import org.osoa.sca.annotations.Service;
@Service
public interface ILog {
	public void addLog(Level level,String message);
}
