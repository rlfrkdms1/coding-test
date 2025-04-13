import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 3; i++) {
            
            int N = Integer.parseInt(reader.readLine());
            int[][] coins = new int[N][2];
            
            int total = 0;
            
            for(int j = 0; j < N; j++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                coins[j] = new int[] {Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken())};
                total += coins[j][0] * coins[j][1];
            }
            
            if(total % 2 != 0) {
                System.out.println(0);
                continue;
            }

            boolean[] dp = new boolean[50_001];
            dp[0] = true;
            
            for(int[] coin : coins) {
                for(int j = 50_000; j >= coin[0]; j--) {
                    if(dp[j - coin[0]]) 
                        for(int k = 0; k < coin[1] && j + coin[0] * k <= 50_000; k++) dp[j + coin[0] * k] = true;
                }
            }

            System.out.println(dp[total / 2] ? 1 : 0);
        }
    }
}
