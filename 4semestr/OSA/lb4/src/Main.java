import java.math.*;
import java.util.*;

public class Main {

    public static void main (String[] args){

        Solver ob1 = new Solver();
        Scanner in = new Scanner(System.in);

        System.out.println("Enter amount of criteria");
        ob1.setRow(in.nextInt());
        System.out.println("Enter amount of options");
        ob1.setColumn(in.nextInt());
        System.out.println("Enter matr");
        ob1.setMatr();
        System.out.println("Enter expertmatr");
        ob1.setExpertmatr();

        System.out.println(ob1.solution());
    }
}

class Solver {
    private int row,column;
    private float[][] matr = new float[15][15];
    private float[][] expertmatr = new float[15][15];

    public void setColumn(int column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void Showmatr() {
        for (int i = 0; i <= this.row; i++){
            for (int j = 0; j <= this.column; j++) {
                System.out.print(this.matr[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public void setMatr(float[][] matr) {
        this.matr = matr;
    }

    public void setExpertmatr(float[][] expertmatr) {
        this.expertmatr = expertmatr;
    }

    public void setMatr() {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < this.row; i++){
            System.out.println("Enter " + (i+1) + " line");
            for (int j = 0; j < this.column; j++){
                this.matr[i][j] = in.nextFloat();
            }
        }
    }

    public void setExpertmatr() {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < this.row; i++){
            System.out.println("Enter " + (i+1) + " line");
            for (int j = 0; j < this.row; j++){
                this.expertmatr[i][j] = in.nextFloat();
            }
        }
    }

    private float avggeom(float size, float[] matr){
        float result = 1;
        for (int i = 0; i < size; i++) {
            result *= matr[i];
        }
        return (float) Math.pow(result, 1/size);
    }

    public String solution(){
        float[] lvl2 = solutionlvl2();
        float[][] lvl3 = solutionlvl3();
        ArrayList<Float> koef = new ArrayList<Float>(this.column);
        for (int i = 0; i < this.column; i++) {
            float tmp = 0;
            for (int j = 0; j < this.row; j++) {
                tmp += lvl3[i][j] * lvl2[j];
            }
            koef.add(tmp);
        }
        float maxkoef = 0;
        for (int i = 0; i < koef.size(); i++) {
            maxkoef = Math.max(maxkoef, koef.get(i));
        }
        return "The best option is " + (koef.indexOf(Collections.max(koef))+1) + " K = " + Collections.max(koef);
    }

    private float[] solutionlvl2 (){
        float[] vectpriorlvl2 = new float[this.row];
        float[] tmp = new float[row];
        float avgtmp = 0;
        for (int i = 0; i < this.row; i++) {
            tmp[i] = avggeom(this.row,expertmatr[i]);
            avgtmp += tmp[i];
        }
        for (int i = 0; i < this.row; i++) {
            vectpriorlvl2[i] = tmp[i]/avgtmp;
        }
        return vectpriorlvl2;
    }

    private float[][] solutionlvl3 (){
        float[][] vectpriorlvl3 = new float[this.column][this.row];
        for (int i = 0; i < this.row; i++) {
            float[][] tmpmatr = new float[this.column][this.column];
            for (int j = 0; j < this.column; j++) {
                for (int k = 0; k < this.column; k++) {
                    tmpmatr[j][k] = this.matr[i][j]/this.matr[i][k];
                }
            }
            float[] tmp = new float[row];
            float avgtmp = 0;
            for (int j = 0; j < this.column; j++) {
                tmp[j] = avggeom(this.column, this.matr[j]);
                avgtmp += tmp[j];
            }
            for (int j = 0; j < this.column; j++) {
                vectpriorlvl3[j][i] = tmp[j]/avgtmp;
            }
        }
        return vectpriorlvl3;
    }
}