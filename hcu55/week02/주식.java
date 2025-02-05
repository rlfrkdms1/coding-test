package hcu55.week02;

import java.io.*;
import java.util.*;

public class 주식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int[] prices = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            int maxPrice = prices[N - 1];
            long sum = 0;

            for (int i = N - 2; i >= 0; i--) {
                if (prices[i] < maxPrice) {
                    sum += maxPrice - prices[i];
                } else {
                    maxPrice = prices[i];
                }
            }
            System.out.println(sum);
        }
    }
}
