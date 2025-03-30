package hcu55.week09;

import java.io.*;
import java.util.*;

// List of Unique Numbers(twoPointer), 골드 IV
public class ListofUniqueNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Set<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long result = 0;
        int left = 0, right = 0;

        while (left < N) {
            while (right < N && !set.contains(arr[right])) {
                set.add(arr[right]);
                right++;
            }

            result += (right - left);
            set.remove(arr[left]);
            left++;
        }

        System.out.println(result);
    }
}
