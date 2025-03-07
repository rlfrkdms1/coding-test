package hcu55.week06;

import java.io.*;
import java.util.*;

// 용액(two_pointer), 골드 V
public class 용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N - 1;
        int minDiff = Integer.MAX_VALUE;
        int leftResult = 0;
        int rightResult = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];
            int diff = Math.abs(sum);

            if (diff < minDiff) {
                minDiff = diff;
                leftResult = arr[left];
                rightResult = arr[right];
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(leftResult + " " + rightResult);
    }
}
