package hcu55.week10;

import java.io.*;
import java.util.*;

// 줄세우기(lis), 골드 IV
public class 줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        List<Integer> lis = new ArrayList<>();
        lis.add(arr[0]);

        for (int i = 1; i < N; i++) {
            int num = arr[i];
            if (lis.get(lis.size() - 1) < num) {
                lis.add(num);
            } else {
                int left = 0;
                int right = lis.size() - 1;

                while (left < right) {
                    int mid = (left + right) / 2;
                    if (lis.get(mid) < num) left = mid + 1;
                    else right = mid;
                }
                lis.set(right, num);
            }
        }

        System.out.println(N - lis.size());
    }
}
