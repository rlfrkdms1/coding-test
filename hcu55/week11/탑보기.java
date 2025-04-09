package hcu55.week11;

import java.io.*;
import java.util.*;

// 탑 보기(stack), 골드 III
public class 탑보기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] heights = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[N];
        int[] nearest = new int[N];
        Arrays.fill(nearest, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
                stack.pop();
            }
            count[i] += stack.size();
            if (!stack.isEmpty()) {
                nearest[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
                stack.pop();
            }
            count[i] += stack.size();
            if (!stack.isEmpty()) {
                if (nearest[i] == -1 || (stack.peek() - i < i - nearest[i]) ||
                    (stack.peek() - i == i - nearest[i] && stack.peek() < nearest[i])) {
                    nearest[i] = stack.peek();
                }
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (count[i] == 0) {
                sb.append("0\n");
            } else {
                sb.append(count[i]).append(" ").append(nearest[i] + 1).append("\n");
            }
        }
        System.out.print(sb);
    }
}
