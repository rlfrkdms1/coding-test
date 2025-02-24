package qbobl5.week05;

import java.io.*;
import java.util.*;

public class B13549 {
    static int findMinDistance(int N, int K) {
        if(N >= K) return N - K;

        int[] distance = new int[100001];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[N] = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(N);

        while(!deque.isEmpty()) {
            int current = deque.poll();
            if(current == K) break;
            int[] node = {current - 1, current + 1, current * 2};
            if(node[0] >= 0 && distance[node[0]] > distance[current] + 1) {
                distance[node[0]] = distance[current] + 1;
                deque.add(node[0]);
            }
            if(node[1] <= 100000 && distance[node[1]] > distance[current] + 1) {
                distance[node[1]] = distance[current] + 1;
                deque.add(node[1]);
            }
            if(node[2] <= 100000 && distance[node[2]] > distance[current]) {
                distance[node[2]] = distance[current];
                deque.addFirst(node[2]);
            }
        }

        return distance[K];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        System.out.println(findMinDistance(N, K));
    }
}