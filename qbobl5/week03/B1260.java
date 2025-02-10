package qbobl5.week03;

import java.util.*;
import java.io.*;

public class B1260 {
    static int N;
    static List<List<Integer>> graph;
    static StringBuilder sb;

    static void dfs(int index, boolean[] visited) {
        sb.append(index + 1).append(" ");
        visited[index] = true;
        for(int i:graph.get(index)) if(!visited[i]) dfs(i, visited);
    }

    static void bfs(int index) {
        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        visited[index] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node + 1).append(" ");
            for(int i:graph.get(node)) {
                if(!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken()) - 1;

        graph = new ArrayList<>();
        for(int i=0; i<N; i++) graph.add(new ArrayList<>());

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        for(int i=0; i<N; i++) Collections.sort(graph.get(i));
        dfs(V, new boolean[N]);
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
    }
}