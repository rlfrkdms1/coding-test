import java.io.*;
import java.util.*;

public class B11401 {
	static final int MOD = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());

		System.out.println((factorial(N) * modPow(factorial(K), MOD - 2)) % MOD * modPow(factorial(N - K), MOD - 2) % MOD);
	}
    
	private static long factorial(int number) {
		long target = 1;
		for(int i=1; i<=number; i++) target = target * i % MOD;
		return target;
	}
    
	private static long modPow(long base, int exp) {
		if(exp == 1) return base;
		long number = modPow(base, exp/2) % MOD;
		number = number * number % MOD;
		if(exp % 2 == 0) return number;
		else return number * base % MOD;
	}
}
