package hcu55.week09;

import java.io.*;
import java.util.*;

// 공유기 설치(binarySearch), 골드 IV
public class 공유기설치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] house = new int[N];
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int left = 1;
        int right = house[N - 1] - house[0];
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2; 
            int installCount = install(house, mid); 

            if (installCount >= C) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    public static int install(int[] house, int mid) {
        int count = 1; 
        int start = house[0];

        for (int i = 1; i < house.length; i++) {
            int distance = house[i] - start;
            if (distance >= mid) {
                count++;
                start = house[i];
            }
        }

        return count;
    }
}
