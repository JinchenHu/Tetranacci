import java.io.*;
import java.math.BigInteger;

public class ThirdVersion {
	public static void main(String[] args) {
		double[] measurement2 = new double[30];
		for(int i = 0; i < 30; i++) {
			measurement2[i] = secondTimingBig((i+1)*5);
		}
		PrintWriter out = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("measurement2.txt");
			out = new PrintWriter(fos);
			out.println("Timing measurement of the second version:");
			for(int i = 0; i < 30; i++) {
				String s = "The time of calculating Tetranacci("+((i+1)*5)+") is: " + measurement2[i] +"ns";
				out.println(s);
			}
			out.flush();
			System.out.println("Written successfully, the program will terminate.");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(fos != null) {
				try {
					fos.close();
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(out != null)
				out.close();
			System.exit(0);
		}
	}
	public static long[] TRTetranacci(int n) throws IllegalArgumentException{
		//throws the Exception if parameter is smaller than 0
		if(n < 0)
			throw new IllegalArgumentException("the passed argument must be nonnegative");
		//base case
		else if(n <= 3) {
			long[] a = {0, 0, 0, 0};
			return a;
		//base case
		}else if(n == 4) {
			long[] a = {1, 0, 0, 0};
			return a;
		}
		//recursive case
		else {
			long[] temp = TRTetranacci(n-1);//returns {Fn-1, Fn-2, Fn-3, Fn-4}
			//gets {Fn, Fn-1, Fn-2, Fn-3}
			long[] a = {temp[0]+temp[1]+temp[2]+temp[3],temp[0], temp[1],temp[2]};
			return a;
		}
	}//end of TRTeranacci()
	public static BigInteger[] TRTetranacciBig(int n) throws IllegalArgumentException{
		BigInteger[] big = new BigInteger[100];
		//throws the Exception if parameter is smaller than 0
		if(n < 0)
			throw new IllegalArgumentException("the passed argument must be nonnegative");
		//base case
		else if(n <= 3) {
			big[0]=BigInteger.valueOf(0);
			big[1]=BigInteger.valueOf(0);
			big[2]=BigInteger.valueOf(0);
			big[3]=BigInteger.valueOf(0);
			return big;
		//base case
		}else if(n == 4) {
			big[0]=BigInteger.valueOf(1);
			big[1]=BigInteger.valueOf(0);
			big[2]=BigInteger.valueOf(0);
			big[3]=BigInteger.valueOf(0);
			return big;
		}
		//recursive case
		else {
			BigInteger[] temp = TRTetranacciBig(n-1);//returns {Fn-1, Fn-2, Fn-3, Fn-4}
			//gets {Fn, Fn-1, Fn-2, Fn-3}
			//long[] a = {temp[0]+temp[1]+temp[2]+temp[3],temp[0], temp[1],temp[2]};
			big[0]=temp[0].add(temp[1]).add(temp[2]).add(temp[3]);
			big[1]=temp[0];
			big[2]=temp[1];
			big[3]=temp[2];
			return big;
		}
	}//end of TRTeranacci()
	
	public static double secondTimingBig(int n) {
		double start = System.nanoTime();
		BigInteger[] a = TRTetranacciBig(n);
		//BigInteger
		System.out.println("Tetranacci(" + n +")=" + a[0].toString());
		double end = System.nanoTime();
		return end - start;
	}//end of secondTiming
	
	public static double secondTiming(int n) {
		double start = System.nanoTime();
		long[] a = TRTetranacci(n);
		//BigInteger
		System.out.println("Tetranacci(" + n +")=" + Long.toString(a[0]));
		double end = System.nanoTime();
		return end - start;
	}//end of secondTiming
}
