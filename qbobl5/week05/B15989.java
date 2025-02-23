package qbobl5.week05;

import java.io.*;

public class B15989 {
    static int MAX = 10001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[MAX];
        for(int i=1; i<=5; i++) dp[i] = i;
        for(int i=6; i<MAX; i++) dp[i] = (i / 2) + (i / 3) + 1 + dp[i - 5];

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++) {
            int target = Integer.parseInt(br.readLine());
            sb.append(dp[target]).append("\n");
        }

        System.out.println(sb);
    }
}