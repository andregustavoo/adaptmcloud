package lib.logging;

import healthwatcher.ConfigurationHandler;
import healthwatcher.ConfigurationHandler.Features;
import healthwatcher.cc.logging.LoggingAWS;
import healthwatcher.cc.logging.LoggingDropbox;
import healthwatcher.cc.logging.LoggingRackspace;
import healthwatcher.storage.Storage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class LogMechanism {

	private static LogMechanism singleton;

	private int IdLog;

	private Logger logger;

	private static String logFile = System.getProperty("java.io.tmpdir") + File.pathSeparator
			+ "hw.log";

	public static synchronized LogMechanism getInstance() {
		if (singleton == null) {
			singleton = new LogMechanism();
			singleton.logger = Logger.getLogger("healthwatcher");
			singleton.IdLog = 0;
			try {
				FileHandler fh = new FileHandler(logFile);
				fh.setFormatter(new SimpleFormatter());
				singleton.logger.addHandler(fh);
			} catch (IOException e) {
			}

		}
		return singleton;
	}

	public static void configure(String file) {
		logFile = file;
	}

	public static synchronized int createOccurrence() {
		getInstance().IdLog = getInstance().IdLog + 1;
		return getInstance().IdLog;

	}
	
	public Logger getLogger(){
		return this.logger;
	}
	
	public static int getLastOccurrence() {
		return getInstance().IdLog;
	}

	public static void addLog(Level level, String message) {
		
		if (level.getName().equals("SEVERE"))
			LogMechanism.getInstance().getLogger().severe("Log ID:" + LogMechanism.getLastOccurrence() + ", Message:" + message);
		else if (level.getName().equals("WARNING"))
			LogMechanism.getInstance().getLogger().warning("Log ID:" + LogMechanism.getLastOccurrence() + ", Message:" + message);
		else if (level.getName().equals("FINE"))
			LogMechanism.getInstance().getLogger().fine("Log ID:" + LogMechanism.getLastOccurrence() + ", Message:" + message);
		else if (level.getName().equals("INFO"))
			LogMechanism.getInstance().getLogger().info("Log ID:" + LogMechanism.getLastOccurrence() + ", Message:" + message);

		if (ConfigurationHandler.getInstance().getFeature(Features.LOGGING).equals(ConfigurationHandler.AWSLOGGING)){
			LoggingAWS.storeLog(level, message);
		}else if(ConfigurationHandler.getInstance().getFeature(Features.LOGGING).equals(ConfigurationHandler.DROPBOXLOGGING)){
			LoggingDropbox.storeLog(level, message);
		}else if(ConfigurationHandler.getInstance().getFeature(Features.LOGGING).equals(ConfigurationHandler.RACKSPACELOGGING)){
			LoggingRackspace.storeLog(level, message);
		}
		
	}

	public static void addLogToThreads() {
		Thread.setDefaultUncaughtExceptionHandler(new ThreadLogging());
	}

	public static void removeLogToThreads() {
		Thread.setDefaultUncaughtExceptionHandler(null);
	}
}
