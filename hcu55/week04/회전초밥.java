package hcu55.week04;

import java.io.*;
import java.util.*;

// 회전 초밥(sliding window), 실버 I
public class 회전초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int d = Integer.parseInt(st.nextToken()); 
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken()); 

        int[] sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d + 1];
        int unique = 0;
        int maxSushi = 0;

        for (int i = 0; i < k; i++) {
            if (count[sushi[i]] == 0) unique++;
            count[sushi[i]]++;
        }

        maxSushi = unique + (count[c] == 0 ? 1 : 0);

        for (int i = 0; i < N; i++) {
            int left = sushi[i]; 
            int right = sushi[(i + k) % N]; 

            count[left]--;
            if (count[left] == 0) unique--;

            if (count[right] == 0) unique++;
            count[right]++;

            maxSushi = Math.max(maxSushi, unique + (count[c] == 0 ? 1 : 0));
        }

        System.out.println(maxSushi);
    }
}
