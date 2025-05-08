import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 
	private final static long mod = 1000000007;
    
	public static void main(String[] args) throws IOException {
 
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		
		long N = Long.parseLong(tokenizer.nextToken());
		long K = Long.parseLong(tokenizer.nextToken());
		
		long numer = factorial(N);
		long denom = factorial(K) * factorial(N - K) % mod;	
	
		System.out.println(numer * pow(denom, mod - 2) % mod);
	}
	
	
	private static long factorial(long N) {
		long number = 1L;
		while(N > 1) number = (number * N--) % mod;
		return number;
	}
	
	private static long pow(long base, long expo) {
		if(expo == 1) return base % mod;
		
		long temp = pow(base, expo / 2);
		
		if(expo % 2 == 1) return (temp * temp % mod) * base % mod;
	
		return temp * temp % mod;
	}
}
