import java.io.*;
import java.util.*;

public class B20188 {
    static List<Integer>[] graph;
    static int[] dp;
    static int N;
    static long sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();
        dp = new int[N + 1];
        
        StringTokenizer st;
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        dp(1);
        System.out.println(sum);
    }

    static int dp(int current) {
        dp[current] = 1;
        for(int next:graph[current]) if(dp[next] == 0) dp[current] += dp(next);
        if(current != 1)sum += calculate(N) - calculate(N - dp[current]);
        return dp[current];
    }

    static long calculate(int number) {
        return (long)number * (long)(number - 1) / 2;
    }
}
