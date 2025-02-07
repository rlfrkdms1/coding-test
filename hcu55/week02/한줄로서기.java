package hcu55.week02;

import java.io.*;
import java.util.*;

// 한 줄로 서기(greedy), 실버 II
public class 한줄로서기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] result = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int position = arr[i];    // 왼쪽에 있어야 할 큰 사람 수
            int count = 0;

            for (int j = 0; j < N; j++) {
                if (result[j] == 0) {    // 빈자리 확인
                    if (count == position) {
                        result[j] = i + 1;
                        break;
                    }
                    count++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
