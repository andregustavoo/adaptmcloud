package healthwatcher.cc.logging;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.file.Files;
import java.util.logging.Level;

public class UtilsStorage {
	public static File createFile(int ocurrence,Level level, String message){
		
		String filename="log-"+ocurrence+".log";
		String contents="Level:"+level.getName()+"\n Message:"+message;
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
	              new FileOutputStream(filename), "utf-8"))) {
	   writer.write(contents);
	   writer.flush();
	   writer.close();
	   return new File(filename);
	} catch ( IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	}
}
