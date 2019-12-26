package lab4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IntegrationTest {

	@SuppressWarnings("resource")
	public static void Test() throws IOException {
		
 		FileLogger fileLogger = new FileLogger();
		
		InputStream is = new FileInputStream("D:\\log.txt");
		BufferedReader buf = new BufferedReader(new InputStreamReader(is));
		        
		String line = buf.readLine();
		StringBuilder sb = new StringBuilder();
		        
		while(line != null){
		   sb.append(line).append("\n");
		   line = buf.readLine();
		}
		        
		String result = sb.toString();
		
		InputStream isLog = new FileInputStream("D:\\logResult.txt");
		BufferedReader bufLog = new BufferedReader(new InputStreamReader(isLog));
		        
		String lineLog = buf.readLine();
		StringBuilder sbLog = new StringBuilder();
		        
		while(lineLog != null){
		   sbLog.append(lineLog).append("\n");
		   lineLog = bufLog.readLine();
		}
		        
		String logResult = sb.toString();
		
		if (result.equals(logResult)) {
			fileLogger.Log("Integration test was successful");
			System.out.println("Integration test was successful");
		} else {
			fileLogger.Log("Integration test failed");
			System.out.println("Integration test failed");

		}
		
		fileLogger.Close();
	}
	
}
