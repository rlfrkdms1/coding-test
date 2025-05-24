package hcu55.week16;

import java.io.*;
import java.util.*;

// 피보나치 수 3(dp+pisanoPeriod), 골드 II
public class 피보나치수3 {
    static int MOD = 1_000_000;
    static int PISANO = 1_500_000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        int r = (int)(n % PISANO);
        
        System.out.println(fibo(r));
    }

    public static int fibo(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        return dp[n];
    }
}
