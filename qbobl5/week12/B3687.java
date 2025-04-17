import java.io.*;
import java.util.*;

public class B3687 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        long[] dp = new long[101];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[2] = 1;
        dp[3] = 7;
        dp[4] = 4;
        dp[5] = 2;
        dp[6] = 6;
        dp[7] = 8;
        dp[8] = 10;
        
        String[] counts = {"0", "0", "1", "7", "4", "2", "0", "8"};
        for(int i=9; i<=100; i++) {
            for(int j=2; j<=7; j++) {
                String number = dp[i - j] + counts[j];
                dp[i] = Math.min(dp[i], Long.parseLong(number));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append(" ");
            if(n % 2 == 0) sb.append("1".repeat(n / 2));
            else sb.append('7').append("1".repeat(n / 2 - 1));
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}
