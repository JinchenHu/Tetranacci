import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstVersion {
	public static void main(String[] args) {
		double[] measurement1 = new double[8];
		for(int i = 0; i < 8; i++) {
			measurement1[i] = firstTiming((i+1)*5);
		}
		PrintWriter out = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("measurement1.txt");
			out = new PrintWriter(fos);
			out.println("Timing measurements of the first version:");
			for(int i = 0; i < 8; i++) {
				String s = "The time of calculating Tetranacci("+((i+1)*5)+") is: " + measurement1[i] +"ns";
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
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			if(out != null) {
				out.close();
			}
			System.exit(0);
		}
		
		
		
		
	}
	public static long ExponentialTetranacci(int n) throws IllegalArgumentException{
		//throws the Exception if parameter is smaller than 0
		if(n < 0)
			throw new IllegalArgumentException("the passed argument must be nonnegative");
		//base case
		else if(n<=3)
			return 0;
		//base case
		else if(n==4)
			return 1;
		//recursive case
		else
			return ExponentialTetranacci(n - 1) + ExponentialTetranacci(n - 2) + ExponentialTetranacci(n - 3) + ExponentialTetranacci(n - 4);
	}//end of ExponetialTranacci()
	
	public static double firstTiming(int n) {
		double start = System.nanoTime();
		System.out.println("Tetranacci(" + n +")=" + ExponentialTetranacci(n));
		double end = System.nanoTime();
		return end - start;
	}//end of firstTiming	
}//end of main()
