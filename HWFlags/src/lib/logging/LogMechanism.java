package lib.logging;

import healthwatcher.ConfigurationHandler;
import healthwatcher.ConfigurationHandler.Features;
import healthwatcher.cc.logging.LoggingAWS;
import healthwatcher.cc.logging.LoggingHP;
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

		if (ConfigurationHandler.getInstance().getFeature(Features.LOGGING).equals(ConfigurationHandler.AWSLOGGING)){
			LoggingAWS.storeLog(level, message);
		}/*else if(ConfigurationHandler.getInstance().getFeature(Features.LOGGING).equals(ConfigurationHandler.HPLOGGING)){
			LoggingHP.storeLog(level, message);
		}*/
		
	}

	public static void addLogToThreads() {
		Thread.setDefaultUncaughtExceptionHandler(new ThreadLogging());
	}

	public static void removeLogToThreads() {
		Thread.setDefaultUncaughtExceptionHandler(null);
	}
}
