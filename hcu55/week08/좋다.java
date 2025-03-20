package hcu55.week08;

import java.util.*;
import java.io.*;

// 좋다(two_pointer), 골드 IV
public class 좋다 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;

        for (int i = 0; i < N; i++) {
            if (isGood(i)) count++;
        }

        System.out.println(count);
    }

    public static boolean isGood(int index) {
        int goodNum = arr[index];

        int left = 0;
        int right = N - 1;

        while (left < right) {
            if (left == index) {
                left++;
                continue;
            }

            if (right == index) {
                right--;
                continue;
            }

            int sum = arr[left] + arr[right];

            if (sum == goodNum) return true;
            
            if (sum < goodNum) left++;
            else right--;
        }

        return false;
    }
}
