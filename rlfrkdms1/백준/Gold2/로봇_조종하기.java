import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        int[][] mars = new int[N][M];
        for(int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for(int j = 0; j < M; j++) {
                mars[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int[][] dp = new int[N][M];
        dp[0][0] = mars[0][0];
        for(int i = 1; i < M; i++) {
            dp[0][i] = dp[0][i-1] + mars[0][i];
        }

        for(int i = 1; i < N; i++) {

            int[] right = new int[M];
            right[0] = dp[i - 1][0] + mars[i][0];
            for(int j = 1; j < M; j++) right[j] = Math.max(dp[i - 1][j], right[j - 1]) + mars[i][j];

            int[] left = new int[M];
            left[M - 1] = dp[i - 1][M - 1] + mars[i][M - 1];
            for(int j = M - 2; j >= 0; j--) left[j] = Math.max(dp[i - 1][j], left[j + 1]) + mars[i][j];

            for(int j = 0; j < M; j++) dp[i][j] = Math.max(left[j], right[j]);
        }

        System.out.println(dp[N - 1][M - 1]);
    }
}
