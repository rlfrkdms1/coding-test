import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    private static final int MAX = 300001;
    private static List<Integer>[] graph = new ArrayList[MAX];
    private static long[] subtreeSize = new long[MAX];
    private static long N, answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1);

        System.out.println(answer - combination(N));
    }

    private static long dfs(int currentNode) {
        subtreeSize[currentNode] = 1;

        for (int neighbor : graph[currentNode]) {
            if (subtreeSize[neighbor] == 0) {
                subtreeSize[currentNode] += dfs(neighbor);
            }
        }

        answer += combination(N) - combination(N - subtreeSize[currentNode]);

        return subtreeSize[currentNode];
    }

    private static long combination(long n) {
        return n * (n - 1) / 2;
    }
}
