package lab4;

import java.io.IOException;
import java.util.ArrayList;

public class LinesSumWithoutNegativeTest {
	 	public static void TestsComparision(ArrayList<Test> tests) throws IOException {
	 		FileLogger fileLogger = new FileLogger();
	 		for (Test t : tests) {
	 			String result;
	 			LinesSumWithoutNegative obj = new LinesSumWithoutNegative();
	 			if (obj.Solve(t.Input) == t.Result) {
	 				result = t.Name + " is Correct";
	 			}else {
					result = t.Name + " is Wrong, expected: " + Integer.toString(t.Result) + " actual: " + Integer.toString(obj.Solve(t.Input));
				}
	 			fileLogger.Log(result);
	 		}
	 		fileLogger.Close();
	 	}
}
