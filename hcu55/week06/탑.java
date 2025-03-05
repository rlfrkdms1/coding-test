package hcu55.week06;

import java.io.*;
import java.util.*;

// 탑(impl), 골드 V
public class 탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] towers = new int[N];
        int[] result = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
        }

        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < towers[i]) {
                stack.pop();  
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek()[1];
            } else {
                result[i] = 0;
            }

            stack.push(new int[]{towers[i], i + 1});
        }

        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
