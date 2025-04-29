package hcu55.week14;

import java.io.*;
import java.util.*;

// 등산 마니아(tree+dfs+comb), 플래티넘 V
public class 등산마니아 {
    static List<Integer>[] graph;
    static int[] subTree;
    static boolean[] visited;
    static int n;
    static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        subTree = new int[n + 1];
        Arrays.fill(subTree, 1);

        visited = new boolean[n + 1];
        visited[1] = true;
        dfs(1);

        for (int i = 2; i <= n; i++) {
            int remain = n - subTree[i];
            result += comb2(n) - comb2(remain);
        }

        System.out.println(result);
    }

    public static int dfs(int now) {
        for (int next : graph[now]) {
            if (visited[next]) continue;
            visited[next] = true;
            subTree[now] += dfs(next);
        }
        return subTree[now];
    }

    public static long comb2(int x) {
        return (long) x * (x - 1) / 2;
    }
}
