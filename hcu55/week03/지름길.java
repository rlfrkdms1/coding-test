package hcu55.week03;

import java.io.*;
import java.util.*;

// 지름길(dijkstra), 실버 I
public class 지름길 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        List<Node>[] graph = new ArrayList[10001];
        for (int i = 0; i <= 10000; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < D; i++) {
            graph[i].add(new Node(i + 1, 1));
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (end <= D) {
                graph[start].add(new Node(end, cost));
            }
        }

        int[] distance = new int[10001];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int curPos = current.position;
            int curCost = current.cost;

            if (curCost > distance[curPos]) continue;

            for (Node next : graph[curPos]) {
                if (distance[next.position] > curCost + next.cost) {
                    distance[next.position] = curCost + next.cost;
                    queue.add(new Node(next.position, distance[next.position]));
                }
            }
        }
        System.out.println(distance[D]);
    }

    static class Node implements Comparable<Node> {
        int position;
        int cost;

        Node(int position, int cost) {
            this.position = position;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
