package hcu55.week03;

import java.io.*;
import java.util.*;

// 겹치는 건 싫어(towPointer), 실버 I
public class 겹치는건싫어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int maxLen = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        
        while (right < N) {
            int rightNum = arr[right];
            countMap.put(rightNum, countMap.getOrDefault(rightNum, 0) + 1);

            while (countMap.get(rightNum) > K) {
                int leftNum = arr[left];
                countMap.put(leftNum, countMap.get(leftNum) - 1);
                if (countMap.get(leftNum) == 0) {
                    countMap.remove(leftNum);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        
        System.out.println(maxLen);
    }
}
