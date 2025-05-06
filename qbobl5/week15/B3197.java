import java.io.*;
import java.util.*;

public class B3197 {
    static final int MAX = 1500;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static class Node implements Comparable<Node> {
        int row;
        int col;
        int day;

        public Node(int row, int col, int day) {
            this.row = row;
            this.col = col;
            this.day = day;
        }

        @Override
        public int compareTo(Node next) {
            return Integer.compare(this.day, next.day);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Queue<Node> pq = new PriorityQueue<>();
        int[][] dayCount = new int[R][C];
        for(int i=0; i<R; i++) Arrays.fill(dayCount[i], MAX);
        
        int[] swan = new int[4];
        int index = 0;

        for(int i=0; i<R; i++) {
            String input = br.readLine();
            for(int j=0; j<C; j++) {
                if(input.charAt(j) == 'X') continue;
                dayCount[i][j] = 0;
                pq.offer(new Node(i, j, 0));
                
                if(input.charAt(j) == 'L') {
                    swan[index++] = i;
                    swan[index++] = j;
                }
            }
        }

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            for(int i=0; i<4; i++) {
                int r = current.row + dx[i];
                int c = current.col + dy[i];
                if(r < 0 || c < 0 || r >= R || c >= C || dayCount[r][c] != MAX) continue;
                dayCount[r][c] = current.day + 1;
                pq.offer(new Node(r, c, dayCount[r][c]));
            }
        }

        pq.offer(new Node(swan[0], swan[1], 0));
        boolean[][] visited = new boolean[R][C];
        visited[swan[0]][swan[1]] = true;
        
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            if(current.row == swan[2] && current.col == swan[3]) {
                System.out.println(current.day);
                break;
            }
            
            for(int i=0; i<4; i++) {
                int r = current.row + dx[i];
                int c = current.col + dy[i];
                if(r < 0 || c < 0 || r >= R || c >= C || visited[r][c]) continue;
                visited[r][c] = true;
                pq.offer(new Node(r, c, Math.max(dayCount[r][c], current.day)));
            }
        }
    }
}
