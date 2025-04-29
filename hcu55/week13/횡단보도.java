package hcu55.week13;

import java.io.*;
import java.util.*;

// 횡단보도(dijkstra), 골드 I
public class 횡단보도 {
    static class Node implements Comparable<Node> {
        int index;
        long time;

        Node(int index, long time) {
            this.index = index;
            this.time = time;
        }

        public int compareTo(Node o) {
            return Long.compare(this.time, o.time);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(new int[]{v, i});
            graph.get(v).add(new int[]{u, i});
        }

        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[1] = 0;
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (dist[current.index] < current.time) continue;

            for (int[] edge : graph.get(current.index)) {
                int next = edge[0];
                int signal = edge[1];
                long waitTime = 0;

                if (current.time <= signal) {
                    waitTime = signal;
                } else {
                    long cycles = (current.time - signal + M - 1) / M;
                    waitTime = signal + cycles * M;
                }

                long arrivalTime = waitTime + 1;
                if (dist[next] > arrivalTime) {
                    dist[next] = arrivalTime;
                    pq.add(new Node(next, arrivalTime));
                }
            }
        }

        System.out.println(dist[N]);
    }
}
