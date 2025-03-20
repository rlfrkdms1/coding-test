package hcu55.week08;

import java.util.*;
import java.io.*;

// 부분합(two_pointer), 골드 IV
public class 부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;

        while (true) {
            if (sum >= S) {
                minLen = Math.min(minLen, right - left);
                sum -= arr[left];
                left++;
            } else if (right == N) {
                break;
            } else {
                sum += arr[right];
                right++;
            }
        }

        System.out.println(minLen == Integer.MAX_VALUE ? 0 : minLen);
    }
}
