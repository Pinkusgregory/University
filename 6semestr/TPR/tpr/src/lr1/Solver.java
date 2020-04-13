package lr1;

public class Solver {

    static void Solve(int[][] array) {
        int[] maxR = new int[10];

        int count = array.length;
        int k = 0;
        int k1 = 1;
        while (count > 0) {
            for (int i = 0; i < array.length; i++) {
                int sum = 0;
                for (int j = 0; j < array.length; j++) {
                    sum += array[i][j];
                }
                if (sum == 0) {
                    k += 1;
                    maxR[k] = i;
                    System.out.print(maxR[k] + 1 + " ");
                }
            }

            System.out.println();

            for (int q = k1; q <= k; q++) {
                for (int j = 0; j < array.length; j++) {
                    array[maxR[q]][j] = 1;
                }
            }

            for (int q = k1; q <= k; q++) {
                for (int i = 0; i < array.length; i++) {
                    array[i][maxR[q]] = 0;
                }
            }

            k1 = k + 1;
            count = array.length - k;
        }

    }

    public static void main(String[] args) {

        int[][] matr1 = { { 0, 1, 1, 0, 1 },
                { 0, 0, 1, 1, 0 },
                { 0, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 } };

        int[][] matr2 = {
                { 0, 1, 1, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1 },
                { 0, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 0, 1, 0, 1, 0 },
                { 0, 0, 0, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 0, 0, 0 }
        };


        Solve(matr1);
        System.out.println("-----------------------");
        Solve(matr2);
    }

}
