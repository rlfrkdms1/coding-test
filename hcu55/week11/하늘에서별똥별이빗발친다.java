package hcu55.week11;

import java.io.*;
import java.util.*;

// 하늘에서 별똥별이 빗발친다(brute force), 골드 III
public class 하늘에서별똥별이빗발친다 {
    static int N, M, L, K;
    static int[][] stars;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        stars = new int[K][2];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            stars[i][0] = Integer.parseInt(st.nextToken());
            stars[i][1] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                int trampolineX = stars[i][0];
                int trampolineY = stars[j][1];

                int cnt = 0;
                for (int k = 0; k < K; k++) {
                    int starX = stars[k][0];
                    int starY = stars[k][1];

                    if (starX >= trampolineX && starX <= trampolineX + L && starY >= trampolineY && starY <= trampolineY + L) cnt++;
                }
                max = Math.max(max, cnt);
            }
        }

        System.out.println(K - max);
    }
}
