import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[][] costs;
    static Map<Integer, Set<Integer>> villages = new HashMap<>();
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int X = Integer.parseInt(tokenizer.nextToken()) - 1;
        costs = new int[N][N];

        for(int i = 0; i < N; i++) {
            villages.put(i, new HashSet<>());
        }

        for(int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int A = Integer.parseInt(tokenizer.nextToken()) - 1;
            int B = Integer.parseInt(tokenizer.nextToken()) - 1;
            int cost = Integer.parseInt(tokenizer.nextToken());

            costs[A][B] = cost;
            villages.get(A).add(B);
        }

        int max = 0;
        for(int i = 0; i < N; i++) {
            if(i == X) continue;
            max = Math.max(go(i, X) + go(X, i), max);
        }
        
        System.out.println(max);
    }

    private static int go(int start, int X) {
        Queue<Integer> path = new PriorityQueue<>((p1, p2) -> costs[start][p1] - costs[start][p2]);
        path.offer(start);
        
        while(!path.isEmpty()) {
            int temp = path.poll();
            for(int village : villages.get(temp)) {
                if(costs[temp][village] + costs[start][temp] <= costs[start][village] || costs[start][village] == 0) {
                    costs[start][village] = costs[temp][village] + costs[start][temp];
                    path.offer(village);
                }
            }
        }

        return costs[start][X];
    }
}
