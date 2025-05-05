import java.io.*;
import java.util.*;

public class B12865 { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] W = new int[N];
        int[] V = new int[N];
        int[] dp = new int[K + 1];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0; i<N; i++) {
            int weight = W[i];
            for(int j=K; j>=weight; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight] + V[i]);
            }
        }

        System.out.println(dp[K]);
    }
}
