package lab4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger {
	private String filename = "log.txt";
	private File fileout = null;
	private BufferedWriter bufferedWriter = null;
	private FileWriter fileWriter = null;

	public void Log(String str) throws IOException {
		fileout = new File("D:\\" + filename);
		if (!fileout.exists()) {
			fileout.createNewFile();
		}
		fileWriter = new FileWriter(fileout, true);
		bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write(str + "\r\n");
		bufferedWriter.flush();
	}
	
	public void Close() throws IOException {
		bufferedWriter.close();
	}
}
