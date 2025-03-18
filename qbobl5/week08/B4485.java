import java.util.*;
import java.io.*;

public class B4485 {
    static class Node implements Comparable<Node> {
        int row;
        int col;
        int rupee;

        Node(int r, int c, int v) {
            row = r;
            col = c;
            rupee = v;
        }

        public int compareTo(Node n) {
            return Integer.compare(this.rupee, n.rupee);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int testCount = 1;
        
        while(N != 0) {
            int[][] cave = new int[N][N];
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) cave[i][j] = Integer.parseInt(st.nextToken());
            }
            
            boolean[][] visited = new boolean[N][N];
            Queue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(0, 0, cave[0][0]));
            int result = 0;

            while(!pq.isEmpty()) {
                Node current = pq.poll();
                visited[current.row][current.col] = true;
                if(current.row == N - 1 && current.col == N - 1) {
                    result = current.rupee;
                    break;
                }
                
                for(int i=0; i<4; i++) {
                    int r = current.row + dx[i];
                    int c = current.col + dy[i];
                    if(r < 0 || c < 0 || r >= N || c >= N) continue;
                    if(visited[r][c]) continue;
                    pq.offer(new Node(r, c, cave[r][c] + current.rupee));
                }
            }

            sb.append("Problem ").append(testCount++).append(": ").append(result).append("\n");
            N = Integer.parseInt(br.readLine());
        }

        System.out.println(sb);
    }
}
