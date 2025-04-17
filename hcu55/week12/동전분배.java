package hcu55.week12;

import java.io.*;
import java.util.*;

// 동전 분배(dp+Knapsack), 골드 II
public class 동전분배 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int testCase = 1; testCase <= 3; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int[][] coins = new int[n][2];
            int sum = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                coins[i][0] = Integer.parseInt(st.nextToken());
                coins[i][1] = Integer.parseInt(st.nextToken());
                sum += coins[i][0] * coins[i][1];
            }

            if (sum % 2 != 0) {
                System.out.println(0);
                continue;
            }

            int mid = sum / 2;
            int[][] dp = new int[n + 1][mid + 1];
            for (int i = 0; i <= n; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            dp[0][0] = 0;

            for (int i = 0; i < n; i++) {
                int coin = coins[i][0];
                int cnt = coins[i][1];
                
                for (int j = 0; j <= mid; j++) {
                    if (dp[i][j] == Integer.MAX_VALUE) continue;

                    if (j + coin <= mid && dp[i][j] < cnt) {
                        dp[i][j + coin] = Math.min(dp[i][j + coin], dp[i][j] + 1);
                    }

                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j]);
                }
            }

            if (dp[n][mid] != Integer.MAX_VALUE) {
                System.out.println(1);  
            } else {
                System.out.println(0);
            }
        }
    }
}
