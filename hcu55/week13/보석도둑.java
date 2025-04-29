package hcu55.week13;

import java.io.*;
import java.util.*;

// 보석 도둑(greedy+priorityQueue), 골드 II
public class 보석도둑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] jewels = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i][0] = Integer.parseInt(st.nextToken());
            jewels[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(bags);

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long total = 0;
        int index = 0;

        for (int i = 0; i < K; i++) {
            while (index < N && jewels[index][0] <= bags[i]) {
                pq.offer(jewels[index][1]);
                index++;
            }

            if (!pq.isEmpty()) total += pq.poll();
        }

        System.out.println(total);
    }
}
