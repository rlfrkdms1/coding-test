package hcu55.week14;

import java.io.*;
import java.util.*;

// 평범한 배낭(Knapsack), 골드 V
public class 평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            for (int j = K; j >= weight; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight] + value);
            }
        }

        System.out.println(dp[K]);
    }
}
