package qbobl5.week03;

import java.util.*;
import java.io.*;

public class B1446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[][] way = new int[N][3];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            way[i][0] = Integer.parseInt(st.nextToken());
            way[i][1] = Integer.parseInt(st.nextToken());
            way[i][2] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[D + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=1; i<=D; i++) {
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            for(int j=0; j<N; j++) if(way[j][1] == i) dp[i] = Math.min(dp[i], Math.min(dp[i - 1] + 1, dp[way[j][0]] + way[j][2]));
        }

        System.out.println(dp[D]);
    }
}