package hcu55.week08;

import java.io.*;
import java.util.*;

// 스카이라인 쉬운거(stack), 골드 IV
public class 스카이라인쉬운거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();   
        
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(st.nextToken()); 
            int y = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek() > y) {
                stack.pop();
                answer++;
            }

            if (stack.isEmpty() || stack.peek() < y) {
                stack.push(y);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.pop() != 0) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
