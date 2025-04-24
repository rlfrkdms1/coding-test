import java.io.*;
import java.util.*;

public class B24042 {
	static int N, M;
	static long[] min;
	static List<Node>[] list;

    static class Node implements Comparable<Node> {
		int location;
		long time;

		public Node(int location, long time) {
			this.location = location;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.time, o.time);
		}
	}

    static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1, 0));
		min[1] = 0;
        
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if(node.location == N) {
				System.out.println(node.time);
				return;
			}
            
			if(node.time > min[node.location]) continue;
			for(Node n:list[node.location]) {
				long time = ((node.time / M) + (node.time % M > n.time ? 1 : 0)) * M + n.time;
				if(min[n.location] <= time) continue;
				min[n.location] = time;
				pq.offer(new Node(n.location, time));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = new long[N + 1];
        
		Arrays.fill(min, Long.MAX_VALUE);
		list = new ArrayList[N + 1];
        
		for(int i=1; i<=N; i++) list[i] = new ArrayList<>();
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, i));
			list[end].add(new Node(start, i));
		}
        
		dijkstra();
	}
}
