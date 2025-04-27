import java.util.*;
import java.io.*;

public class Main {
    static List<List<int[]>> graph;
    static int[] visited = new int[100001];
    static Map<Integer, List<Integer>> edges = new HashMap<>();
    static Map<Integer, List<Integer>> components = new HashMap<>();
    static boolean[] isLeaf = new boolean[100001];
    static int leaf;
    static int componentIdx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(new int[]{v, i + 1});
            graph.get(v).add(new int[]{u, i + 1});
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0) {
                components.put(componentIdx, new ArrayList<>());
                edges.put(componentIdx, new ArrayList<>());
                dfs(i);
                componentIdx++;
            }
        }

        if (componentIdx >= 3) {
            System.out.println(-1);
            return;
        }

        if (componentIdx <= 1) {
            int leafNode = 0, nonLeafNode = 0;
            List<Integer> component0 = components.get(0);
            for (int x : component0) {
                if (isLeaf[x]) leafNode = x;
                else nonLeafNode = x;
            }

            component0.clear();
            edges.get(0).clear();
            Arrays.fill(visited, 0);
            visited[leafNode] = 1;
            componentIdx = 0;

            components.put(0, new ArrayList<>());
            edges.put(0, new ArrayList<>());
            dfs(nonLeafNode);

            components.put(1, new ArrayList<>());
            edges.put(1, new ArrayList<>());
            components.get(1).add(leafNode);
        }

        List<Integer> component0 = components.get(0);
        List<Integer> component1 = components.get(1);

        if (component0.size() == component1.size()) {
            System.out.println(-1);
            return;
        }

        System.out.println(component0.size() + " " + component1.size());
        printList(component0);
        printList(edges.getOrDefault(0, Collections.emptyList()));
        printList(component1);
        printList(edges.getOrDefault(1, Collections.emptyList()));
    }

    static void findLeaf(int now) {
        leaf = now;
        visited[now] = 1;
        for (int[] i : graph.get(now)) {
            if (visited[i[0]] == 0) {
                findLeaf(i[0]);
            }
        }
    }

    static void dfs(int now) {
        components.get(componentIdx).add(now);
        visited[now] = 1;
        boolean isCurrentLeaf = true;
        for (int[] neighbor : graph.get(now)) {
            if (visited[neighbor[0]] == 0) {
                edges.get(componentIdx).add(neighbor[1]);
                isCurrentLeaf = false;
                dfs(neighbor[0]);
            }
        }
        isLeaf[now] = isCurrentLeaf;
    }

    static void printList(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int x : list) {
            sb.append(x).append(' ');
        }
        System.out.println(sb);
    }
}
