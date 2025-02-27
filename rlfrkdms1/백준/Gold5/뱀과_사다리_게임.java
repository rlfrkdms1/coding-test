import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int[] shortcuts = new int[101];
        Queue<int[]> queue = new LinkedList<>();
        int[] visited = new int[101];
        Arrays.fill(visited, Integer.MAX_VALUE);

        for(int i = 0; i < n + m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int index = Integer.parseInt(tokenizer.nextToken());
            int value = Integer.parseInt(tokenizer.nextToken());
            shortcuts[index] = value;
        }

        queue.offer(new int[] {1, 0});
        while(!queue.isEmpty()) {

            int[] target = queue.poll();

            if(target[1] >= visited[100] || target[0] == 100) {
                continue;
            }

            if(shortcuts[target[0]] != 0) {
                if(visited[shortcuts[target[0]]] > target[1]) {
                    visited[shortcuts[target[0]]] = target[1];
                    queue.offer(new int[] {shortcuts[target[0]], target[1]});
                }
            } 
            else { 
                for(int i = 1; i < 7; i++) {
                    if(target[0] + i <= 100 && visited[target[0] + i] > target[1] + 1) {
                        visited[target[0] + i] = target[1] + 1;
                        queue.offer(new int[] {target[0] + i, target[1] + 1});
                    }
                }
            }
        }
        System.out.println(visited[100]);
    }
}
