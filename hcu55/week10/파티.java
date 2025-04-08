package hcu55.week10;

import java.io.*;
import java.util.*;

// 파티(dijkstra), 골드 III
public class 파티 {
    static class Edge {
        int to, cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    static int N, M, X;
    static List<Edge>[] graph;
    static final int INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, time));
        }

        int[] toHome = dijkstra(X);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            int[] toX = dijkstra(i);
            int totalTime = toX[X] + toHome[i];
            max = Math.max(max, totalTime);
        }3

        System.out.println(max);
    }

    public static int[] dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            int nowTo = now.to;
            int nowCost = now.cost;

            if (nowCost > dist[nowTo]) continue;

            for (Edge next : graph[nowTo]) {
                if (dist[next.to] > nowCost + next.cost) {
                    dist[next.to] = nowCost + next.cost;
                    pq.offer(new Edge(next.to, dist[next.to]));
                }
            }
        }
        return dist;
    }
}
