package lab5;

public class LinesSumWithoutNegative {
	public int Solve(int[][] matrix) {
		int Sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			int CurrentSum = 0;
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] >=0 )
					CurrentSum += matrix[i][j];
					else {
						CurrentSum = 0;
						break;
					}
			}
			Sum += CurrentSum;
		}
		return Sum;
	}
}
