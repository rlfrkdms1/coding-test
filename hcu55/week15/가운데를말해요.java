package hcu55.week15;

import java.io.*;
import java.util.*;

// 가운데를 말해요(priorityQueue), 골드 II
public class 가운데를말해요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (left.isEmpty() || num <= left.peek()) {
                left.offer(num);
            } else {
                right.offer(num);
            }

            if (left.size() > right.size() + 1) {
                right.offer(left.poll());
            } else if (right.size() > left.size()) {
                left.offer(right.poll());
            }

            sb.append(left.peek()).append("\n");
        }

        System.out.print(sb);
    }
}
