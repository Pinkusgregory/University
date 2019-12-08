import java.math.*;
import java.util.*;

public class Main {

    public static void main (String[] args){

        int a = 4;
        int b = 5;
        int c = 4;
        int d = 3;



        Solver ob1 = new Solver();
        Solver ob2 = new Solver();
        Solver ob3 = new Solver();

        System.out.println("Enter a");
        ob1.setMatr1stline(a);
        System.out.println("Enter 1st matr");
        ob1.setMatr(b, a);
        ob1.Showmatr(b, a);
        System.out.println("Enter 2nd matr");
        ob2.setMatr(c, b);
        ob2.Showmatr(c, b);
        System.out.println("Enter 3rd matr");
        ob3.setMatr(d, c);
        ob3.Showmatr(d, c);

        ob1.solution(b, a);
        ob2.setMatr1stline(b, ob1);
        ob2.solution(c, b);
        ob3.setMatr1stline(c, ob2);
        ob3.solution(d, c);

        ob1.Showmatr(b, a);
        ob2.Showmatr(c, b);
        ob3.Showmatr(d, c);

        float result;
        result = Math.max(ob3.GetMatrEl(3,0),Math.max(ob3.GetMatrEl(1,0), ob3.GetMatrEl(2, 0)));
        System.out.println("Result= " + result);
    }
}

class Solver {
    private float[][] matr = new float[10][10];
    private float sum = 0;
    Solver(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++) {
                this.matr[i][j] = 0;
            }
        }
    }
    public float GetMatrEl(int row, int column){
        return matr[row][column];
    }
    public void setMatr1stline(int column){
        Scanner in = new Scanner(System.in);
        for (int i = 1; i <= column; i++){
            matr[0][i] = in.nextFloat();
        }
    }
    public void setMatr1stline(int column, Solver ob){
        for (int i = 1; i <= column; i++){
            this.matr[0][i] = ob.GetMatrEl(i, 0);
        }
    }

    public void Showmatr(int row, int column) {
        for (int i = 0; i <= row; i++){
            for (int j = 0; j <=column; j++) {
                System.out.print(this.matr[i][j] + "   ");
            }
            System.out.println();
        }
    }
    public void setMatr(int row, int column) {
        Scanner in = new Scanner(System.in);
        for (int i = 1; i <= row; i++){
            System.out.println("Enter " + i + " line");
            for (int j = 1; j <= column; j++){
                matr[i][j] = in.nextFloat();
            }
        }
    }

    public void solution(int row, int column){
        for (int i = 1; i <= row; i++){
            float sum1 = 0;
            for (int j = 1; j <= column; j++){
                sum1 += matr[i][j]*matr[0][j];
            }
            matr[i][0] = sum1;
            sum += sum1;
        }
        for (int i = 1; i <= row; i++){
            matr[i][0] = matr[i][0]/sum;
        }
    }
}