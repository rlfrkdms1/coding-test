import java.io.*;
import java.util.*;

public class B2631 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] children = new int[N];
		for(int i=0; i<N; i++) children[i] = Integer.parseInt(br.readLine());

                int[] dp = new int[N];
		for(int i=0; i<N; i++) {
			dp[i] = 1;
			for(int j=0; j<=i; j++) if(children[i] > children[j] && dp[i] <= dp[j]) dp[i] = dp[j] + 1;
		}
		
		Arrays.sort(dp);
		System.out.println(N - dp[N - 1]);
	}
}
