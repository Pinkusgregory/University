package lab4;

import java.io.IOException;
import java.util.ArrayList;

public class Program {
	public static void main(String[] args) throws IOException {
		
		Test TestSet1 = new Test();
		Test TestSet2 = new Test();
		Test TestSet3 = new Test();
		Test TestSet4 = new Test();
		Test TestSet5 = new Test();
		
		TestSet1.Name = 1;
		TestSet1.Input = new int[][]{{2}};
		TestSet1.Result = 2;
		
		TestSet2.Name = 2;
		TestSet2.Input = new int[][]{{2,2},{3,1}};
		TestSet2.Result = 8;
		
		TestSet3.Name = 3;
		TestSet3.Input = new int[][]{{29,32,-2},{3,1,1},{1,2,3}};
		TestSet3.Result = 11;
		
		TestSet4.Name = 4;
		TestSet4.Input = new int[][]{{20,92,-2},{-3,31,12},{6,-7,38}};
		TestSet4.Result = 0;

		TestSet5.Name = 5;
		TestSet5.Input = new int[][]{{0,9,3},{7,1,-126},{46,17,-9}};
		TestSet5.Result = 7;
		
		ArrayList<Test> TestSet = new ArrayList<Test>();
		TestSet.add(TestSet1);
		TestSet.add(TestSet2);
		TestSet.add(TestSet3);
		TestSet.add(TestSet4);
		TestSet.add(TestSet5);
		
		LinesSumWithoutNegativeTest.TestsComparision(TestSet);
		
		IntegrationTest.Test();
	}

}
