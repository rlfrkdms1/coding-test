package hcu55.week14;

import java.io.*;
import java.util.*;

// 그래프 트리 분할(tree), 골드 I
public class 그래프트리분할 {
    static int n, m;
    static List<List<Edge>> graph;
    static boolean[] visited;
    static List<Integer> nodes, edges;
    static int dfsCnt = 0;
    static StringBuilder sb = new StringBuilder();
    static class Edge {
        int to, idx;
        Edge(int to, int idx) {
            this.to = to;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if (n <= 2) {
            System.out.println(-1);
            return;
        }

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            graph.get(u).add(new Edge(v, i));
            graph.get(v).add(new Edge(u, i));
        }

        visited = new boolean[n + 1];
        visited[0] = true;

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;

            if (dfsCnt == 2) {
                System.out.println(-1);
                return;
            }

            visited[i] = true;
            dfsCnt++;

            nodes = new ArrayList<>();
            edges = new ArrayList<>();
            nodes.add(i);
            dfs(i);

            if (edges.size() == n - 1) {
                cut();
                System.out.println(sb);
                return;
            }

            if (dfsCnt == 1) {
                if (nodes.size() * 2 == n) {
                    System.out.println(-1);
                    return;
                }
                sb.append(nodes.size()).append(" ").append(n - nodes.size()).append("\n");
            }

            for (int node : nodes) {
                sb.append(node).append(" ");
            }
            sb.append("\n");

            for (int edge : edges) {
                sb.append(edge).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int now) {
        for (Edge edge : graph.get(now)) {
            if (!visited[edge.to]) {
                visited[edge.to] = true;
                edges.add(edge.idx);
                nodes.add(edge.to);
                dfs(edge.to);
            }
        }
    }

    public static void cut() {
        sb.append(n - 1).append(" 1\n");
        for (int i = 0; i < nodes.size() - 1; i++) {
            sb.append(nodes.get(i)).append(" ");
        }
        sb.append("\n");
        
        for (int i = 0; i < edges.size() - 1; i++) {
            sb.append(edges.get(i)).append(" ");
        }
        sb.append("\n");
        
        sb.append(nodes.get(nodes.size() - 1)).append("\n");
    }
}
