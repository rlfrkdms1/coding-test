import java.io.*;

public class B2749 {
    static final int MOD = 1000000;
    static final int PISANO = 1500000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        int size = (int)(N % PISANO);
        
        int[] dp = new int[size + 1];
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i=2; i<=size; i++) dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        System.out.println(dp[size]);
    }
}
