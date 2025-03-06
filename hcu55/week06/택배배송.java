package hcu55.week06;

import java.io.*;
import java.util.*;

// 택배 배송(dijkstra), 골드 V
public class 택배배송 {
    static List<List<Node>> graph = new ArrayList<>();
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }

        System.out.println(dijkstra(N));
    }

    public static int dijkstra(int N) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        pq.add(new Node(1, 0));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int nowIndex = now.index;
            int nowCost = now.cost;

            if (nowCost > dist[nowIndex]) continue;

            for (Node next : graph.get(nowIndex)) {
                int nextIndex = next.index;
                int nextCost = nowCost + next.cost;

                if (nextCost < dist[nextIndex]) {
                    dist[nextIndex] = nextCost;
                    pq.add(new Node(nextIndex, nextCost));
                }
            }
        }
        return dist[N];
    }

    public static class Node {
        int index;
        int cost;
        
        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}
