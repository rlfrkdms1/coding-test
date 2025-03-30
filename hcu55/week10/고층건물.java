package hcu55.week10;

import java.io.*;
import java.util.*;

// 고층 건물(math), 골드 IV
public class 고층건물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] height = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            int count = 0;

            double maxSlope = -Double.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                double slope = (double)(height[i] - height[j]) / (i - j);
                if (slope > maxSlope) {
                    maxSlope = slope;
                    count++;
                }
            }

            maxSlope = -Double.MAX_VALUE;
            for (int j = i + 1; j < N; j++) {
                double slope = (double)(height[j] - height[i]) / (j - i);
                if (slope > maxSlope) {
                    maxSlope = slope;
                    count++;
                }
            }

            result = Math.max(result, count);
        }

        System.out.println(result);
    }
}
