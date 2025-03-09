package hcu55.week06;

import java.io.*;
import java.util.*;

// 빗물(two_pointer), 골드 V
public class 빗물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] block = new int[W];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            block[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = W - 1;
        int leftMax = block[left], rightMax = block[right];
        int rain = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, block[left]);
                rain += Math.max(0, leftMax - block[left]);
            } else {
                right--;
                rightMax = Math.max(rightMax, block[right]);
                rain += Math.max(0, rightMax - block[right]);
            }
        }
        System.out.println(rain);
    }
}
