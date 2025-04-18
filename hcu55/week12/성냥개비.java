package hcu55.week12;

import java.io.*;
import java.util.*;

// 성냥개비(dp), 골드 II
public class 성냥개비 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            int match = Integer.parseInt(br.readLine());

            long[] dp = new long[101];
            Arrays.fill(dp, Long.MAX_VALUE);

            dp[2] = 1;
            dp[3] = 7;
            dp[4] = 4;
            dp[5] = 2;
            dp[6] = 6;
            dp[7] = 8;
            dp[8] = 10;

            String[] add = {"1", "7", "4", "2", "0", "8"};

            for (int i = 9; i <= 100; i++) {
                for (int j = 2; j <= 7; j++) {
                    String num = dp[i - j] + add[j - 2];
                    dp[i] = Math.min(dp[i], Long.parseLong(num));
                }
            }

            StringBuilder max = new StringBuilder();
            int half = match / 2;
            if (match % 2 == 1) {
                max.append("7");
                half -= 1;
            }
            for (int i = 0; i < half; i++) {
                max.append("1");
            }

            System.out.println(dp[match] + " " + max.toString());
        }
    }
}
