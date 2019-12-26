package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinesSumWithoutNegativeTest {

	@Test
	void test() {
		LinesSumWithoutNegative test1 = new LinesSumWithoutNegative();
		int output1 = test1.Solve(new int[][]{{2}});
		LinesSumWithoutNegative test2 = new LinesSumWithoutNegative();
		int output2 = test2.Solve(new int[][]{{2,2},{3,1}});
		LinesSumWithoutNegative test3 = new LinesSumWithoutNegative();
		int output3 = test3.Solve(new int[][]{{29,32,-2},{3,1,1},{1,2,3}});
		LinesSumWithoutNegative test4 = new LinesSumWithoutNegative();
		int output4 = test4.Solve(new int[][]{{20,92,-2},{-3,31,12},{6,-7,38}});
		LinesSumWithoutNegative test5 = new LinesSumWithoutNegative();
		int output5 = test5.Solve(new int[][]{{20,92,-2},{3,31,12},{6,-7,38}});
		assertEquals(2, output1);
		assertEquals(8, output2);
		assertEquals(11, output3);
		assertEquals(0, output4);
		assertEquals(46, output5);
	}

}
