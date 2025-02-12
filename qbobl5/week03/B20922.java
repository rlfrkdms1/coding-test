package qbobl5.week03;

import java.util.*;
import java.io.*;

public class B20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr= new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 0;
        int max = 0;
        int[] count = new int[100001];

        while(right < N) {
            if(count[arr[right]] < K) {
                count[arr[right]] ++;
                right ++;
                max = Math.max(max, right - left);
            } else {
                count[arr[left]] --;
                left ++;
            }
        }

        System.out.println(max);
    }
}