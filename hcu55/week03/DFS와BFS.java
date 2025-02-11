package hcu55.week03;

import java.io.*;
import java.util.*;

// DFS와 BFS, 실버 II
public class DFS와BFS {
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();

        visited = new boolean[N + 1];
        bfs(V);
    }

    public static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int i = 0; i < arr.length; i++) {
            if (arr[node][i] == 1 && visited[i] == false) {
                dfs(i);
            }
        }
    }

    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(node);
        visited[node] = true;
        System.out.print(node + " ");

        while (!queue.isEmpty()) {
            int queue_node = queue.poll();
            for (int i = 0; i < arr.length; i++) {
                if (arr[queue_node][i] == 1 && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}
