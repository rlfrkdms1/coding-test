import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());

        int[] matches = {0, 0, 1, 7, 4, 2, 0, 8, 10};

        long[] dp = new long[101];
        for(int i = 0; i < matches.length; i++) dp[i] = matches[i];
        dp[6] = 6;

        for(int i = 9; i < 101; i++) {
            dp[i] = dp[i - 2] * 10 + matches[2];
            for(int j = 3; j < 8; j++) dp[i] = Math.min(dp[i], dp[i - j] * 10 + matches[j]);
        }

        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < size; i++) {
            int n = Integer.parseInt(reader.readLine());

            answer.append(dp[n]).append(" ");

            if(n % 2 != 0) answer.append("7");
            else answer.append("1");
            
            for(int j = 0; j < (n / 2) - 1; j++) answer.append("1");

            answer.append("\n");
        }

        System.out.println(answer.toString());
    }
}
