import java.util.*;
import java.io.*;

public class B5972 {
    static final int MAX = Integer.MAX_VALUE;
    
    static class Node implements Comparable<Node> {
        int index;
        int value;

        Node(int i, int v) {
            index = i;
            value = v;
        }

        public int compareTo(Node n) {
            return Integer.compare(this.value, n.value);
        }
    }
        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] values = new int[N + 1];
        Arrays.fill(values, MAX);
        values[1] = 0;
        List<List<Node>> list = new ArrayList<>();

        for(int i=0; i<=N; i++) list.add(new ArrayList<>());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(x).add(new Node(y, v));
            list.get(y).add(new Node(x, v));
        }

        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        boolean[] visited = new boolean[N + 1];

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            if(current.index == N) break;
            if(visited[current.index]) continue;
            visited[current.index] = true;
            for(Node node:list.get(current.index)) {
                if(values[node.index] < node.value + current.value) continue;
                pq.offer(new Node(node.index, node.value + current.value));
                values[node.index] = node.value + current.value;
            }
        }

        System.out.println(values[N]);
    }
}
