package hcu55.week04;

import java.io.*;
import java.util.*;

// 볼 모으기(greedy), 실버 I
public class 볼모으기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String ball = br.readLine();

        int redCnt = 0;
        int blueCnt = 0;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            if (ball.charAt(i) == 'R') 
                redCnt++;
            else 
                blueCnt++;
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (ball.charAt(i) == 'R')
                count++;
            else
                break;
        }
        result = Math.min(result, redCnt - count);

        count = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (ball.charAt(i) == 'R')
                count++;
            else
                break;
        }
        result = Math.min(result, redCnt - count);

        count = 0;
        for (int i = 0; i < N; i++) {
            if (ball.charAt(i) == 'B')
                count++;
            else
                break;
        }
        result = Math.min(result, blueCnt - count);

        count = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (ball.charAt(i) == 'B') 
                count++;
            else
                break;
        }
        result = Math.min(result, blueCnt - count);

        System.out.println(result);
    }
}
