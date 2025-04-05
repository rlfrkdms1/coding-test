import java.io.*;
import java.util.*;

public class B1238 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int[][] dp = new int[N+1][N+1];
		for(int i=0; i<=N; i++) {
			Arrays.fill(dp[i], 1000000000);
			dp[i][i] = 0;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			dp[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) for(int j=1; j<=N; j++) for(int k=1; k<=N; k++) dp[j][k] = Math.min(dp[j][k], dp[j][i] + dp[i][k]);
		int max = 0;
		for(int i=1; i<=N; i++) max = Math.max(max, dp[i][X] + dp[X][i]);
		System.out.println(max);
	}

}
