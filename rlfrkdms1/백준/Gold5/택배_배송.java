import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        Map<Integer, List<int[]>> graphs = new HashMap<>();
        for(int i = 0; i < n; i++) graphs.put(i, new ArrayList<>());

        for(int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int v1 = Integer.parseInt(tokenizer.nextToken()) - 1;
            int v2 = Integer.parseInt(tokenizer.nextToken()) - 1;
            int value = Integer.parseInt(tokenizer.nextToken());

            graphs.get(v1).add(new int[] {v2, value});
            graphs.get(v2).add(new int[] {v1, value});
        }

        int[] values = new int[n];
        Arrays.fill(values, Integer.MAX_VALUE);
        
        Queue<int[]> queue = new PriorityQueue<>((p1, p2) -> p1[1] - p2[1]);
        queue.offer(new int[] {0, 0});
        while(!queue.isEmpty()) {
            int[] target = queue.poll();
            if(target[0] == n - 1) {
                System.out.println(target[1]);
                break;
            }
            List<int[]> connections = graphs.get(target[0]);
            for(int[] connection : connections) {
                if(values[connection[0]] > target[1] + connection[1]) {
                    values[connection[0]] = connection[1] + target[1];
                    queue.offer(new int[] {connection[0], connection[1] + target[1]});
                }
            }
        }
        
    }
}
