package lab2;
import java.util.*;
import java.io.*;

abstract class CBuffer{
	static int IDNumb = 1;
	protected
		
		int BufCount;
		int BufID;
		int BufSize;
		
	public
	
		CBuffer(int count) {
			BufSize = count;
			BufCount = BufID = IDNumb;
			IDNumb++;
		}
		
		int GetBufCount() {
			return BufCount;
		}
		
		int GetBufID() {
			return BufID;
		}
		
		abstract Double[] Generate(Double[] mas);
}

class BBuffer extends CBuffer{
	
	protected Double[] BufElem;
	
	BBuffer(int count){
		super(count);
		BufElem = new Double[count];
		BufElem = Generate(BufElem);
	}
	
	@Override
	Double[] Generate(Double[] mas) {
		Random random = new Random();
		for (int i = 0; i < mas.length; i++) {
			mas[i] = random.nextDouble();
		} 
		return mas;
	}
}

class ABuffer extends BBuffer implements IBufferComputable,
										 IBufferPrintable,
										 IBufferSortable,
										 IBufferStorable
{
	ABuffer(int count){
		super(count);
	}
	
	public void PrintInfo() {
		System.out.println("ID= " + BufID + "\n" +
						   "Size= " + BufSize + "\n"+
						   "Type= Double");
	}
	
	public void Print() {
		for (int i = 0; i < BufElem.length; i++) {
			System.out.println(BufElem[i] + " ");
			if (i%10 == 0)
				System.out.print("\n");
		}
	}
	
	public void PrintFirstN(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(BufElem[i] + " ");
		}
	}
	
	public void PrintLastN(int n) {
		for (int i = n; i <= BufElem.length; i++) {
			System.out.println(BufElem[i] + " ");
		}
	}
	
	public void Sort() {
		for (int i = 0; i < BufElem.length; i++) {
	        Double min = BufElem[i];
	        int min_i = i; 
	        for (int j = i+1; j < BufElem.length; j++) {
	            if (BufElem[j] < min) {
	                min = BufElem[j];
	                min_i = j;
	            }
	        }
	        if (i != min_i) {
	            Double tmp = BufElem[i];
	            BufElem[i] = BufElem[min_i];
	            BufElem[min_i] = tmp;
	        }
	     }

	}
	
	public void Min() {
		Double min = BufElem[0];
		for(int i = 0; i != BufElem.length; i ++){
            if(BufElem[i] < min) {
                min = BufElem[i];
            }
		}
		System.out.println("Min = " + min);
	}
	
	public void SaveSeparateLines(String filename) throws IOException {
		File fileout = null;
		BufferedWriter bufferedWriter = null;
		FileWriter fileWriter = null;
		fileout = new File("E:\\" + filename);
		if (!fileout.exists()) {
			fileout.createNewFile();
		}
		fileWriter = new FileWriter(fileout,true);
		bufferedWriter = new BufferedWriter(fileWriter);
		for (int i = 0; i < BufElem.length; i++) {
			bufferedWriter.newLine();
			bufferedWriter.write(BufElem[i] + "");
		}
		bufferedWriter.write("\r\n");
		bufferedWriter.flush();
		bufferedWriter.close();
	}
}


public class lab {
	
	public static void main(String[] args) throws IOException {
		int N = 7;
		int L = 40;
		ABuffer[] BufferMas = new ABuffer[N];
		for (int i = 0; i < BufferMas.length; i++) {
			BufferMas[i] = new ABuffer(L);
		}
		for(ABuffer buffers : BufferMas) {
			buffers.PrintInfo();
			buffers.PrintFirstN(10);
			buffers.Min();
			buffers.Sort();
			buffers.PrintFirstN(10);
			buffers.SaveSeparateLines("1.txt");
		}
	}
}

